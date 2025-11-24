package com.example.SmartChef_Backend.modelos;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name="colecciones")
public class colecciones {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "nombre",length = 255,nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private usuarios usuario;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "coleccion_recetas",
            joinColumns = {@JoinColumn(name = "id_coleccion", nullable = false)},
            inverseJoinColumns = { @JoinColumn(name = "id_receta", nullable = false)})
    @JsonManagedReference
    private Set<recetas> recetas = new HashSet<>();



}
