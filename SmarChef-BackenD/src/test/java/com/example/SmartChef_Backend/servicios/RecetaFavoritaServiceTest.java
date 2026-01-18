package com.example.SmartChef_Backend.servicios;

import com.example.SmartChef_Backend.dto.IngredientesDTO;
import com.example.SmartChef_Backend.dto.InstruccionesDTO;
import com.example.SmartChef_Backend.dto.RecetaDTO;
import com.example.SmartChef_Backend.dto.UsuarioDTO;
import com.example.SmartChef_Backend.modelos.Recetas;
import com.example.SmartChef_Backend.modelos.Usuarios;
import com.example.SmartChef_Backend.repositorios.RecetasFavoritasRepositorio;
import com.example.SmartChef_Backend.repositorios.RecetasRepositorio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void agregarRecetaFavoritaTest() {
        // 1️⃣ Cargamos los datos
        cargardatos();

        // 2️⃣ Recuperamos los registros de la base según el nombre
        RecetaDTO receta = recetaService.obtenerTodasLasRecetas().stream()
                .filter(r -> r.getNombre().equals("Tarta de Manzana"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Receta no encontrada"));

        UsuarioDTO usuario = usuariosService.verTodosUsuarios().stream()
                .filter(u -> u.getNombre().equals("Juan Perez"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // 3️⃣ Agregamos a favoritos usando IDs reales
        servicio.marcarComoFavorita(usuario.getid(), receta.getId());

        // 4️⃣ Comprobamos que realmente se ha añadido
        boolean esFavorita = repositorio.existsByUsuarioAndReceta(
                new Usuarios(usuario.getNombre()), // solo con nombre
                new Recetas(receta.getNombre())    // solo con nombre
        );

        // 5️⃣ Test positivo
        assertTrue(esFavorita, "La receta debería estar marcada como favorita");
    }


}
