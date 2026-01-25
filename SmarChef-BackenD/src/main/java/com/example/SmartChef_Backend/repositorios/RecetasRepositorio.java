package com.example.SmartChef_Backend.repositorios;
import com.example.SmartChef_Backend.modelos.Recetas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecetasRepositorio extends JpaRepository<Recetas, Integer> {

    Recetas findByNombre(String nombre);
    Recetas findAllByDescripcion(String descripcion);
    boolean existsByNombre(String nombre);
    Optional<Recetas> findById(Integer id);


    @Query("select distinct r from Recetas r join fetch r.ingredientes i "
            + "where (:economica is null or r.economica = :economica) "
            + "and (:vegetariana is null or r.vegetariana = :vegetariana) "
            + "and (:sinGluten is null or r.sin_gluten = :sinGluten) "
            + "and (:rapido is null or r.rapido = :rapido) "
            + "and (:ingredientes is null or i.nombre in :ingredientes)")
    List<Recetas> buscarRecetasConFiltros(
            @Param("ingredientes") List<String> ingredientes,
            @Param("economica") Boolean economica,
            @Param("vegetariana") Boolean vegetariana,
            @Param("sinGluten") Boolean sinGluten,
            @Param("rapido") Boolean rapido
    );
}
