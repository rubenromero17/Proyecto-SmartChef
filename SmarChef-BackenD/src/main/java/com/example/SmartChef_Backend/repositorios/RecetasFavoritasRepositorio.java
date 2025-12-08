package com.example.SmartChef_Backend.repositorios;
import com.example.SmartChef_Backend.dto.EstadisticasIngredientesDTO;
import com.example.SmartChef_Backend.dto.EstadisticasRecetasDTO;
import com.example.SmartChef_Backend.modelos.Recetas;
import com.example.SmartChef_Backend.modelos.RecetasFavoritas;
import com.example.SmartChef_Backend.modelos.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecetasFavoritasRepositorio extends JpaRepository<RecetasFavoritas, Integer> {

    boolean existsByUsuarioAndReceta(Usuarios usuario, Recetas receta);

    //hago el select new para pasar directamente el dto no la entidad
    @Query("select new com.example.SmartChef_Backend.dto.EstadisticasRecetasDTO(r.nombre, COUNT(rf.id)) " +
            "from RecetasFavoritas rf " +
            "join rf.receta r " +
            "group by r.nombre " +
            "order by count (rf.id) desc ")
    List<EstadisticasRecetasDTO> findRecetasFavoritas();
}
