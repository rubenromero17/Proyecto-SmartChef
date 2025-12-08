package com.example.SmartChef_Backend.servicios;

import com.example.SmartChef_Backend.modelos.*;
import com.example.SmartChef_Backend.repositorios.*;
import com.example.SmartChef_Backend.dto.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ListaComprasService {

    private ListaComprasRepositorio listaRepo;
    private ListaIngredientesRepositorio listaIngRepo;
    private RecetaIngredientesRepositorio recetaIngRepo;
    private UsuariosRepositorio usuarioRepo;

    public ListaComprasDTO crearListaDesdeReceta(int idUsuario, int idReceta) {
        try {

            Usuarios usuario = usuarioRepo.findById(idUsuario)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            ListaCompras lista = new ListaCompras();
            lista.setUsuario(usuario);
            lista.setFechaCreacion(LocalDate.now());
            lista = listaRepo.save(lista);


            List<RecetaIngredientes> recetaIngredientes = recetaIngRepo.findByRecetaId(idReceta);

            if (recetaIngredientes.isEmpty()) {
                throw new RuntimeException("No se encuentran ingredientes en esta receta " + idReceta);
            }

            List<IngredienteListaDTO> itemsDTO = new ArrayList<>();

            for (RecetaIngredientes ri : recetaIngredientes) {
                Ingredientes ing = ri.getIngrediente();


                ListaIngredientes listaIng = new ListaIngredientes();
                listaIng.setListaCompras(lista);
                listaIng.setIngredientes(ing);
                listaIng.setCantidad(ri.getCantidad());
                listaIng.setComprado(ListaIngredientes.Comprado.No);

                listaIngRepo.save(listaIng);


                IngredienteListaDTO ingredienteListaDTO = new IngredienteListaDTO();
                ingredienteListaDTO.setIdIngrediente(ing.getId());
                ingredienteListaDTO.setNombre(ing.getNombre());
                ingredienteListaDTO.setCantidad(ri.getCantidad());
                ingredienteListaDTO.setComprado("No");

                itemsDTO.add(ingredienteListaDTO);
            }


            ListaComprasDTO listaDTO = new ListaComprasDTO();
            listaDTO.setIdLista(lista.getId());
            listaDTO.setIdUsuario(usuario.getId());
            listaDTO.setFechaCreacion(lista.getFechaCreacion());
            listaDTO.setIngredientes(itemsDTO);

            return listaDTO;

        } catch (Exception e) {
            System.err.println("Error al crear lista de compras desde receta");
            e.printStackTrace();
            throw new RuntimeException("Error: " + e.getMessage(), e);
        }
    }
}
