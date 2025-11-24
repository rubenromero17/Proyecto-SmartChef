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
@Table(name="listaCompras")
public class listaCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "fecha_creacion",nullable = false)
    private LocalDate fechaCreacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private usuarios usuario;

}
