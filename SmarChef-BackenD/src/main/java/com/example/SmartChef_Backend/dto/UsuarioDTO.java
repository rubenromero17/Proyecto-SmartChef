package com.example.SmartChef_Backend.dto;

import com.example.SmartChef_Backend.modelos.Usuarios;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO {

    @NotBlank(message = "Debes indicar el nombre no puede estar vacia")
    private String nombre;

    @NotNull(message = "La fecha no puede estar vacia")
    @Past(message = "La fecha de nacimiento deber ser en el pasado")
    private LocalDate fechaNacimiento;

    @NotBlank(message = "El mensaje no puede ser nulo")
    @Email
    private String email;

    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, max = 20, message = "La contraseña debe tener entre 8 y 255 caracteres")
    private String contrasena;

    @NotBlank(message = "Debes indicar una direccion valida")
    @Size(min = 1, max = 100)
    @Pattern(regexp =  "^[A-Za-zÁÉÍÓÚáéíóúñÑ\\.\\s]+,\\s*\\d+[A-Za-z]?$",message = "La direccion tiene que ser: Nombre de la calle, numero")
    private String direccion;

    @NotBlank(message = "La URL no puede estar vacia")
    @Size( max = 255)
    @URL(message = "La URL debe ser valida")
    private String urlImagen;

    @NotBlank(message = "La preferencia no puede estar vacía")
    @Pattern(regexp = "^(economica|vegetariana|sin_gluten|rapido)$", message = "Preferencia inválida. Debe ser: economica, vegetariana, sin_gluten o rapido")
    private String preferencias;


    private LocalDate fechaRegistro;
}
