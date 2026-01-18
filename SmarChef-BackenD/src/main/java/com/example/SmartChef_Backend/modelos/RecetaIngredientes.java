package com.example.SmartChef_Backend.modelos;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@NoArgsConstructor

@Entity
@Table(name="receta_ingredientes", schema = "smartchef")
public class RecetaIngredientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receta_ingredientes")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_receta")
    private Recetas receta;

    @ManyToOne
    @JoinColumn(name = "id_ingrediente")
    private Ingredientes ingrediente;

    @Column(name = "cantidad",nullable = false)
    private Double cantidad;

}
