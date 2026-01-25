package com.example.SmartChef_Backend.servicios;

import com.example.SmartChef_Backend.dto.*;
import com.example.SmartChef_Backend.modelos.*;
import com.example.SmartChef_Backend.repositorios.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RecetaServiceIntegrationTest {

    @InjectMocks
    private RecetaService service;

    @Mock
    private RecetasRepositorio repositorio;

    @Mock
    private IngredientesRepositorio repositorioIngredientes;

    @Mock
    private RecetaIngredientesRepositorio repositorioRecetaIngredientes;

    @Mock
    private InstruccionesRecetasRepositorio repositorioInstrucciones;

    @Test
    @DisplayName("Test Integracion: crear una receta correctamente")
    public void crearRecetaCorrectaTest() {
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
        ingredientes.add(new IngredientesDTO(1, "Manzanas", 3.0));
        ingredientes.add(new IngredientesDTO(2, "Harina", 200.0));
        ingredientes.add(new IngredientesDTO(3, "Azúcar", 100.0));
        ingredientes.add(new IngredientesDTO(4, "Mantequilla", 50.0));
        recetaDTO.setIngredientes(ingredientes);

        List<InstruccionesDTO> instrucciones = new ArrayList<>();
        instrucciones.add(new InstruccionesDTO(1, 1, "Precalentar el horno a 180ºC"));
        instrucciones.add(new InstruccionesDTO(2, 2, "Mezclar los ingredientes"));
        instrucciones.add(new InstruccionesDTO(3, 3, "Hornear durante 40 minutos"));
        recetaDTO.setInstrucciones(instrucciones);


        Mockito.when(repositorio.existsByNombre("Tarta de Manzana")).thenReturn(false);


        Recetas recetaGuardada = new Recetas();
        recetaGuardada.setNombre("Tarta de Manzana");
        Mockito.when(repositorio.save(any(Recetas.class))).thenReturn(recetaGuardada);


        for (IngredientesDTO i : ingredientes) {
            Ingredientes ingrediente = new Ingredientes();
            ingrediente.setNombre(i.getNombre());
            Mockito.when(repositorioIngredientes.save(any(Ingredientes.class))).thenReturn(ingrediente);
        }


        Mockito. when(repositorioRecetaIngredientes.save(any(RecetaIngredientes.class))).thenAnswer(invocation -> invocation.getArgument(0));
        Mockito.when(repositorioInstrucciones.save(any(InstruccionesRecetas.class))).thenAnswer(invocation -> invocation.getArgument(0));


        assertDoesNotThrow(() -> service.agregarReceta(recetaDTO));

        Mockito.verify(repositorio, times(1)).save(any(Recetas.class));
        Mockito.verify(repositorioIngredientes, times(4)).save(any(Ingredientes.class));
        Mockito.verify(repositorioRecetaIngredientes, times(4)).save(any(RecetaIngredientes.class));
        Mockito.verify(repositorioInstrucciones, times(3)).save(any(InstruccionesRecetas.class));
    }

    @Test
    @DisplayName("Test Integración: buscar recetas por filtro que no devuelva resultados")
    public void buscarRecetasPorFiltroNegativoTest() {
        Mockito.when(repositorio.buscarRecetasConFiltros(anyList(), anyBoolean(), anyBoolean(), nullable(Boolean.class), nullable(Boolean.class))).thenReturn(Collections.emptyList());

        FiltroRecetasDTO filtro = new FiltroRecetasDTO();
        filtro.setIngredientes(Arrays.asList("Harina", "Azúcar"));
        filtro.setVegetariana(false);
        filtro.setEconomica(true);


        List<RecetaDTO> resultados = service.buscarRecetasPorFiltro(filtro);

        assertTrue(resultados.isEmpty(), "No hay recetas que cumplan con los filtros");

        Mockito.verify(repositorio, times(1)).buscarRecetasConFiltros(anyList(), anyBoolean(), anyBoolean(), nullable(Boolean.class), nullable(Boolean.class));
        Mockito.verifyNoInteractions(repositorioRecetaIngredientes, repositorioInstrucciones);
    }

    @Test
    @DisplayName("Test Integración: ver detalles de una receta existente")
    public void verDetallesDeLaRecetaTest() {

        Recetas recetas = new Recetas();
        recetas.setId(1);
        recetas.setNombre("Tarta de Manzana");
        recetas.setDescripcion("Deliciosa tarta casera");
        recetas.setTiempoPreparacion(60);
        recetas.setDificultad("Media");
        recetas.setUrlImagen("http://example.com/tarta.jpg");
        recetas.setEconomica(true);
        recetas.setVegetariana(true);
        recetas.setSin_gluten(false);
        recetas.setRapido(false);

        Mockito.when(repositorio.findById(1)).thenReturn(java.util.Optional.of(recetas));


        Ingredientes ingredientes = new Ingredientes();
        ingredientes.setId(1);
        ingredientes.setNombre("Manzanas");

        RecetaIngredientes recetaIngredientes = new RecetaIngredientes();
        recetaIngredientes.setIngrediente(ingredientes);
        recetaIngredientes.setCantidad(3.0);

        Mockito.when(repositorioRecetaIngredientes.findByRecetaId(1)).thenReturn(Collections.singletonList(recetaIngredientes));


        InstruccionesRecetas instrucciones = new InstruccionesRecetas();
        instrucciones.setId(1);
        instrucciones.setPaso_numero(1);
        instrucciones.setDescripcion("Precalentar el horno a 180ºC");

        Mockito.when(repositorioInstrucciones.findByReceta_Id(1)).thenReturn(Collections.singletonList(instrucciones));


        RecetaDTO resultado = service.verDetallesRecetas(1);

        assertNotNull(resultado, "No se ha podido obtener los detalles de la receta");
        assertEquals("Tarta de Manzana", resultado.getNombre());
        assertEquals(1, resultado.getIngredientes().size());
        assertEquals("Manzanas", resultado.getIngredientes().get(0).getNombre());
        assertEquals(1, resultado.getInstrucciones().size());
        assertEquals("Precalentar el horno a 180ºC", resultado.getInstrucciones().get(0).getDescripcion());


        Mockito.verify(repositorio, times(1)).findById(1);
        Mockito.verify(repositorioRecetaIngredientes, times(1)).findByRecetaId(1);
        Mockito.verify(repositorioInstrucciones, times(1)).findByReceta_Id(1);
    }






}
