package com.example.SmartChef_Backend.servicios;

import com.example.SmartChef_Backend.dto.ListaComprasDTO;
import com.example.SmartChef_Backend.modelos.*;
import com.example.SmartChef_Backend.repositorios.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

@SpringBootTest
public class ListaComprasServiceIntegrationTest {

    @InjectMocks
    private ListaComprasService service;

    @Mock
    private ListaComprasRepositorio listaComprasRepositorio;

    @Mock
    private ListaIngredientesRepositorio listaIngredientesRepositorio;

    @Mock
    private RecetaIngredientesRepositorio recetaIngredientesRepositorio;

    @Mock
    private RecetasRepositorio recetasRepositorio;

    @Mock
    private UsuariosRepositorio usuariosRepositorio;


    @Test
    @DisplayName("Test integración: crear lista de compras desde receta")
    public void crearListaDeComprasTest() {


        Usuarios usuario = new Usuarios();
        usuario.setId(1);

        Recetas receta = new Recetas();
        receta.setId(1);

        Ingredientes ingrediente = new Ingredientes();
        ingrediente.setId(1);
        ingrediente.setNombre("Harina");

        RecetaIngredientes recetaIng = new RecetaIngredientes();
        recetaIng.setIngrediente(ingrediente);
        recetaIng.setCantidad(200.0);

        ListaCompras listaGuardada = new ListaCompras();
        listaGuardada.setId(1);
        listaGuardada.setUsuario(usuario);

        Mockito.when(usuariosRepositorio.findById(1)).thenReturn(Optional.of(usuario));
        Mockito.when(recetasRepositorio.findById(1)).thenReturn(Optional.of(receta));
        Mockito.when(listaComprasRepositorio.save(any(ListaCompras.class))).thenReturn(listaGuardada);
        Mockito.when(recetaIngredientesRepositorio.findByRecetaId(1)).thenReturn(List.of(recetaIng));

        ListaComprasDTO resultado = service.crearListaDesdeReceta(1, 1);

        assertNotNull(resultado);
        assertEquals(1, resultado.getIdUsuario());
        assertFalse(resultado.getIngredientes().isEmpty());

        Mockito.verify(listaComprasRepositorio, times(1)).save(any(ListaCompras.class));
        Mockito.verify(listaIngredientesRepositorio, times(1)).save(any(ListaIngredientes.class));
    }


}
