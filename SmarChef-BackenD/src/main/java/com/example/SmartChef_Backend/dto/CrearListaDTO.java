package com.example.SmartChef_Backend.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CrearListaDTO {
    @NotNull
    private Integer idUsuario;
    @NotNull
    private Integer idReceta;
}
