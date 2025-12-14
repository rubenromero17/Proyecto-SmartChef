package com.example.SmartChef_Backend.controladores;


import com.example.SmartChef_Backend.dto.FiltroRecetasDTO;
import com.example.SmartChef_Backend.dto.RecetaDTO;
import com.example.SmartChef_Backend.dto.RecetaTarjetaDTO;
import com.example.SmartChef_Backend.modelos.RecetasFavoritas;
import com.example.SmartChef_Backend.servicios.RecetaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/receta")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class RecetaControlador {
    private RecetaService service;

    @PostMapping("/agregarReceta")
    public void crearReceta(@Valid @RequestBody RecetaDTO recetaDTO) {
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

    @GetMapping("/verDetalles/{id}")
    public RecetaDTO buscarReceta(@PathVariable Integer id) {
        return service.verDetallesRecetas(id);
    }

    @GetMapping("/todasRecetas")
    public List<RecetaDTO> obtenerTodasLasRecetas() {
        return service.obtenerTodasLasRecetas();
    }

    @GetMapping("/tarjetasRecetas")
    public List<RecetaTarjetaDTO> obtenerTodasLasRecetasParaTarjeta() {
        return service.obtenerTodasLasRecetasParaTarjeta();
}

    @DeleteMapping("/eliminarReceta/{id}")
    public void eliminarReceta(@PathVariable Integer id) {
        service.eliminarReceta(id);
    }

    @PutMapping("/editar/{id}")
    public void editarReceta(@Valid @RequestBody RecetaDTO recetaDTO) {
        service.editarReceta(recetaDTO);
    }
    @GetMapping("/buscarPorId/{id}")
    public RecetaDTO buscarRecetaPorId(@PathVariable Integer id) {
        return service.buscarRecetaPorId(id);
    }



}




