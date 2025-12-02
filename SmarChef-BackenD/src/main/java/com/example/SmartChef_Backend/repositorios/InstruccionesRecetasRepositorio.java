package com.example.SmartChef_Backend.repositorios;
import com.example.SmartChef_Backend.modelos.InstruccionesRecetas;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InstruccionesRecetasRepositorio extends JpaRepository<InstruccionesRecetas, Integer> {


}
