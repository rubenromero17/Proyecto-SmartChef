package com.example.SmartChef_Backend.servicios;

import com.example.SmartChef_Backend.dto.UsuarioDTO;
import com.example.SmartChef_Backend.modelos.Usuarios;
import com.example.SmartChef_Backend.repositorios.UsuariosRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class UsuariosService {

    private UsuariosRepositorio repositorio;

    @Transactional
    public void crearUsuario(UsuarioDTO dto) {
        Usuarios usuarios = new Usuarios();

        usuarios.setNombre(dto.getNombre());
        usuarios.setFechaNacimiento(dto.getFechaNacimiento());
        usuarios.setEmail(dto.getEmail());
        usuarios.setContrasena(dto.getContrasena());
        usuarios.setDireccion(dto.getDireccion());
        usuarios.setUrlImagen(dto.getUrlImagen());
        usuarios.setPreferencia(dto.getPreferencias());
        usuarios.setFechaRegistro(LocalDate.now());
        repositorio.save(usuarios);
    }

}