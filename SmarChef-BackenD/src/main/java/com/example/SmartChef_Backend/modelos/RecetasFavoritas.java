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
@Table(name="recetas_favoritas")
public class RecetasFavoritas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_receta")
    private Recetas receta;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuario;

}
