package com.example.SmartChef_Backend.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoritayUsuarioDTO {
    @NotNull
    private Integer idReceta;
    @NotBlank
    private String nombreReceta;
    @NotBlank
    private String nombreUsuario;
}
