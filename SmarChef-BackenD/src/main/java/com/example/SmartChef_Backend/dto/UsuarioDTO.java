package com.example.SmartChef_Backend.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@Data
@Builder
public class UsuarioDTO {
    private Integer id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String email;
    private String contrasena;
    private String direccion;
    private String url_imagen;
    private String preferencias;



    private Set<Integer> coleccionesId; //oneToMany
    private Set<Integer> listaComprasId; //oneToMany

}
