package com.example.SmartChef_Backend.modelos;
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
@Table(name="lista_compras")
public class ListaCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "fecha_creacion",nullable = false)
    private LocalDate fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuario;


}
