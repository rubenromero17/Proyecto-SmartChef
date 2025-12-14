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
public class HistorialCocinaDTO {

    @NotNull(message = "El idUsuario no puede ser nulo")
    private Integer idUsuario;
    @NotNull(message = "El idReceta no puede ser nulo")
    private Integer idReceta;

    @NotNull(message = "La fecha de cocinado no puede ser nula")
    private LocalDate fecha_cocinado;

    private LocalDate fecha_visitado;
}
