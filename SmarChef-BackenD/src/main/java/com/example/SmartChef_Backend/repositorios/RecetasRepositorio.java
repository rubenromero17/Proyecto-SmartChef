package com.example.SmartChef_Backend.repositorios;
import com.example.SmartChef_Backend.dto.RecetaDTO;
import com.example.SmartChef_Backend.dto.UsuarioDTO;
import com.example.SmartChef_Backend.modelos.RecetaIngredientes;
import com.example.SmartChef_Backend.modelos.Recetas;
import com.example.SmartChef_Backend.modelos.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetasRepositorio extends JpaRepository<Recetas, Integer> {

    Recetas findByNombre(String nombre);
    Recetas findAllByDescripcion(String descripcion);

}
