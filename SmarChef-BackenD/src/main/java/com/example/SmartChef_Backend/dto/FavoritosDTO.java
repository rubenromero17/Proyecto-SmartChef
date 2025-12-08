package com.example.SmartChef_Backend.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoritosDTO {
    @NotBlank(message = "El id no puede estar vacio")
    private Integer usuarioId;
}
