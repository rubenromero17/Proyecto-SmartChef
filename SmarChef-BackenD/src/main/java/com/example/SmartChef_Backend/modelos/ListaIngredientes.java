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
@Table(name="lista_ingredientes")
public class ListaIngredientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lista_ingredientes")
    private Integer id;

    @Column(name = "cantidad",nullable = false)
    private Integer cantidad;

    @Column(name = "comprado",nullable = false)
    @Enumerated(EnumType.STRING)
    private Comprado comprado;

    public enum Comprado { Si, No }

    @ManyToOne
    @JoinColumn(name = "id_lista")
    private ListaCompras listaCompras;

    @ManyToOne
    @JoinColumn(name = "id_ingrediente")
    private Ingredientes ingredientes;


}
