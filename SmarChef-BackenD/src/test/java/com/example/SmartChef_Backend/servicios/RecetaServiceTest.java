package com.example.SmartChef_Backend.servicios;

import com.example.SmartChef_Backend.dto.FiltroRecetasDTO;
import com.example.SmartChef_Backend.dto.IngredientesDTO;
import com.example.SmartChef_Backend.dto.InstruccionesDTO;
import com.example.SmartChef_Backend.dto.RecetaDTO;
import com.example.SmartChef_Backend.exception.ElementoNoEncontradoException;
import com.example.SmartChef_Backend.modelos.RecetaIngredientes;
import com.example.SmartChef_Backend.modelos.Recetas;
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
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Test unitarios de recetas")
public class RecetaServiceTest {

    @Autowired
    private RecetaService servicio;

    @Autowired
    private RecetasRepositorio repositorio;

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

        servicio.agregarReceta(recetaDTO);
    }

    @Test
    @DisplayName("Test unitario: Se crea una receta correctamente y se encuentra en la base de datos")
    public void crearRecetaTest() {

        Recetas recetaBD = repositorio.findByNombre("Tarta de Manzana");
        assertNotNull(recetaBD, "La receta no se ha creado correctamente");
        assertEquals("Tarta de Manzana", recetaBD.getNombre());
    }

    @Test
    @DisplayName("Test unitario: no se permite crear una receta con nombre repetido")
    public void crearRecetaConNombreRepetidoTest() {

        RecetaDTO recetaDTO1 = new RecetaDTO();
        recetaDTO1.setNombre("Tarta de Manzana");
        recetaDTO1.setDescripcion("Deliciosa tarta casera");
        recetaDTO1.setTiempoPreparacion(60);
        recetaDTO1.setDificultad("Media");
        recetaDTO1.setUrlImagen("http://example.com/tarta.jpg");
        recetaDTO1.setEconomica(true);
        recetaDTO1.setVegetariana(true);
        recetaDTO1.setSin_gluten(false);
        recetaDTO1.setRapido(false);

        List<IngredientesDTO> ingredientes1 = new ArrayList<>();
        ingredientes1.add(new IngredientesDTO(null, "Manzanas", 3.0));
        ingredientes1.add(new IngredientesDTO(null, "Harina", 200.0));
        ingredientes1.add(new IngredientesDTO(null, "Azúcar", 100.0));
        ingredientes1.add(new IngredientesDTO(null, "Mantequilla", 50.0));
        recetaDTO1.setIngredientes(ingredientes1);

        List<InstruccionesDTO> instrucciones1 = new ArrayList<>();
        instrucciones1.add(new InstruccionesDTO(null, 1, "Precalentar el horno a 180ºC"));
        instrucciones1.add(new InstruccionesDTO(null, 2, "Mezclar los ingredientes"));
        instrucciones1.add(new InstruccionesDTO(null, 3, "Hornear durante 40 minutos"));
        recetaDTO1.setInstrucciones(instrucciones1);

        assertThrows(IllegalArgumentException.class, () -> servicio.agregarReceta(recetaDTO1));
    }

    @Test
    @DisplayName("Test unitario: buscar recetas por filtro válido devuelve resultados")
    public void buscarRecetasPorFiltroTest(){


        FiltroRecetasDTO filtroRecetasDTO = new FiltroRecetasDTO();
        filtroRecetasDTO.setIngredientes(Arrays.asList("Harina", "Azúcar"));
        filtroRecetasDTO.setVegetariana(true);
        filtroRecetasDTO.setEconomica(true);

        List<RecetaDTO> resultados = servicio.buscarRecetasPorFiltro(filtroRecetasDTO);
        assertFalse(resultados.isEmpty(),"No se han encontrado recetas que cumplan con los filtros");
        assertNotNull(resultados.get(0),"No se ha podido obtener la receta buscada");
    }

    @Test
    @DisplayName("Test unitario: buscar recetas por filtro incompatible devuelve lista vacía")
    public void buscarRecetasPorFiltroNegativoTest(){
        cargardatos();

        FiltroRecetasDTO filtroRecetasDTO = new FiltroRecetasDTO();
        filtroRecetasDTO.setIngredientes(Arrays.asList("Harina", "Azúcar"));
        filtroRecetasDTO.setVegetariana(false);
        filtroRecetasDTO.setEconomica(true);

        List<RecetaDTO> resultados = servicio.buscarRecetasPorFiltro(filtroRecetasDTO);
        assertTrue(resultados.isEmpty(),"Se han encontrado recetas que no cumplen con los filtros");
    }

    @Test
    @DisplayName("Test unitario: obtener detalles de una receta existente")
    public void verDetallesRecetaTest(){

        RecetaDTO receta = servicio.verDetallesRecetas(1);
        assertNotNull(receta, "No se ha podido obtener los detalles de la receta");
    }

    @Test
    @DisplayName("Test unitario: lanzar excepción al consultar una receta inexistente")
    public void verDetalleRecetaNoHayRecetaTest(){

        assertThrows(ElementoNoEncontradoException.class, () -> {
            servicio.verDetallesRecetas(2);
        });
    }

}

