package com.imprenta.service_cursos.Service;
import com.imprenta.service_cursos.Model.Curso;
import com.imprenta.service_cursos.Repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService 
{
    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> listarTodos() 
    {
        return cursoRepository.findAll();
    }

    public Optional<Curso> buscarPorId(Long id) 
    {
        return cursoRepository.findById(id);
    }

    public List<Curso> buscarPorNombre(String nombre) 
    {
        return cursoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public Curso guardar(Curso curso) 
    {
        return cursoRepository.save(curso);
    }

    public List<Curso> buscarPorNivel(String nivel) 
    {
        return cursoRepository.findByNivelIgnoreCase(nivel);
    }

    public List<Curso> buscarPorJornada(String jornada) 
    {
        return cursoRepository.findByJornadaIgnoreCase(jornada);
    }

    public List<Curso> buscarPorNombreYJornada(String nombre, String jornada) 
    {
        return cursoRepository.findByNombreContainingIgnoreCaseAndJornadaIgnoreCase(nombre, jornada);
    }

    public Curso actualizar(Long id, Curso curso) 
    {
        Curso cursoExistente = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        cursoExistente.setNombre(curso.getNombre());
        cursoExistente.setNivel(curso.getNivel());
        cursoExistente.setJornada(curso.getJornada());
        
        return cursoRepository.save(cursoExistente);
    }

    public void eliminar(Long id) 
    {
        cursoRepository.deleteById(id);
    }
}