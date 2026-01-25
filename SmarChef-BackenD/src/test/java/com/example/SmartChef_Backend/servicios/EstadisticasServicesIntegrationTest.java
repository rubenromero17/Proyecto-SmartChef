package com.example.SmartChef_Backend.servicios;

import com.example.SmartChef_Backend.dto.EstadisticasIngredientesDTO;
import com.example.SmartChef_Backend.dto.FavoritayUsuarioDTO;
import com.example.SmartChef_Backend.exception.ElementoNoEncontradoException;
import com.example.SmartChef_Backend.repositorios.RecetaIngredientesRepositorio;
import com.example.SmartChef_Backend.repositorios.RecetasFavoritasRepositorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;
@SpringBootTest
public class EstadisticasServicesIntegrationTest {
    @InjectMocks
    private EstadisticasService service;

    @Mock
    private RecetaIngredientesRepositorio recetaIngredientesRepositorio;

    @Mock
    private RecetasFavoritasRepositorio recetasFavoritasRepositorio;

    @Mock
    private RecetasFavoritasRepositorio favoritasRepositorio;



    @Test
    @DisplayName("Test Integración: obtener top 5 ingredientes más utilizados")
    public void top5IngredientesTestIntegracion() {

        List<EstadisticasIngredientesDTO> Ingrediente = Arrays.asList(
                new EstadisticasIngredientesDTO("Harina", 15L),
                new EstadisticasIngredientesDTO("Azúcar", 8L),
                new EstadisticasIngredientesDTO("Manzanas", 5L)
        );

        Mockito.when(recetaIngredientesRepositorio.findTopIngredientes()).thenReturn(Ingrediente);

        List<EstadisticasIngredientesDTO> resultado = service.top5Ingredientes();

        assertNotNull(resultado, "La lista de top ingredientes no debe ser null");
        assertFalse(resultado.isEmpty(), "La lista de top ingredientes no debe estar vacía");
        assertTrue(resultado.size() <= 5, "La lista no debe tener más de 5 elementos");
        assertEquals("Harina", resultado.get(0).getNombreIngrediente(), "El primer ingrediente debe ser Harina");

        Mockito.verify(recetaIngredientesRepositorio, times(1)).findTopIngredientes();
    }
    @Test
    @DisplayName("Test Integración: obtener recetas favoritas por usuario")
    public void obtenerRecetasFavoritasPorUsuarioMockNegativo() {

        Mockito.when(recetasFavoritasRepositorio.recetasFavoritas())
                .thenThrow(new ElementoNoEncontradoException("Usuario no encontrado"));

        assertThrows(ElementoNoEncontradoException.class,
                () -> recetasFavoritasRepositorio.recetasFavoritas());
    }

}
