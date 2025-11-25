package com.example.SmartChef_Backend.modelos;
import com.example.SmartChef_Backend.modelos.Etiquetas;
import com.example.SmartChef_Backend.modelos.Recetas;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
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
@Table(name="recetas_etiquetas")
public class RecetasEtiquetas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_receta")
    private Recetas receta;

    @ManyToOne
    @JoinColumn(name = "id_etiqueta")
    private Etiquetas etiqueta;
}
