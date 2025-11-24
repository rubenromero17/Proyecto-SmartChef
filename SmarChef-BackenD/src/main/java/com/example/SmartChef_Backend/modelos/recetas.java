package com.example.SmartChef_Backend.modelos;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name="recetas")
public class recetas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "nombre", length = 150,nullable = false)
    private String nombre;

    @Column (name = "descripcion", length = 200)
    private String descripcion;

    @Column (name = "tiempo_preparacion", nullable = false)
    private Integer tiempoPreparacion;

    @Column (name = "dificultad", length = 50, nullable = false)
    private String dificultad;

    @Column (name = "economica", length = 50,nullable = true)
    private String economica;

    @Column (name = "vegetariana", length = 50,nullable = true)
    private String vegetariana;

    @Column (name = "sin_gluten", length = 50,nullable = true)
    private String sin_gluten;

    @Column (name = "rapido", length = 50,nullable = true)
    private String rapido;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recetas" , fetch = FetchType.LAZY)
    private Set<instruccionesRecetas> instruccionesRecetas = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "recetas", fetch = FetchType.LAZY)
    private fotosRecetas fotosRecetas;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "recetas_favoritas",
            joinColumns = {@JoinColumn(name = "id_receta", nullable = false)},
            inverseJoinColumns = { @JoinColumn(name = "id_usuario", nullable = false)})
    @JsonManagedReference
    private Set<usuarios> usuarios = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "coleccion_recetas",
            joinColumns = {@JoinColumn(name = "id_receta", nullable = false)},
            inverseJoinColumns = { @JoinColumn(name = "id_coleccion", nullable = false)})
    @JsonManagedReference
    private Set<colecciones> colecciones = new HashSet<>();

}
