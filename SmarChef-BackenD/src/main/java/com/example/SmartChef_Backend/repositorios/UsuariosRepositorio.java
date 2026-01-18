package com.example.SmartChef_Backend.repositorios;


import com.example.SmartChef_Backend.modelos.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepositorio extends JpaRepository<Usuarios,Integer> {
    Usuarios findByNombre(String nombre);
    Usuarios findByEmail(String email);
    Usuarios findByNombreAndEmail(String nombre, String email);
    boolean existsByEmail(String email);
    boolean existsByNombre(String nombre);


}
