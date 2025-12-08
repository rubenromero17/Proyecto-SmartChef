package com.example.SmartChef_Backend.servicios;


import com.example.SmartChef_Backend.dto.FavoritosDTO;
import com.example.SmartChef_Backend.modelos.Recetas;
import com.example.SmartChef_Backend.modelos.RecetasFavoritas;
import com.example.SmartChef_Backend.modelos.Usuarios;
import com.example.SmartChef_Backend.repositorios.RecetasFavoritasRepositorio;
import com.example.SmartChef_Backend.repositorios.RecetasRepositorio;
import com.example.SmartChef_Backend.repositorios.UsuariosRepositorio;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RecetasFavoritasService {


    private RecetasFavoritasRepositorio repositorioFavoritas;
    private RecetasRepositorio repositorioRecetas;
    private UsuariosRepositorio repositorioUsuarios;
    @Transactional
    public void marcarComoFavorita(Integer usuarioId, Integer recetaId) {
        Usuarios usuario = repositorioUsuarios.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Recetas receta = repositorioRecetas.findById(recetaId)
                .orElseThrow(() -> new RuntimeException("Receta no encontrada"));

        if (repositorioFavoritas.existsByUsuarioAndReceta(usuario, receta)) {
            throw new RuntimeException("Receta ya marcada como favorita");
        }

        RecetasFavoritas favorita = new RecetasFavoritas();
        favorita.setUsuario(usuario);
        favorita.setReceta(receta);

        repositorioFavoritas.save(favorita);
    }
}
