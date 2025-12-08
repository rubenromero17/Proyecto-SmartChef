package com.example.SmartChef_Backend.dto;

import com.example.SmartChef_Backend.modelos.InstruccionesRecetas;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InstruccionesDTO {
    private Integer id;
    private Integer paso_numero;
    private String descripcion;

}
