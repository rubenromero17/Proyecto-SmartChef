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

    @Column (name = "fecha_registro", nullable = false)
    private LocalDate fechaRegistro;

    @OneToOne(cascade = CascadeType.ALL , mappedBy = "usuarios", fetch = FetchType.LAZY)
    private FotoPerfilUsuario fotoPerfilUsuario;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "usuarios", fetch = FetchType.LAZY)
    private Set<Colecciones> colecciones = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "usuarios", fetch = FetchType.LAZY)
    private Set<ListaCompras> listaCompras = new HashSet<>();

}
