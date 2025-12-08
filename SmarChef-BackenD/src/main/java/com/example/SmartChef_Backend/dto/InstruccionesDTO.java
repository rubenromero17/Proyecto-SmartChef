package com.example.SmartChef_Backend.dto;

import com.example.SmartChef_Backend.modelos.InstruccionesRecetas;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "El id no puede estar vacio")
    private Integer id;

    @NotBlank(message = "El paso no puede estar vacio")
    private Integer paso_numero;

    @NotBlank(message = "La descripcion no puede estar vacia")
    @Size(min = 1, max = 100)
    private String descripcion;

}
