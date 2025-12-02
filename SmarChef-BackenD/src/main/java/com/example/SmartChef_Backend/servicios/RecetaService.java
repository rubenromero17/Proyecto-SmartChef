package com.example.SmartChef_Backend.servicios;

import com.example.SmartChef_Backend.dto.IngredientesDTO;
import com.example.SmartChef_Backend.dto.InstruccionesDTO;
import com.example.SmartChef_Backend.dto.RecetaDTO;
import com.example.SmartChef_Backend.modelos.Ingredientes;
import com.example.SmartChef_Backend.modelos.InstruccionesRecetas;
import com.example.SmartChef_Backend.modelos.Recetas;
import com.example.SmartChef_Backend.repositorios.InstruccionesRecetasRepositorio;
import com.example.SmartChef_Backend.repositorios.RecetasRepositorio;
import lombok.AllArgsConstructor;
import org.hibernate.mapping.Set;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor

public class RecetaService {

    private RecetasRepositorio repositorio;
    private InstruccionesRecetasRepositorio repositorioInstrucciones;

    @Transactional
    public void agregarReceta(RecetaDTO recetaDTO){
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

        repositorio.save(receta);
        List<InstruccionesRecetas> instrucciones = recetaDTO.getInstrucciones().stream()
                .map(i -> new InstruccionesRecetas(i.getId(),i.getPaso_numero(),i.getDescripcion())
                .collect(Collectors.toList());

        repositorioInstrucciones.saveAll(instrucciones);


    }

}
