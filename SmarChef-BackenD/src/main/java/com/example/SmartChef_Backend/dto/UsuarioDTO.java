package com.example.SmartChef_Backend.dto;

import com.example.SmartChef_Backend.modelos.Usuarios;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO {
    private String nombre;
    private LocalDate fechaNacimiento;
    private String email;
    private String contrasena;
    private String direccion;
    private String urlImagen;
    private String preferencias;
    private LocalDate fechaRegistro;
}
