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
@Table(name="fotos_recetas")
public class FotosRecetas {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "url_imagen",nullable = false)
    private String urlImagen;

    @OneToOne
    @JoinColumn(name = "id_receta",nullable = false)
    private Recetas receta;





}
