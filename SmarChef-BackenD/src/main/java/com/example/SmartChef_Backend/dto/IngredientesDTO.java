package com.example.SmartChef_Backend.dto;

import com.example.SmartChef_Backend.modelos.Ingredientes;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IngredientesDTO {
    @NotNull(message = "El id no puede ser nulo")
    private Integer id;
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;
    @NotNull(message = "La cantidad no puede ser nula")
    private Integer cantidad;
}
