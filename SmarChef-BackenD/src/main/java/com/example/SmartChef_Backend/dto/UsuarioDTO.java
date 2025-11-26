package com.example.SmartChef_Backend.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
public class UsuarioDTO {
    private Integer id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String email;
    private String password;
    private String direccion;
    private LocalDate fechaDeNacimiento;
    private String preferencia;



    private Integer fotoPerfil; //oneToONE
    private Set<Integer> coleccionesId; //oneToMany
    private Set<Integer> listaComprasId; //oneToMany

}
