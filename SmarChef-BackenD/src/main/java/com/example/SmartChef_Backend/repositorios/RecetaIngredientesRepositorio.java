package com.example.SmartChef_Backend.repositorios;

import com.example.SmartChef_Backend.dto.EstadisticasIngredientesDTO;
import com.example.SmartChef_Backend.modelos.RecetaIngredientes;
import org.checkerframework.checker.units.qual.C;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface RecetaIngredientesRepositorio extends JpaRepository<RecetaIngredientes, Integer> {
    List<RecetaIngredientes> findByRecetaId(Integer idReceta);

//hago el select new para pasar directamente el dto no la entidad
    @Query("select new com.example.SmartChef_Backend.dto.EstadisticasIngredientesDTO(ri.ingrediente.nombre, count (distinct ri.receta.id)) " +
            "from RecetaIngredientes ri " +
            "group by  ri.ingrediente.nombre " +
            "order by  count (distinct ri.receta.id) desc ")
    List<EstadisticasIngredientesDTO> findTopIngredientes();
}
