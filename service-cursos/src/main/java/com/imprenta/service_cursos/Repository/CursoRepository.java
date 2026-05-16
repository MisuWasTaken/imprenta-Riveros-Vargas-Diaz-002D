package com.imprenta.service_cursos.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.imprenta.service_cursos.Model.Curso;
import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> 
{
    List<Curso> findByNombreContainingIgnoreCase(String nombre);

    List<Curso> findByNivelIgnoreCase(String nivel);
    
    List<Curso> findByJornadaIgnoreCase(String jornada);
    
    List<Curso> findByNombreContainingIgnoreCaseAndJornadaIgnoreCase(String nombre, String jornada);
}