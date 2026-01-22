package com.example.SmartChef_Backend.servicios;


import com.example.SmartChef_Backend.dto.UsuarioDTO;
import com.example.SmartChef_Backend.modelos.Usuarios;
import com.example.SmartChef_Backend.repositorios.UsuariosRepositorio;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Test unitarios de usuarios")
public class UsuariosServiceTest {

    @Autowired
    private UsuariosService servicio;

    @Autowired
    private UsuariosRepositorio repositorio;

    @Test
    @DisplayName("Test unitario: crear un usuario correctamente")
    public void crearUsuarioTest() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNombre("Juan Perez");
        usuarioDTO.setFechaNacimiento(java.time.LocalDate.of(1990, 5, 20));
        usuarioDTO.setEmail("ruben@gmail.com");
        usuarioDTO.setContrasena("password123");
        usuarioDTO.setDireccion("Calle Falsa 123");
        usuarioDTO.setPreferencias("Vegetariano");
        usuarioDTO.setUrlImagen("http://example.com/imagen.jpg");
        usuarioDTO.setFechaRegistro(java.time.LocalDate.now());

        // Given
        servicio.crearUsuario(usuarioDTO);

        // When
        Usuarios usuarioBD = repositorio.findByNombre("Juan Perez");

        // Then
        assertNotNull(usuarioBD, "El usuario no se ha creado correctamente");
        assertEquals("ruben@gmail.com", usuarioBD.getEmail(), "El email no coincide");
    }

    @Test
    @DisplayName("Test unitario: no se permite crear un usuario con nombre repetido")
    public void crearUsuarioConNombreRepetidoTest() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNombre("Juan Perez");
        usuarioDTO.setFechaNacimiento(java.time.LocalDate.of(1990, 5, 20));
        usuarioDTO.setEmail("run@gmail.com");
        usuarioDTO.setContrasena("password123");
        usuarioDTO.setDireccion("Calle Falsa 123");
        usuarioDTO.setPreferencias("Vegetariano");
        usuarioDTO.setUrlImagen("http://example.com/imagen.jpg");
        usuarioDTO.setFechaRegistro(java.time.LocalDate.now());

        servicio.crearUsuario(usuarioDTO);

        UsuarioDTO usuarioDTO1 = new UsuarioDTO();
        usuarioDTO1.setNombre("Juan Perez");
        usuarioDTO1.setFechaNacimiento(java.time.LocalDate.of(1990, 5, 20));
        usuarioDTO1.setEmail("run2@gmail.com");
        usuarioDTO1.setContrasena("password123");
        usuarioDTO1.setDireccion("Calle Falsa 123");
        usuarioDTO1.setPreferencias("Vegetariano");
        usuarioDTO1.setUrlImagen("http://example.com/imagen.jpg");
        usuarioDTO1.setFechaRegistro(java.time.LocalDate.now());

        assertThrows(IllegalArgumentException.class, () -> servicio.crearUsuario(usuarioDTO1), "El usuario ya existe");
    }

}

