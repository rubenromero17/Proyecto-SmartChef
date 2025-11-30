package com.example.SmartChef_Backend.repositorios;


import com.example.SmartChef_Backend.dto.UsuarioDTO;
import com.example.SmartChef_Backend.modelos.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UsuariosRepositorio extends JpaRepository<Usuarios,Integer> {


    Usuarios findByNombre(String nombre);
    Usuarios findByEmail(String email);
    Usuarios findByNombreAndEmail(String nombre, String email);
    Usuarios save(UsuarioDTO usuario);
}
