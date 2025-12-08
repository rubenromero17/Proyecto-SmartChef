package com.example.SmartChef_Backend.repositorios;
import com.example.SmartChef_Backend.modelos.ListaCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListaComprasRepositorio extends JpaRepository<ListaCompras, Integer> {
}
