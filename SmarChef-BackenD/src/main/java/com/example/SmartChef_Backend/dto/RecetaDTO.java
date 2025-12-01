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
    private String economica;
    private String vegetariana;
    private String sin_gluten;
    private String rapido;

    private List<InstruccionesDTO> instrucciones;
    private List<IngredientesDTO> ingredientes;


}
