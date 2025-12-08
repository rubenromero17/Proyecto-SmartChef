package com.example.SmartChef_Backend.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CrearListaDTO {
    private Integer idUsuario;
    private Integer idReceta;
}
