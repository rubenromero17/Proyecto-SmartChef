package com.example.SmartChef_Backend.repositorios;
import com.example.SmartChef_Backend.modelos.HistorialCocina;
import com.example.SmartChef_Backend.modelos.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface HistorialCocinaRepositorio extends JpaRepository<HistorialCocina, Integer> {
  List<HistorialCocina> findByUsuarioAndFechaVisitadoAfter(Usuarios usuario, LocalDate fecha);
}
