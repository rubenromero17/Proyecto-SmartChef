package com.example.SmartChef_Backend.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CrearListaDTO {
    @NotBlank(message = "El id no puede estar vacio")
    private Integer idUsuario;
    @NotBlank(message = "El id no puede estar vacio")
    private Integer idReceta;
}
