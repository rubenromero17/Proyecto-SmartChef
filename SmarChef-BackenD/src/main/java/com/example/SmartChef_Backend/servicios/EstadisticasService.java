package com.example.SmartChef_Backend.servicios;

import com.example.SmartChef_Backend.dto.EstadisticasIngredientesDTO;
import com.example.SmartChef_Backend.dto.EstadisticasRecetasDTO;
import com.example.SmartChef_Backend.repositorios.RecetaIngredientesRepositorio;
import com.example.SmartChef_Backend.repositorios.RecetasFavoritasRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EstadisticasService {

    private RecetaIngredientesRepositorio recetaIngredientesRepositorio;
    private RecetasFavoritasRepositorio recetasFavoritasRepositorio;

    public List<EstadisticasIngredientesDTO> top5Ingredientes() {
        List<EstadisticasIngredientesDTO> todos = recetaIngredientesRepositorio.findTopIngredientes();
        if(todos.isEmpty()){
            throw new RuntimeException();
        }
        else return todos.stream().limit(5).toList();
    }


    public List<EstadisticasRecetasDTO> top5Recetas() {
        List<EstadisticasRecetasDTO> favoritas = recetasFavoritasRepositorio.findRecetasFavoritas();
        if(favoritas.isEmpty()){
            throw new RuntimeException();
        }
        return favoritas.stream().limit(5).toList();
    }


}
