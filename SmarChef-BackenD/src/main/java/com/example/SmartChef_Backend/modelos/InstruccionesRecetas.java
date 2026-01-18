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
@Table(name="instrucciones_receta", schema = "smartchef")
public class InstruccionesRecetas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_instruccion")
    private Integer id;

    @Column (name = "paso_numero",nullable = false)
    private Integer paso_numero;

    @Column (name = "descripcion", length = 255,nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_receta")
    private Recetas receta;


}
