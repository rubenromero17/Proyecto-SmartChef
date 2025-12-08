package com.example.SmartChef_Backend.dto;

import com.example.SmartChef_Backend.modelos.Ingredientes;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IngredientesDTO {
    @NotBlank
    private Integer id;
    @NotBlank
    private String nombre;
    @NotBlank
    private Integer cantidad;
}
