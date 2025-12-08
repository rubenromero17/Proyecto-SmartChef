package com.example.SmartChef_Backend.controladores;

import com.example.SmartChef_Backend.dto.FavoritosDTO;
import com.example.SmartChef_Backend.servicios.RecetasFavoritasService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recetasFavoritas")
@AllArgsConstructor
public class RecetasFavoritasControlador {

    private final RecetasFavoritasService service;

    @PostMapping("/{id}/favorito")
    public ResponseEntity<String> marcarFavorito(
            @PathVariable("id") Integer recetaId,
            @RequestBody FavoritosDTO favoritoDTO) {
        try {
            service.marcarComoFavorita(favoritoDTO.getUsuarioId(), recetaId);
            return ResponseEntity.ok("Receta marcada como favorita");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

