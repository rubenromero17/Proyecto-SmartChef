package com.example.SmartChef_Backend.modelos;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@NoArgsConstructor

@Entity
@Table(name="usuarios")
public class Usuarios {
    public enum PreferenciaAlimentaria {
        economica,
        vegetariana,
        sinGluten,
        rapido
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column (name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column (name = "email",length = 150, nullable = false)
    private String email;

    @Column (name = "contrasena", nullable = false)
    private String contrasena;

    @Column (name = "direccion", nullable = false)
    private String direccion;

    @Enumerated(EnumType.STRING)
    @Column (name = "preferencias", nullable = false )
    private PreferenciaAlimentaria preferencia;

    @Column (name= "url_imagen",nullable = true)
    private String urlImagen;


    @Column (name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;



}
