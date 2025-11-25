package com.example.SmartChef_Backend.modelos;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@NoArgsConstructor

@Entity
@Table(name="receta_ingredientes")
public class RecetaIngredientes {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cantidad",nullable = false)
    private Integer cantidad;

    @ManyToOne
    @JoinColumn(name = "id_receta")
    private Recetas receta;

    @ManyToOne
    @JoinColumn(name = "id_ingrediente")
    private Ingredientes ingrediente;

}

