package com.example.SmartChef_Backend.dto;

import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "El id no puede estar vacio")
    private Integer idUsuario;
    @NotBlank(message = "El id no puede estar vacio")
    private Integer idReceta;

    @NotBlank(message = "La fecha cocinado no puede estar vacia")
    @Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$",message = "Indica un formato valido para la fecha")
    private LocalDate fecha_cocinado;

    @NotBlank(message = "La fecha visitado no puede estar vacia")
    @Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$",message = "Indica un formato valido para la fecha")
    private LocalDate fecha_visitado;
}
