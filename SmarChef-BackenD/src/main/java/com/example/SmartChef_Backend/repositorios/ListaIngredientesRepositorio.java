package com.example.SmartChef_Backend.repositorios;

import com.example.SmartChef_Backend.modelos.ListaIngredientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaIngredientesRepositorio extends JpaRepository<ListaIngredientes,Integer> {
}
