package com.example.SmartChef_Backend.servicios;

import com.example.SmartChef_Backend.dto.UsuarioDTO;
import com.example.SmartChef_Backend.modelos.Usuarios;
import com.example.SmartChef_Backend.repositorios.UsuariosRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UsuariosService {

    private UsuariosRepositorio repositorio;


    @Transactional
    public void crearUsuario(UsuarioDTO usuario) {
        Usuarios usuarios = new Usuarios();

        usuarios.setNombre(usuario.getNombre());
        usuarios.setFechaNacimiento(usuario.getFechaNacimiento());
        usuarios.setEmail(usuario.getEmail());
        usuarios.setContrasena(usuario.getContrasena());
        usuarios.setDireccion(usuario.getDireccion());
        usuarios.setUrlImagen(usuario.getUrl_imagen());
        usuarios.setPreferencia(Usuarios.PreferenciaAlimentaria.valueOf(usuario.getPreferencias()));

        repositorio.save(usuario);

    }

}