package com.example.SmartChef_Backend.dto;

import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "No puede estar en blanco")
    private String nombreReceta;
    @NotBlank(message = "No puede estar en blanco")
    private Long cantidadFavoritas;
}
