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
@Table(name="fotosRecetas")
public class fotosRecetas {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "url_imagen",nullable = false)
    private String urlImagen;

    @OneToOne
    @JoinColumn(name = "id_receta",nullable = false)
    private recetas receta;





}
