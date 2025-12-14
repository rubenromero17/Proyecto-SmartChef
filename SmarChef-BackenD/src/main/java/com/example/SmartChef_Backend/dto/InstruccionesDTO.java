package com.example.SmartChef_Backend.dto;

import com.example.SmartChef_Backend.modelos.InstruccionesRecetas;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotNull(message = "El id no puede ser nulo")
    private Integer id;

    @NotNull(message = "El paso no puede ser nulo")
    private Integer paso_numero;

    @NotBlank(message = "La descripcion no puede estar vacia")
    @Size(min = 1, max = 100)
    private String descripcion;

}
