package com.example.SmartChef_Backend.servicios;

import com.example.SmartChef_Backend.modelos.Recetas;
import com.example.SmartChef_Backend.modelos.RecetasFavoritas;
import com.example.SmartChef_Backend.modelos.Usuarios;
import com.example.SmartChef_Backend.repositorios.RecetasFavoritasRepositorio;
import com.example.SmartChef_Backend.repositorios.RecetasRepositorio;
import com.example.SmartChef_Backend.repositorios.UsuariosRepositorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@SpringBootTest
public class RecetaFavoritaServiceIntegrationTest {

    @InjectMocks
    private RecetasFavoritasService servicio;

    @Mock
    private RecetasFavoritasRepositorio repositorioFavoritas;

    @Mock
    private RecetasRepositorio repositorioRecetas;

    @Mock
    private UsuariosRepositorio repositorioUsuarios;

    @Test
    @DisplayName("Test Integración: agregar receta a favoritos correctamente")
    public void agregarRecetaFavoritosTest() {

        Usuarios usuarios = new Usuarios();
        usuarios.setId(1);
        usuarios.setNombre("Juan");

        Recetas receta = new Recetas();
        receta.setId(1);
        receta.setNombre("Tarta de Manzana");

        Mockito.when(repositorioUsuarios.findById(1)).thenReturn(Optional.of(usuarios));
        Mockito.when(repositorioRecetas.findById(1)).thenReturn(Optional.of(receta));
        Mockito.when(repositorioFavoritas.existsByUsuarioAndReceta(usuarios, receta)).thenReturn(false);


        assertDoesNotThrow(() -> servicio.marcarComoFavorita(1, 1));

        Mockito.verify(repositorioFavoritas, times(1)).save(any(RecetasFavoritas.class));


        Mockito.verify(repositorioUsuarios, times(1)).findById(1);
        Mockito.verify(repositorioRecetas, times(1)).findById(1);
        Mockito.verify(repositorioFavoritas, times(1)).existsByUsuarioAndReceta(usuarios, receta);
    }
}
