package com.example.SmartChef_Backend.dto;


import com.example.SmartChef_Backend.modelos.Recetas;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecetaDTO {

    private Integer id;

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 1,max = 45)
    private String nombre;

    @NotBlank(message = "La descripcion no puede estar vacia")
    @Size(min = 1, max = 100)
    private String descripcion;


    @NotNull
    @Positive
    private Integer tiempoPreparacion;

    @NotBlank(message = "La URL no puede estar vacia")
    @Size(max = 255)
    @URL(message = "La URL debe ser valida")
    private String urlImagen;


    private String dificultad;

    private Boolean economica;

    private Boolean vegetariana;

    private Boolean sin_gluten;

    private Boolean rapido;


    private List<InstruccionesDTO> instrucciones;

    private List<IngredientesDTO> ingredientes;

}
