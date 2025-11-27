package com.example.SmartChef_Backend.repositorios;

import com.example.SmartChef_Backend.dto.UsuarioDTO;
import com.example.SmartChef_Backend.modelos.Usuarios;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UsuariosRepositorio extends Repository<Usuarios, Integer> {

    List<Usuarios> getUsuariosRepositorio();

    Usuarios findByEmail(String email);
    Usuarios findByEmailAndPassword(String email, String password);

    Usuarios getUsuariosById(Integer id);

    Usuarios save(Usuarios usuario);
    Usuarios update(Usuarios usuario);
    void delete(Usuarios usuario);





}
