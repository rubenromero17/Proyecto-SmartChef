package com.example.SmartChef_Backend.servicios;

import com.example.SmartChef_Backend.exception.ElementoNoEncontradoException;
import com.example.SmartChef_Backend.modelos.*;
import com.example.SmartChef_Backend.repositorios.*;
import com.example.SmartChef_Backend.dto.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class HistorialCocinaService {

    private  UsuariosRepositorio usuariosRepositorio;
    private  RecetasRepositorio recetasRepositorio;
    private HistorialCocinaRepositorio repositorio;

@Transactional
    public void registrarCocinado (AñadirHistorialDTO dto) {
    Usuarios usuario = usuariosRepositorio.findById(dto.getIdUsuario())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    Recetas receta = recetasRepositorio.findById(dto.getIdReceta())
            .orElseThrow(() -> new RuntimeException("Receta no encontrada"));
    HistorialCocina historialCocina = new HistorialCocina();
    historialCocina.setUsuario(usuario);
    historialCocina.setReceta(receta);
    historialCocina.setFechaCocinado(dto.getFecha_cocinado());
    historialCocina.setFechaVisitado(LocalDate.now());
    repositorio.save(historialCocina);
    }


    @Transactional
    public List<HistorialCocinaDTO> obtenerHistorialSemanal(int idUsuario) {
        Usuarios usuario = usuariosRepositorio.findById(idUsuario)
                .orElseThrow(() -> new ElementoNoEncontradoException("Usuario no encontrado"));

        LocalDate haceUnaSemana = LocalDate.now().minusDays(7);
        List<HistorialCocina> historial = repositorio.findByUsuarioAndFechaVisitadoAfter(usuario, haceUnaSemana);
        List<HistorialCocinaDTO> listaDTO = new ArrayList<>();

        for (HistorialCocina h : historial) {
                Recetas receta = h.getReceta();
                HistorialCocinaDTO dto = new HistorialCocinaDTO();
                dto.setIdReceta(receta.getId());
                dto.setFecha_cocinado(h.getFechaCocinado());
                dto.setFecha_visitado(h.getFechaVisitado());
                listaDTO.add(dto);
            }
        return listaDTO;
    }


}


