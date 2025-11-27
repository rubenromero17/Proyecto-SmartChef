package com.example.SmartChef_Backend.controladores;


import com.example.SmartChef_Backend.dto.UsuarioDTO;
import com.example.SmartChef_Backend.mapper.UsuariosMapper;
import com.example.SmartChef_Backend.modelos.Usuarios;
import com.example.SmartChef_Backend.repositorios.UsuariosRepositorio;
import com.example.SmartChef_Backend.servicios.UsuariosServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
AllArgsConstructor
public class UsuarioControlador {



    private UsuariosServicio usuariosServicio;

    private UsuariosMapper usuariosMapper;

    private UsuariosRepositorio usuariosRepositorio;


    //EndPoint para eliminar un usuario
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Usuarios usuarios) {
        usuariosServicio.eliminarUsuario(usuarios);
    }


    @PostMapping
        public void crearUsuario(@RequestBody UsuarioDTO usuarioDTO){
        usuariosServicio.crearUsuario(usuarioDTO);

    }


}
