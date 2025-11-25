package com.example.SmartChef_Backend.modelos;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
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
    private Integer id;

    @Column(name = "cantidad",nullable = false)
    private Integer cantidad;

    @Column(name = "comprado",nullable = true)
    private String comprado;

    @ManyToOne
    @JoinColumn(name = "id_lista")
    private ListaCompras listaCompras;

    @ManyToOne
    @JoinColumn(name = "id_ingredientes")
    private Ingredientes ingredientes;


}
