package com.example.SmartChef_Backend.modelos;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@NoArgsConstructor

@Entity
@Table(name="usuarios")
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column (name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column (name = "email",length = 150,nullable = false)
    private String email;

    @Column (name = "contrasena",nullable = false)
    private String contrasena;

    @Column (name = "direccion",nullable = false)
    private String direccion;

    @Column (name = "fecha_registro",nullable = false)
    private LocalDate fechaRegistro;

}
