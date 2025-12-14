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
    @NotNull(message = "El idUsuario no puede ser nulo")
    private Integer idUsuario;
    @NotNull(message = "El idReceta no puede ser nulo")
    private Integer idReceta;
}
