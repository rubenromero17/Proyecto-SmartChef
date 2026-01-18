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
@Table(name="ingredientes", schema = "smartchef")
public class Ingredientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ingrediente")
    private Integer id;

    @Column (name = "nombre", length = 50,nullable = false)
    private String nombre;
}
