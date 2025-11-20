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
@Table(name="recetas")
public class receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nombre", length = 150,nullable = false)
    private String nombre;

    @Column (name = "descripcion", length = 200)
    private String descripcion;

    @Column (name = "tiempo_preparacion", nullable = false)
    private Integer tiempoPreparacion;

    @Column (name = "dificultad", length = 50, nullable = false)
    private String dificultad;

}
