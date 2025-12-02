package com.example.SmartChef_Backend.servicios;

import com.example.SmartChef_Backend.dto.IngredientesDTO;
import com.example.SmartChef_Backend.dto.RecetaDTO;
import com.example.SmartChef_Backend.modelos.InstruccionesRecetas;
import com.example.SmartChef_Backend.modelos.Recetas;
import com.example.SmartChef_Backend.repositorios.RecetasRepositorio;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class RecetaService {

    private RecetasRepositorio repositorio;

    @Transactional
    public Recetas agregarReceta(RecetaDTO recetaDTO){
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
        return receta;
    }

}
