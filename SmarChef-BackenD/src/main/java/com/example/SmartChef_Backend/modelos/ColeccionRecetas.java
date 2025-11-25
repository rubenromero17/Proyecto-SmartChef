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
@Table(name="coleccion_recetas")
public class ColeccionRecetas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_coleccion")
    private Colecciones coleccion;

    @ManyToOne
    @JoinColumn(name = "id_receta")
    private Recetas receta;
}
