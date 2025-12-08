package com.example.SmartChef_Backend.controladores;

import com.example.SmartChef_Backend.dto.EstadisticasIngredientesDTO;
import com.example.SmartChef_Backend.dto.EstadisticasRecetasDTO;
import com.example.SmartChef_Backend.servicios.EstadisticasService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/estadisticas")
public class EstadisticasControlador {

    private EstadisticasService estadisticasService;

    @GetMapping("/top5Ingredientes")
    public List<EstadisticasIngredientesDTO> top5Ingredientes() {
        return estadisticasService.top5Ingredientes();
    }

    @GetMapping("/top5Recetas")
    public List<EstadisticasRecetasDTO> top5Recetas() {
        return estadisticasService.top5Recetas();
    }
}
