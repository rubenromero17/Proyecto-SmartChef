package com.example.SmartChef_Backend.controladores;


import com.example.SmartChef_Backend.dto.FiltroRecetasDTO;
import com.example.SmartChef_Backend.dto.RecetaDTO;
import com.example.SmartChef_Backend.modelos.RecetasFavoritas;
import com.example.SmartChef_Backend.servicios.RecetaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receta")
@AllArgsConstructor
public class RecetaControlador {
    private RecetaService service;

    @PostMapping("/agregarReceta")
    public void crearReceta(@RequestBody RecetaDTO recetaDTO) {
        service.agregarReceta(recetaDTO);
    }

    @GetMapping("/buscarReceta")
    public List<RecetaDTO> buscarReceta(
            @RequestParam(required = false) Boolean economica,
            @RequestParam(required = false) Boolean vegetariana,
            @RequestParam(required = false) Boolean sin_gluten,
            @RequestParam(required = false) Boolean rapido,
            @RequestParam(required = false) List<String> ingredientes
    ) {

        FiltroRecetasDTO filtro = new FiltroRecetasDTO();
        filtro.setEconomica(economica);
        filtro.setVegetariana(vegetariana);
        filtro.setSin_gluten(sin_gluten);
        filtro.setRapido(rapido);
        filtro.setIngredientes(ingredientes);

        return service.buscarRecetasPorFiltro(filtro);
    }

    @GetMapping("verDetalles/{id}")
    public RecetaDTO buscarReceta(@PathVariable Integer id) {
        return service.verDetallesRecetas(id);
    }




}
