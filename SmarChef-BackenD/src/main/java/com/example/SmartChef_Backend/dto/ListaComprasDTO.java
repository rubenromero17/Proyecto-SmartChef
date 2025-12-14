package com.example.SmartChef_Backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListaComprasDTO {
    @NotNull
    private Integer idLista;
    @NotNull
    private Integer idUsuario;

    @NotBlank(message = "La fecha creacion no puede estar vacia")
    @Pattern(regexp = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$",message = "Indica un formato valido para la fecha")
    private LocalDate fechaCreacion;

    @NotBlank(message = "No se puede pasar una lista vacia")
    private List<IngredienteListaDTO> ingredientes;


}
