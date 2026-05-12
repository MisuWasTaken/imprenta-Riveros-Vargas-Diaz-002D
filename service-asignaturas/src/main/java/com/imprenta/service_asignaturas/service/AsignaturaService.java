package com.imprenta.service_asignaturas.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.imprenta.service_asignaturas.model.Asignatura;
import com.imprenta.service_asignaturas.repository.AsignaturaRepository;

@Service
public class AsignaturaService 
{
    @Autowired
    private AsignaturaRepository asignaturaRepository;
    public List<Asignatura> listarTodas() 
    {
        return asignaturaRepository.findAll();
    }

    public Optional<Asignatura> buscarPorId(Long id) 
    {
        return asignaturaRepository.findById(id);
    }

    public List<Asignatura> buscarPorNombre(String nombre) 
    {
        return asignaturaRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public Asignatura buscarPorSigla(String sigla) 
    {
        return asignaturaRepository.findBySigla(sigla);
    }

    public Asignatura guardar(Asignatura asignatura) 
    {
        return asignaturaRepository.save(asignatura);
    }

    public Asignatura actualizar(Long id, Asignatura asignatura) 
    {
        Asignatura asignaturaExistente = asignaturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignatura no encontrada"));

        asignaturaExistente.setSigla(asignatura.getSigla());
        asignaturaExistente.setNombre(asignatura.getNombre());
        return asignaturaRepository.save(asignaturaExistente);

    }
    public void eliminar(Long id) {
        asignaturaRepository.deleteById(id);
    }
}