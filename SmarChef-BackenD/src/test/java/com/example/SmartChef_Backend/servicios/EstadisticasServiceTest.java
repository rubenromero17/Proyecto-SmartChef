package com.example.SmartChef_Backend.servicios;

import com.example.SmartChef_Backend.dto.*;
import com.example.SmartChef_Backend.modelos.Recetas;
import com.example.SmartChef_Backend.modelos.RecetasFavoritas;
import com.example.SmartChef_Backend.modelos.Usuarios;
import com.example.SmartChef_Backend.repositorios.RecetaIngredientesRepositorio;
import com.example.SmartChef_Backend.repositorios.RecetasFavoritasRepositorio;
import com.example.SmartChef_Backend.repositorios.RecetasRepositorio;
import com.example.SmartChef_Backend.repositorios.UsuariosRepositorio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EstadisticasServiceTest {
    @Autowired
    private EstadisticasService service;
    @Autowired
    private RecetaIngredientesRepositorio recetaIngredientesRepositorio;
    @Autowired
    private RecetasFavoritasRepositorio recetasFavoritasRepositorio;
    @Autowired
    private RecetasRepositorio re;
    @Autowired
    private UsuariosRepositorio u;
    @Autowired
    private RecetaService servicio;
    @Autowired
    private UsuariosService servicioUsuarios;
    @Autowired
    private RecetasFavoritasService servicioFavoritas;

    public void cargardatos(){
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
        servicioUsuarios.crearUsuario(usuarioDTO);

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

        servicio.agregarReceta(recetaDTO);
    }
    @Test
    @DisplayName("Test unitario: obtener top 5 de ingredientes más utilizados")
    public void top5IngredientesTest(){
        List<EstadisticasIngredientesDTO> topIngredientes = service.top5Ingredientes();
        assertNotNull(topIngredientes, "La lista de top ingredientes no debe ser null");
        assertFalse(topIngredientes.isEmpty(), "La lista de top ingredientes no debe estar vacía");
        assertTrue(topIngredientes.size() <= 5, "La lista no debe tener más de 5 elementos");
    }

    @Test
    @DisplayName("Test unitario: no se permite obtener top 5 ingredientes cuando no hay ingredientes registrados")
    public void top5IngredientesTestNegativo() {
        List<EstadisticasIngredientesDTO> ingredientes = recetaIngredientesRepositorio.findTopIngredientes();
        ingredientes.isEmpty();
        assertThrows(RuntimeException.class, () -> service.top5Ingredientes());
    }
/*
    @Test
    @DisplayName("Test Unitario: obtener recetas favoritas por usuario - Positivo")
    public void obtenerRecetasFavoritasPorUsuarioTest() {

        Usuarios usuario1 = new Usuarios();
        usuario1.setNombre("Luis");
        usuario1.setFechaNacimiento(LocalDate.of(1995, 5, 5));
        usuario1.setFechaRegistro(LocalDate.now());
        usuario1.setEmail("luis@example.com");
        usuario1.setContrasena("abcd");
        usuario1.setDireccion("Av. Siempre Viva 456");
        usuario1.setPreferencia("Carnívora");
        usuario1.setUrlImagen("https://example.com/luis.jpg");
        u.save(usuario1);

        Usuarios usuario2 = new Usuarios();
        usuario2.setNombre("Jose");
        usuario2.setFechaNacimiento(LocalDate.of(1990, 3, 10));
        usuario2.setFechaRegistro(LocalDate.now());
        usuario2.setEmail("jose@example.com");
        usuario2.setContrasena("abcd");
        usuario2.setDireccion("Calle Falsa 123");
        usuario2.setPreferencia("Italiana");
        usuario2.setUrlImagen("https://example.com/jose.jpg");
        u.save(usuario2);

        Recetas receta = new Recetas();
        receta.setNombre("Pasta Carbonara");
        receta.setDescripcion("Deliciosa pasta con huevo y panceta");
        receta.setDificultad("Media");
        receta.setEconomica(true);
        receta.setRapido(false);
        receta.setSin_gluten(false);
        receta.setTiempoPreparacion(30);
        receta.setUrlImagen("https://example.com/carbonara.jpg");
        receta.setVegetariana(false);
        re.save(receta);

        RecetasFavoritas fav1 = new RecetasFavoritas();
        fav1.setUsuario(usuario1);
        fav1.setReceta(receta);
        recetasFavoritasRepositorio.save(fav1);

        RecetasFavoritas fav2 = new RecetasFavoritas();
        fav2.setUsuario(usuario2);
        fav2.setReceta(receta);
        recetasFavoritasRepositorio.save(fav2);


        List<FavoritayUsuarioDTO> resultado = service.obtenerRecetasFavoritasPorUsuario();


        assertNotNull(resultado, "La lista no debe ser null");
        assertEquals(2, resultado.size(), "Debe haber dos favoritos, uno por cada usuario");


        FavoritayUsuarioDTO favLuis = resultado.stream()
                .filter(f -> f.getNombreUsuario().equals("Luis"))
                .findFirst()
                .orElse(null);
        assertNotNull(favLuis, "Debe existir el favorito de Luis");
        assertEquals("Pasta Carbonara", favLuis.getNombreReceta());

        FavoritayUsuarioDTO favJose = resultado.stream()
                .filter(f -> f.getNombreUsuario().equals("Jose"))
                .findFirst()
                .orElse(null);
        assertNotNull(favJose, "Debe existir el favorito de Jose");
        assertEquals("Pasta Carbonara", favJose.getNombreReceta());
    }

 */
    @Test
    @DisplayName("Test Unitario: obtener recetas favoritas por usuario sin registros - Negativo")
    public void obtenerRecetasFavoritasPorUsuarioNegativoTest() {
        Exception exception = assertThrows(
                org.springframework.dao.InvalidDataAccessResourceUsageException.class,
                () -> service.obtenerRecetasFavoritasPorUsuario(),
                "Se ha encontrado la tabla"
        );

        String mensaje = exception.getMessage();
        assertTrue(mensaje.contains("RECETAS_FAVORITAS") || mensaje.contains("recetas_favoritas"),
                "No se encuentra la tabla RECETAS_FAVORITAS");
    }



}
