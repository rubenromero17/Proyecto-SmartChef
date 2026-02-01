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
@Table(name="recetas_favoritas", schema = "smartchef")
public class RecetasFavoritas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_recetas_favoritas")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_receta", nullable = false)
    private Recetas receta;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuarios usuario;

}

