package com.example.SmartChef_Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FiltroRecetasDTO {
    private List<String> ingredientes;
    private Boolean economica;
    private Boolean vegetariana;
    private Boolean sin_gluten;
    private Boolean rapido;
}
