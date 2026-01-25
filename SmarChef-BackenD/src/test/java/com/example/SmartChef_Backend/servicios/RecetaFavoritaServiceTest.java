package com.example.SmartChef_Backend.servicios;

import com.example.SmartChef_Backend.dto.IngredientesDTO;
import com.example.SmartChef_Backend.dto.InstruccionesDTO;
import com.example.SmartChef_Backend.dto.RecetaDTO;
import com.example.SmartChef_Backend.dto.UsuarioDTO;
import com.example.SmartChef_Backend.exception.ElementoNoEncontradoException;
import com.example.SmartChef_Backend.modelos.Recetas;
import com.example.SmartChef_Backend.modelos.Usuarios;
import com.example.SmartChef_Backend.repositorios.RecetasFavoritasRepositorio;
import com.example.SmartChef_Backend.repositorios.RecetasRepositorio;
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
public class RecetaFavoritaServiceTest {

    @Autowired
    private RecetasFavoritasService servicio;

    @Autowired
    private RecetaService recetaService;

    @Autowired
    private UsuariosService usuariosService;
    @Autowired
    private RecetasFavoritasRepositorio repositorio;
    @Autowired
    private RecetasRepositorio recetasRepositorio;

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
    }

    @Test
    @DisplayName("Test unitario: agregar receta a favoritos correctamente")
    public void agregarRecetaFavoritaTest() {
        Usuarios usuarios = usuariosService.verTodosUsuarios().get(0);
        Recetas receta = recetasRepositorio.findAll().get(0);
        servicio.marcarComoFavorita(usuarios.getId(), receta.getId());
        boolean existeFavorita = repositorio.existsByUsuarioAndReceta(usuarios, receta);

        assertTrue(existeFavorita);

    }
    @Test
    @DisplayName("Test unitario: aggregar receta a favoritos correctamente caso negativo")
    public void agregarRecetaFavoritaTestNegativo() {
        Usuarios usuarioValido = usuariosService.verTodosUsuarios().get(0);
        Recetas recetaValida = recetasRepositorio.findAll().get(0);


        servicio.marcarComoFavorita(usuarioValido.getId(), recetaValida.getId());

        assertAll("Casos negativos",
                // Usuario no encontrado
                () -> assertThrows(ElementoNoEncontradoException.class,
                        () -> servicio.marcarComoFavorita(2, recetaValida.getId()),"Usuario no encontrado"),
                // Receta no encontrada
                () -> assertThrows(ElementoNoEncontradoException.class,
                        () -> servicio.marcarComoFavorita(usuarioValido.getId(), 5),"Receta no encontrada"),
                // Receta ya puesta como favorita
                () -> assertThrows(RuntimeException.class,
                        () -> servicio.marcarComoFavorita(usuarioValido.getId(), recetaValida.getId()),"Receta ya marcada como favorita")
        );
    }
}
