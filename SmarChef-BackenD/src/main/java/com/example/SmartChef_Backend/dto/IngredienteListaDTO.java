package com.example.SmartChef_Backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IngredienteListaDTO {

    @NotBlank(message = "El id no puede estar vacio")
    private Integer idIngrediente;

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 1,max = 30)
    private String nombre;

    @NotBlank(message = "La cantidad no puede estar vacia")
    private Integer cantidad;
    @NotBlank
    private String comprado;
}
