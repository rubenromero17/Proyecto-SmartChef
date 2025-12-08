package com.example.SmartChef_Backend.dto;


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
    private Integer idUsuario;
    private Integer idReceta;
    private LocalDate fecha_cocinado;
}
