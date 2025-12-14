package com.example.SmartChef_Backend.servicios;

import com.example.SmartChef_Backend.dto.EstadisticasIngredientesDTO;
import com.example.SmartChef_Backend.dto.EstadisticasRecetasDTO;
import com.example.SmartChef_Backend.dto.FavoritayUsuarioDTO;
import com.example.SmartChef_Backend.exception.ElementoNoEncontradoException;
import com.example.SmartChef_Backend.repositorios.RecetaIngredientesRepositorio;
import com.example.SmartChef_Backend.repositorios.RecetasFavoritasRepositorio;
import jakarta.transaction.Transactional;
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
            throw new RuntimeException("No tienes ingredientes registrados");
        }
        else return todos.stream().limit(5).toList();
    }


    @Transactional
    public List<FavoritayUsuarioDTO> obtenerRecetasFavoritasPorUsuario() {
        List<FavoritayUsuarioDTO> favoritas = recetasFavoritasRepositorio.recetasFavoritas();
        if (favoritas.isEmpty()) {
            throw new ElementoNoEncontradoException("Usuario no encontrado");
        }
        return favoritas;
    }

}
