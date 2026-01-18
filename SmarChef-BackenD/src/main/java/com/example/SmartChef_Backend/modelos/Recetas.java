package com.example.SmartChef_Backend.modelos;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@NoArgsConstructor

@Entity
@Table(name="recetas", schema = "smartchef")
public class Recetas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receta")
    private Integer id;

    @Column (name = "nombre", length = 150,nullable = false)
    private String nombre;

    @Column (name = "descripcion", length = 200)
    private String descripcion;

    @Column (name = "tiempo_preparacion", nullable = false)
    private Integer tiempoPreparacion;

    @Column (name= "url_imagen",nullable = false)
    private String urlImagen;

    @Column (name = "dificultad",nullable = false)
    private String dificultad;

    @Column (name = "economica",nullable = false)
    private Boolean economica;

    @Column (name = "vegetariana",nullable = false)
    private Boolean vegetariana;

    @Column (name = "sin_gluten",nullable = false)
    private Boolean sin_gluten;

    @Column (name = "rapido",nullable = false)
    private Boolean rapido;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "receta_ingredientes",
            joinColumns = @JoinColumn(name = "id_receta", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_ingrediente", nullable = false)
    )
    private Set<Ingredientes> ingredientes = new HashSet<>();


}
