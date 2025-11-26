package com.example.SmartChef_Backend.controladores;


import com.example.SmartChef_Backend.modelos.Usuarios;
import com.example.SmartChef_Backend.servicios.UsuariosServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {


    @Autowired
    private UsuariosServicio usuariosServicio;


    //EndPoint para eliminar un usuario
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Usuarios usuarios) {
        usuariosServicio.eliminarUsuario(usuarios);
    }


    @PostMapping
    public Usuarios guardarUsuario(@RequestBody Usuarios usuario) {
        return usuariosServicio.guardarUsuario(usuario);
    }

}
