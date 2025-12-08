package com.example.SmartChef_Backend.controladores;

import com.example.SmartChef_Backend.dto.*;
import com.example.SmartChef_Backend.servicios.ListaComprasService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/listas-compras")
@AllArgsConstructor
public class ListaComprasControlador {

    private ListaComprasService service;

    @PostMapping
    public ListaComprasDTO crearListaDesdeReceta(@Valid @RequestBody CrearListaDTO dto) {
        return service.crearListaDesdeReceta(
                dto.getIdUsuario(),
                dto.getIdReceta()
        );
    }
}
