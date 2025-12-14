package com.example.SmartChef_Backend.repositorios;
import com.example.SmartChef_Backend.modelos.Ingredientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientesRepositorio extends JpaRepository<Ingredientes, Integer> {




}
