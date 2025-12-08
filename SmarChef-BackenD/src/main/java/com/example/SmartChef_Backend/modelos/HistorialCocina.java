package com.example.SmartChef_Backend.modelos;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@NoArgsConstructor

@Entity
@Table(name="historial_cocina")
public class HistorialCocina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Integer id;

    @Column(name = "fecha_visitado",nullable = false)
    private LocalDate fechaVisitado;

    @Column(name = "fecha_cocinado",nullable = true)
    private LocalDate fechaCocinado;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuario;

    @ManyToOne
    @JoinColumn(name = "id_receta")
    private Recetas receta;
}
