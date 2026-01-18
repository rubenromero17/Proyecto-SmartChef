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
@Table(name="colecciones", schema = "smartchef")
public class Colecciones {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "nombre",length = 255,nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuarios usuario;

}
