package com.example.SmartChef_Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstadisticasIngredientesDTO {

    private String nombreIngrediente;
    private Long numeroReceta;
}
