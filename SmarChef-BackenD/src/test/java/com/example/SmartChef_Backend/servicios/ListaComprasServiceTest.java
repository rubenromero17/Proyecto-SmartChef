package com.example.SmartChef_Backend.servicios;

import com.example.SmartChef_Backend.dto.IngredientesDTO;
import com.example.SmartChef_Backend.dto.InstruccionesDTO;
import com.example.SmartChef_Backend.dto.RecetaDTO;
import com.example.SmartChef_Backend.dto.UsuarioDTO;
import com.example.SmartChef_Backend.modelos.ListaCompras;
import com.example.SmartChef_Backend.repositorios.ListaComprasRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ListaComprasServiceTest {
    @Autowired
    private ListaComprasService service;

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private ListaComprasRepositorio listaRepo;

    @Autowired
    private RecetaService recetaService;

    @BeforeEach
    public void cargardatos(){
        RecetaDTO recetaDTO = new RecetaDTO();
        recetaDTO.setNombre("Tarta de Manzana");
        recetaDTO.setDescripcion("Deliciosa tarta casera");
        recetaDTO.setTiempoPreparacion(60);
        recetaDTO.setDificultad("Media");
        recetaDTO.setUrlImagen("http://example.com/tarta.jpg");
        recetaDTO.setEconomica(true);
        recetaDTO.setVegetariana(true);
        recetaDTO.setSin_gluten(false);
        recetaDTO.setRapido(false);

        List<IngredientesDTO> ingredientes = new ArrayList<>();
        ingredientes.add(new IngredientesDTO(null, "Manzanas", 3.0));
        ingredientes.add(new IngredientesDTO(null, "Harina", 200.0));
        ingredientes.add(new IngredientesDTO(null, "Azúcar", 100.0));
        ingredientes.add(new IngredientesDTO(null, "Mantequilla", 50.0));
        recetaDTO.setIngredientes(ingredientes);

        List<InstruccionesDTO> instrucciones = new ArrayList<>();
        instrucciones.add(new InstruccionesDTO(null, 1, "Precalentar el horno a 180ºC"));
        instrucciones.add(new InstruccionesDTO(null, 2, "Mezclar los ingredientes"));
        instrucciones.add(new InstruccionesDTO(null, 3, "Hornear durante 40 minutos"));
        recetaDTO.setInstrucciones(instrucciones);

        recetaService.agregarReceta(recetaDTO);
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNombre("Juan Perez");
        usuarioDTO.setFechaNacimiento(java.time.LocalDate.of(1990, 5, 20));
        usuarioDTO.setEmail("run@gmail.com");
        usuarioDTO.setContrasena("password123");
        usuarioDTO.setDireccion("Calle Falsa 123");
        usuarioDTO.setPreferencias("Vegetariano");
        usuarioDTO.setUrlImagen("http://example.com/imagen.jpg");
        usuarioDTO.setFechaRegistro(java.time.LocalDate.now());

        usuariosService.crearUsuario(usuarioDTO);

        UsuarioDTO usuarioDTO1 = new UsuarioDTO();
        usuarioDTO1.setNombre("Juan Perez");
        usuarioDTO1.setFechaNacimiento(java.time.LocalDate.of(1990, 5, 20));
        usuarioDTO1.setEmail("run2@gmail.com");
        usuarioDTO1.setContrasena("password123");
        usuarioDTO1.setDireccion("Calle Falsa 123");
        usuarioDTO1.setPreferencias("Vegetariano");
        usuarioDTO1.setUrlImagen("http://example.com/imagen.jpg");
        usuarioDTO1.setFechaRegistro(java.time.LocalDate.now());

    }
    @Test
    @DisplayName("Test Unitario = Crear Lista de Compras desde Receta - Caso Positivo")
    public void crearListaDesdeRecetaTest(){
        service.crearListaDesdeReceta(1, 1);

        List<ListaCompras> listas = listaRepo.findAll();
        assertNotNull(listas,"Lista de compras no creada");
        assertFalse(listas.isEmpty(),"No se han creado listas de compras");
    }
    @Test
    @DisplayName("Test Unitario = Crear Lista de Compras desde Receta - Caso Negativo")
    public void crearListaDesdeRecetaNegativoTest(){
        assertThrows(RuntimeException.class, () -> service.crearListaDesdeReceta(1,2));
    }
}
