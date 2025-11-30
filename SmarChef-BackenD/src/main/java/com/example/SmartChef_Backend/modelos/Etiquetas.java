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
@Table(name="etiquetas")
public class Etiquetas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "nombre",length = 50,nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_etiqueta")
    private Etiquetas etiqueta;
}
