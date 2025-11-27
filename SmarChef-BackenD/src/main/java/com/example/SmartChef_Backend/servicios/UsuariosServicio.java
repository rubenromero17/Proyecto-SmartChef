package com.example.SmartChef_Backend.servicios;

import com.example.SmartChef_Backend.dto.UsuarioDTO;
import com.example.SmartChef_Backend.mapper.UsuariosMapper;
import com.example.SmartChef_Backend.modelos.Usuarios;
import com.example.SmartChef_Backend.repositorios.UsuariosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UsuariosServicio {

    @Autowired
    private UsuariosRepositorio usuariosRepositorio;

    @Autowired
    private UsuariosMapper usuariosMapper;

   public void crearUsuario(UsuarioDTO usuarioDTO){
       Usuarios usuarios = new Usuarios();

       usuarios.setNombre(usuarioDTO.getNombre());
       usuarios.setEmail(usuarioDTO.getEmail());
       usuarios.setContrasena(usuarioDTO.getContrasena());

       repository.save(usuarios);
   }

    public void eliminarUsuario(Usuarios usuario) {
        usuariosRepositorio.delete(usuario);
    }
}
