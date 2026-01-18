package com.example.SmartChef_Backend.servicios;

import com.example.SmartChef_Backend.dto.*;
import com.example.SmartChef_Backend.exception.ElementoNoEncontradoException;
import com.example.SmartChef_Backend.modelos.Ingredientes;
import com.example.SmartChef_Backend.modelos.InstruccionesRecetas;
import com.example.SmartChef_Backend.modelos.RecetaIngredientes;
import com.example.SmartChef_Backend.modelos.Recetas;
import com.example.SmartChef_Backend.repositorios.*;
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
    private RecetasFavoritasRepositorio repositorioRecetasFavoritas;

    @Transactional
    public void agregarReceta(RecetaDTO recetaDTO) {
        if (repositorio.existsByNombre(recetaDTO.getNombre())) {
            throw new IllegalArgumentException("El nombre de la receta ya existe");
        }

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
            List<String> nombresIngredientes = repositorioRecetaIngredientes.findByRecetaId(receta.getId())
                    .stream()
                    .map(ri -> ri.getIngrediente().getNombre())
                    .collect(Collectors.toList());


            if (ingredientesFiltro != null && !ingredientesFiltro.isEmpty()) {
                boolean contieneTodos = ingredientesFiltro.stream()
                        .allMatch(nombresIngredientes::contains);
                if (!contieneTodos) continue;
            }

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

            List<InstruccionesDTO> instruccionesDTO =
                    repositorioInstrucciones.findByReceta_Id(receta.getId())
                            .stream()
                            .map(i -> new InstruccionesDTO(
                                    i.getId(),
                                    i.getPaso_numero(),
                                    i.getDescripcion()
                            ))
                            .collect(Collectors.toList());

            dto.setInstrucciones(instruccionesDTO);


            listaDTO.add(dto);
        }

        return listaDTO;
    }

    @Transactional
    public RecetaDTO verDetallesRecetas(Integer id) {
        Recetas receta = repositorio.findById(id)
                .orElseThrow(() -> new ElementoNoEncontradoException("Receta no encontrada"));

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


    @Transactional
    public List<RecetaDTO> obtenerTodasLasRecetas() {
        List<Recetas> recetas = repositorio.findAll();
        List<RecetaDTO> listaDTO = new ArrayList<>();

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

            List<InstruccionesDTO> instruccionesDTO = repositorioInstrucciones.findByReceta_Id(receta.getId())
                    .stream()
                    .map(i -> new InstruccionesDTO(i.getId(), i.getPaso_numero(), i.getDescripcion()))
                    .collect(Collectors.toList());
            dto.setInstrucciones(instruccionesDTO);

            listaDTO.add(dto);
        }

        return listaDTO;

    }

    public List<RecetaTarjetaDTO> obtenerTodasLasRecetasParaTarjeta() {
        List<Recetas> recetas = repositorio.findAll();
        List<RecetaTarjetaDTO> listaDTO = new ArrayList<>();

        for (Recetas r : recetas) {
            RecetaTarjetaDTO dto = new RecetaTarjetaDTO();
            dto.setId(r.getId());
            dto.setNombre(r.getNombre());
            dto.setUrlImagen(r.getUrlImagen());
            dto.setTiempoPreparacion(r.getTiempoPreparacion());

            List<RecetaIngredientes> ingredientes = repositorioRecetaIngredientes.findByRecetaId(r.getId());
            dto.setNumeroIngredientes(ingredientes.size());

            List<String> activos = new ArrayList<>();
            if (r.getVegetariana()) activos.add("Vegetariana");
            if (r.getSin_gluten()) activos.add("Sin Gluten");
            if (r.getRapido()) activos.add("Rápido");
            if (r.getEconomica()) activos.add("Económica");

            dto.setBooleanosActivos(activos);

            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @Transactional
    public void eliminarReceta(Integer id) {
        Recetas receta = repositorio.findById(id)
                .orElseThrow(() -> new ElementoNoEncontradoException("Receta no encontrada"));
        repositorio.delete(receta);
    }

    @Transactional
    public void editarReceta(RecetaDTO recetaDTO) {
        Recetas recetaExistente = repositorio.findById(recetaDTO.getId())
                .orElseThrow(() -> new ElementoNoEncontradoException("Receta no encontrada"));

        recetaExistente.setNombre(recetaDTO.getNombre());
        recetaExistente.setDescripcion(recetaDTO.getDescripcion());
        recetaExistente.setTiempoPreparacion(recetaDTO.getTiempoPreparacion());
        recetaExistente.setUrlImagen(recetaDTO.getUrlImagen());
        recetaExistente.setDificultad(recetaDTO.getDificultad());
        recetaExistente.setEconomica(recetaDTO.getEconomica());
        recetaExistente.setVegetariana(recetaDTO.getVegetariana());
        recetaExistente.setSin_gluten(recetaDTO.getSin_gluten());
        recetaExistente.setRapido(recetaDTO.getRapido());


        repositorio.save(recetaExistente);

        List<RecetaIngredientes> ingredientesExistentes = repositorioRecetaIngredientes.findByRecetaId(recetaDTO.getId());
        repositorioRecetaIngredientes.deleteAll(ingredientesExistentes);

        for (IngredientesDTO ingredienteDTO : recetaDTO.getIngredientes()) {
            Ingredientes ingrediente = new Ingredientes();
            ingrediente.setNombre(ingredienteDTO.getNombre());
            Ingredientes ingredienteGuardado = repositorioIngredientes.save(ingrediente);

            RecetaIngredientes ri = new RecetaIngredientes();
            ri.setReceta(recetaExistente);
            ri.setIngrediente(ingredienteGuardado);
            ri.setCantidad(ingredienteDTO.getCantidad());

            repositorioRecetaIngredientes.save(ri);
        }

        List<InstruccionesRecetas> instruccionesExistentes = repositorioInstrucciones.findByReceta_Id(recetaDTO.getId());
        repositorioInstrucciones.deleteAll(instruccionesExistentes);

        int paso = 1;
        for (InstruccionesDTO instrDTO : recetaDTO.getInstrucciones()) {
            InstruccionesRecetas instrucciones = new InstruccionesRecetas();
            instrucciones.setReceta(recetaExistente);
            instrucciones.setPaso_numero(paso++);
            instrucciones.setDescripcion(instrDTO.getDescripcion());
            repositorioInstrucciones.save(instrucciones);
        }
    }


    public RecetaDTO buscarRecetaPorId(Integer id) {
        Recetas receta = repositorio.findById(id)
                .orElseThrow(() -> new ElementoNoEncontradoException("Receta no encontrada"));

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


        List<RecetaIngredientes> ingredientesReceta = repositorioRecetaIngredientes.findByRecetaId(id);
        List<IngredientesDTO> ingredientesDTO = ingredientesReceta.stream()
                .map(ri -> new IngredientesDTO(
                        ri.getIngrediente().getId(),
                        ri.getIngrediente().getNombre(),
                        ri.getCantidad()
                ))
                .collect(Collectors.toList());
        dto.setIngredientes(ingredientesDTO);


        List<InstruccionesRecetas> instrucciones = repositorioInstrucciones.findByReceta_Id(id);
        List<InstruccionesDTO> instruccionesDTO = instrucciones.stream()
                .map(i -> new InstruccionesDTO(i.getId(), i.getPaso_numero(), i.getDescripcion()))
                .collect(Collectors.toList());
        dto.setInstrucciones(instruccionesDTO);

        return dto;
    }

}


