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
@Table(name="foto_perfil_usuario")
public class fotoPerfilUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url_imagen",length = 255,nullable = false)
    private String urlImagen;

    @OneToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private usuario usuario;

}
