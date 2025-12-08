package com.example.SmartChef_Backend.dto;

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
    private Integer idLista;
    private Integer idUsuario;
    private LocalDate fechaCreacion;
    private List<IngredienteListaDTO> ingredientes;


}
