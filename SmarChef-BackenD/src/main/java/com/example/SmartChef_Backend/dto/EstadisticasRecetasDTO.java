package com.example.SmartChef_Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstadisticasRecetasDTO {
    private String nombreReceta;
    private Long cantidadFavoritas;
}
