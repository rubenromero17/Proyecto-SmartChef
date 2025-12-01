package com.example.SmartChef_Backend.dto;

import com.example.SmartChef_Backend.modelos.Ingredientes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class IngredientesDTO {
    private Integer id;
    private String nombre;
    private Integer cantidad;
}
