package com.example.SmartChef_Backend.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoritosDTO {
    @NotNull(message = "El id de la receta no puede ser nulo")
    private Integer usuarioId;
}
