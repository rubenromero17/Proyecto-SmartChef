package com.example.SmartChef_Backend.servicios;

import com.example.SmartChef_Backend.dto.AñadirHistorialDTO;
import com.example.SmartChef_Backend.modelos.HistorialCocina;
import com.example.SmartChef_Backend.modelos.Recetas;
import com.example.SmartChef_Backend.modelos.Usuarios;
import com.example.SmartChef_Backend.repositorios.HistorialCocinaRepositorio;
import com.example.SmartChef_Backend.repositorios.RecetasRepositorio;
import com.example.SmartChef_Backend.repositorios.UsuariosRepositorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@SpringBootTest
public class HistorialCocinaServiceIntegrationTest {
    @InjectMocks
    private HistorialCocinaService servicio;

    @Mock
    private UsuariosRepositorio usuariosRepositorio;

    @Mock
    private RecetasRepositorio recetasRepositorio;

    @Mock
    private HistorialCocinaRepositorio repositorio;

    @Test
    @DisplayName("Test Integración: Registrar cocinado")
    public void registrarCocinadoTest() {

        Usuarios usuario = new Usuarios();
        usuario.setId(1);

        Recetas receta = new Recetas();
        receta.setId(1);

        AñadirHistorialDTO dto = AñadirHistorialDTO.builder().idUsuario(1).idReceta(1).fecha_cocinado(LocalDate.now()).build();

        Mockito.when(usuariosRepositorio.findById(1)).thenReturn(Optional.of(usuario));
        Mockito.when(recetasRepositorio.findById(1)).thenReturn(Optional.of(receta));
        Mockito.when(repositorio.save(any(HistorialCocina.class))).thenAnswer(invocation -> invocation.getArgument(0));

        assertDoesNotThrow(() -> servicio.registrarCocinado(dto));

        Mockito.verify(usuariosRepositorio, times(1)).findById(1);
        Mockito.verify(recetasRepositorio, times(1)).findById(1);
        Mockito.verify(repositorio, times(1)).save(any(HistorialCocina.class));
    }

    @Test
    @DisplayName("Test Integración: Obtener historial semanal")
    public void obtenerHistorialSemanalIntegracionTest() {
        Mockito.when(usuariosRepositorio.findById(2)).thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class, () -> servicio.obtenerHistorialSemanal(2),
                "Se esperaba excepción por usuario inexistente");

        assertEquals("Usuario no encontrado", exception.getMessage());
        Mockito.verify(usuariosRepositorio, times(1)).findById(2);
        Mockito.verifyNoInteractions(repositorio);
    }

}
