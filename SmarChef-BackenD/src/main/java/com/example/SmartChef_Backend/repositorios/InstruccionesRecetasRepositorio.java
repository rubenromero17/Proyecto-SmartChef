package com.example.SmartChef_Backend.repositorios;
import com.example.SmartChef_Backend.modelos.InstruccionesRecetas;
import com.example.SmartChef_Backend.modelos.Recetas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InstruccionesRecetasRepositorio extends JpaRepository<InstruccionesRecetas, Integer> {

    List<InstruccionesRecetas> findByReceta_Id(Integer recetaId);
    void deleteByReceta_Id(Integer recetaId);


}
