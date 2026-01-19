package com.example.SmartChef_Backend.servicios;


import com.example.SmartChef_Backend.dto.UsuarioDTO;
import com.example.SmartChef_Backend.modelos.Usuarios;
import com.example.SmartChef_Backend.repositorios.UsuariosRepositorio;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UsuarioServiceIntegationTest {

    @InjectMocks
    private UsuariosService service;

    @Mock
    private UsuariosRepositorio repositorio;


    @Test
    public void crearUsuarioIntegrationTest() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNombre("Juan Perez");
        usuarioDTO.setFechaNacimiento(java.time.LocalDate.of(1990, 5, 20));
        usuarioDTO.setEmail("ruben@gmail.com");
        usuarioDTO.setContrasena("password123");
        usuarioDTO.setDireccion("Calle Falsa 123");
        usuarioDTO.setPreferencias("Vegetariano");
        usuarioDTO.setUrlImagen("http://example.com/imagen.jpg");
        usuarioDTO.setFechaRegistro(java.time.LocalDate.now());


        service.crearUsuario(usuarioDTO);
        //Then (se prueba el test)

        Usuarios usuarioBD = repositorio.findByNombre("Juan Perez");
        assertNotNull(usuarioBD);
        assertEquals("ruben@gmail.com", usuarioBD.getEmail());

    }


}
