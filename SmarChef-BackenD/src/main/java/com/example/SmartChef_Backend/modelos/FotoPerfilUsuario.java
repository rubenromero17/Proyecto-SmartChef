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
@Table(name="foto_perfil_usuario")
public class FotoPerfilUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "url_imagen",length = 255,nullable = false)
    private String urlImagen;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuarios usuario;

}
