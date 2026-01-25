package com.example.SmartChef_Backend.servicios;

import com.example.SmartChef_Backend.dto.UsuarioDTO;
import com.example.SmartChef_Backend.modelos.Usuarios;
import com.example.SmartChef_Backend.repositorios.UsuariosRepositorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UsuarioServiceIntegationTest {

    @InjectMocks
    private UsuariosService service;

    @Mock
    private UsuariosRepositorio repositorio;

    @Test
    @DisplayName("Test Integracion: no se puede crear un usuario con email repetido")
    public void crearUsuarioConEmailRepetidoTest() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNombre("Juan Pérez");
        usuarioDTO.setEmail("juan@example.com");
        usuarioDTO.setContrasena("123456");
        usuarioDTO.setDireccion("Calle Falsa 123");
        usuarioDTO.setPreferencias("Vegetariano, Sin Gluten");
        usuarioDTO.setFechaNacimiento(LocalDate.of(1990, 5, 20));

        Mockito.when(repositorio.existsByEmail("juan@example.com")).thenReturn(true);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> service.crearUsuario(usuarioDTO));

        assertEquals("El email ya está en uso", exception.getMessage());

        Mockito.verify(repositorio, never()).save(any(Usuarios.class));
    }
}
