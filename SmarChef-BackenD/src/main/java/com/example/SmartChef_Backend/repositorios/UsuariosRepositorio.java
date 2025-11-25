package com.example.SmartChef_Backend.repositorios;

import com.example.SmartChef_Backend.modelos.Usuarios;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UsuariosRepositorio extends Repository<Usuarios, Integer> {

    List<Usuarios> findByNombre(String nombre);

}
