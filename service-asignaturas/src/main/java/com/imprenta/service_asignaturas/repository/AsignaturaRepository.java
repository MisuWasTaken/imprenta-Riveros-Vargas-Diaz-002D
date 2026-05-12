package com.imprenta.service_asignaturas.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imprenta.service_asignaturas.model.Asignatura;

@Repository
public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> 
{
    List<Asignatura> findByNombreContainingIgnoreCase(String nombre);
    Asignatura findBySigla(String sigla);
}