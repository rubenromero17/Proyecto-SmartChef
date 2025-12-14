package com.example.SmartChef_Backend.repositorios;
import com.example.SmartChef_Backend.dto.EstadisticasIngredientesDTO;
import com.example.SmartChef_Backend.dto.EstadisticasRecetasDTO;
import com.example.SmartChef_Backend.dto.FavoritayUsuarioDTO;
import com.example.SmartChef_Backend.modelos.Recetas;
import com.example.SmartChef_Backend.modelos.RecetasFavoritas;
import com.example.SmartChef_Backend.modelos.Usuarios;
import com.zaxxer.hikari.util.ClockSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecetasFavoritasRepositorio extends JpaRepository<RecetasFavoritas, Integer> {

    boolean existsByUsuarioAndReceta(Usuarios usuario, Recetas receta);

    @Query(value = """
    select r.id_receta as recetaId, r.nombre as recetaNombre, u.nombre as usuarioNombre
    from recetas_favoritas rf
    join recetas r on r.id_receta = rf.id_receta
    join usuarios u on u.id_usuario = rf.id_usuario
    where rf.id_receta in (
        select id_receta
        from recetas_favoritas
        group by id_receta
        having COUNT(*) = (
            select MAX(cnt)
            from (
                select count(*) as cnt
                from recetas_favoritas
                group by id_receta
            ) as t
        )
    )
""", nativeQuery = true)
    List<FavoritayUsuarioDTO> recetasFavoritas();
}
