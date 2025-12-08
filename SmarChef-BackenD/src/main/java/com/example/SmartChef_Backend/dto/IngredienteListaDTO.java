package com.example.SmartChef_Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IngredienteListaDTO {
    private Integer idIngrediente;
    private String nombre;
    private Integer cantidad;
    private String comprado;
}
