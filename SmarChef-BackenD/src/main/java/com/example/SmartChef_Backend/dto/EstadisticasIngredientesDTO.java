package com.example.SmartChef_Backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstadisticasIngredientesDTO {
    @NotBlank(message = "No puede estar en blanco")
    private String nombreIngrediente;
    @NotBlank(message = "No puede estar en blanco")
    private Long numeroReceta;
}
