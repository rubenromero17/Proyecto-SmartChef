package com.example.SmartChef_Backend.controladores;

import com.example.SmartChef_Backend.dto.AñadirHistorialDTO;
import com.example.SmartChef_Backend.dto.HistorialCocinaDTO;
import com.example.SmartChef_Backend.servicios.HistorialCocinaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historial-cocina")
@AllArgsConstructor
public class HistorialConcinaControlador {

    private HistorialCocinaService servicio;

    @PostMapping("/registrar")
    public void registrarHistorial(@Valid @RequestBody AñadirHistorialDTO añadirHistorialDTO) {
       servicio.registrarCocinado(añadirHistorialDTO);
    }

    @GetMapping("/verHistorial/{id}")
    public List<HistorialCocinaDTO> verHistorial(@PathVariable Integer id) {
        return servicio.obtenerHistorialSemanal(id);
    }
}
