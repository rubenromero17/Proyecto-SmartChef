package com.example.SmartChef_Backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecetaTarjetaDTO {
    private Integer id;

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 1,max = 45)
    private String nombre;

    @NotNull(message = "El tiempo de preparacion no puede ser nulo")
    @Positive
    private Integer tiempoPreparacion;

    @NotBlank(message = "La URL no puede estar vacia")
    @Size(max = 255)
    @URL(message = "La URL debe ser valida")
    private String urlImagen;

    private List<String> booleanosActivos;
    private Integer numeroIngredientes;

}
