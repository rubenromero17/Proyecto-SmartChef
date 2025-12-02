package com.example.SmartChef_Backend.dto;


import com.example.SmartChef_Backend.modelos.Recetas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@Builder
public class RecetaDTO {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Integer tiempoPreparacion;
    private String urlImagen;
    private String dificultad;
    private Boolean economica;
    private Boolean vegetariana;
    private Boolean sin_gluten;
    private Boolean rapido;

    List<InstruccionesDTO> instrucciones;
    List<IngredientesDTO> ingredientes;

}
