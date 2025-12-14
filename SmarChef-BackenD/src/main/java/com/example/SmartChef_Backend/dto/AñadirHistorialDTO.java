package com.example.SmartChef_Backend.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AñadirHistorialDTO {
    @NotNull
    private Integer idUsuario;
    @NotNull
    private Integer idReceta;

    @NotNull
    private LocalDate fecha_cocinado;
}
