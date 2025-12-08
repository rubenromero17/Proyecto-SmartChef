package com.example.SmartChef_Backend.controladores;

import com.example.SmartChef_Backend.dto.UsuarioDTO;
import com.example.SmartChef_Backend.servicios.UsuariosService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@AllArgsConstructor
public class UsuarioControlador {
    private UsuariosService service;

    @PostMapping("/crearUsuario")
    public void crearUsuario(@Valid @RequestBody UsuarioDTO usuario) {
        service.crearUsuario(usuario);
    }
}
