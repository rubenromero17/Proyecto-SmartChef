package com.example.SmartChef_Backend.servicios;

import com.example.SmartChef_Backend.dto.FiltroRecetasDTO;
import com.example.SmartChef_Backend.dto.IngredientesDTO;
import com.example.SmartChef_Backend.dto.InstruccionesDTO;
import com.example.SmartChef_Backend.dto.RecetaDTO;
import com.example.SmartChef_Backend.modelos.Ingredientes;
import com.example.SmartChef_Backend.modelos.InstruccionesRecetas;
import com.example.SmartChef_Backend.modelos.RecetaIngredientes;
import com.example.SmartChef_Backend.modelos.Recetas;
import com.example.SmartChef_Backend.repositorios.IngredientesRepositorio;
import com.example.SmartChef_Backend.repositorios.InstruccionesRecetasRepositorio;
import com.example.SmartChef_Backend.repositorios.RecetaIngredientesRepositorio;
import com.example.SmartChef_Backend.repositorios.RecetasRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RecetaService {

    private RecetasRepositorio repositorio;
    private InstruccionesRecetasRepositorio repositorioInstrucciones;
    private IngredientesRepositorio repositorioIngredientes;
    private RecetaIngredientesRepositorio repositorioRecetaIngredientes;

    @Transactional
    public void agregarReceta(RecetaDTO recetaDTO) {

        Recetas receta = new Recetas();
        receta.setNombre(recetaDTO.getNombre());
        receta.setDescripcion(recetaDTO.getDescripcion());
        receta.setTiempoPreparacion(recetaDTO.getTiempoPreparacion());
        receta.setUrlImagen(recetaDTO.getUrlImagen());
        receta.setDificultad(recetaDTO.getDificultad());
        receta.setEconomica(recetaDTO.getEconomica());
        receta.setVegetariana(recetaDTO.getVegetariana());
        receta.setSin_gluten(recetaDTO.getSin_gluten());
        receta.setRapido(recetaDTO.getRapido());

        Recetas recetaGuardada = repositorio.save(receta);

        for (IngredientesDTO ingredienteDTO : recetaDTO.getIngredientes()) {

            Ingredientes ingrediente = new Ingredientes();
            ingrediente.setNombre(ingredienteDTO.getNombre());
            Ingredientes ingredienteGuardado = repositorioIngredientes.save(ingrediente);

            RecetaIngredientes ri = new RecetaIngredientes();
            ri.setReceta(recetaGuardada);
            ri.setIngrediente(ingredienteGuardado);
            ri.setCantidad(ingredienteDTO.getCantidad());

            repositorioRecetaIngredientes.save(ri);
        }

        int paso = 1;
        for (InstruccionesDTO instrDTO : recetaDTO.getInstrucciones()) {
            InstruccionesRecetas instrucciones = new InstruccionesRecetas();
            instrucciones.setReceta(recetaGuardada);
            instrucciones.setPaso_numero(paso++);
            instrucciones.setDescripcion(instrDTO.getDescripcion());
            repositorioInstrucciones.save(instrucciones);
        }
    }

    public List<RecetaDTO> buscarRecetasPorFiltro(FiltroRecetasDTO filtro) {
        List<RecetaDTO> listaDTO = new ArrayList<>();

        List<String> ingredientesFiltro = filtro.getIngredientes();

        List<Recetas> recetas = repositorio.buscarRecetasConFiltros(
                (ingredientesFiltro != null && ingredientesFiltro.isEmpty()) ? null : ingredientesFiltro,
                filtro.getEconomica(),
                filtro.getVegetariana(),
                filtro.getSin_gluten(),
                filtro.getRapido()
        );

        for (Recetas receta : recetas) {
            RecetaDTO dto = new RecetaDTO();
            dto.setId(receta.getId());
            dto.setNombre(receta.getNombre());
            dto.setDescripcion(receta.getDescripcion());
            dto.setTiempoPreparacion(receta.getTiempoPreparacion());
            dto.setUrlImagen(receta.getUrlImagen());
            dto.setDificultad(receta.getDificultad());
            dto.setEconomica(receta.getEconomica());
            dto.setVegetariana(receta.getVegetariana());
            dto.setSin_gluten(receta.getSin_gluten());
            dto.setRapido(receta.getRapido());


            List<RecetaIngredientes> riList = repositorioRecetaIngredientes.findByRecetaId(receta.getId());
            List<IngredientesDTO> ingredientesDTO = riList.stream()
                    .map(ri -> new IngredientesDTO(
                            ri.getIngrediente().getId(),
                            ri.getIngrediente().getNombre(),
                            ri.getCantidad()
                    ))
                    .collect(Collectors.toList());
            dto.setIngredientes(ingredientesDTO);

            listaDTO.add(dto);
        }

        return listaDTO;
    }
    @Transactional
    public RecetaDTO verDetallesRecetas(Integer id) {
        Recetas receta = repositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Receta no encontrada"));

        RecetaDTO recetaDTO = new RecetaDTO();
        recetaDTO.setId(receta.getId());
        recetaDTO.setNombre(receta.getNombre());
        recetaDTO.setDescripcion(receta.getDescripcion());
        recetaDTO.setTiempoPreparacion(receta.getTiempoPreparacion());
        recetaDTO.setUrlImagen(receta.getUrlImagen());
        recetaDTO.setDificultad(receta.getDificultad());
        recetaDTO.setEconomica(receta.getEconomica());
        recetaDTO.setVegetariana(receta.getVegetariana());
        recetaDTO.setSin_gluten(receta.getSin_gluten());
        recetaDTO.setRapido(receta.getRapido());

        List<RecetaIngredientes> ingredientesReceta = repositorioRecetaIngredientes.findByRecetaId(id);
        List<IngredientesDTO> ingredientesDTO = ingredientesReceta.stream()
                .map(ri -> new IngredientesDTO(
                        ri.getIngrediente().getId(),
                        ri.getIngrediente().getNombre(),
                        ri.getCantidad()
                ))
                .collect(Collectors.toList());
        recetaDTO.setIngredientes(ingredientesDTO);


        List<InstruccionesRecetas> instrucciones = repositorioInstrucciones.findByReceta_Id(id);
        List<InstruccionesDTO> instruccionesDTO = instrucciones.stream()
                .map(i -> new InstruccionesDTO(i.getId(), i.getPaso_numero(), i.getDescripcion()))
                .collect(Collectors.toList());
        recetaDTO.setInstrucciones(instruccionesDTO);

        return recetaDTO;
    }

}

