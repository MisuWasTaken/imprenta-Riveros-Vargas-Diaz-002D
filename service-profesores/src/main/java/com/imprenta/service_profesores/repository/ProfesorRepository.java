package com.imprenta.service_profesores.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imprenta.service_profesores.model.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> 
{
    List<Profesor> findByNombreContainingIgnoreCase(String nombre);

    List<Profesor> findByApellidoContainingIgnoreCase(String apellido);

    Profesor findByCorreo(String correo);
}