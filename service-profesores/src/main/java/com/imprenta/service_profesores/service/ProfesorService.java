package com.imprenta.service_profesores.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.imprenta.service_profesores.model.Profesor;
import com.imprenta.service_profesores.repository.ProfesorRepository;

@Service
public class ProfesorService 
{
    @Autowired
    private ProfesorRepository profesorRepository;

    public List<Profesor> listarTodos() {
        return profesorRepository.findAll();
    }

    public Optional<Profesor> buscarPorId(Long id) {
        return profesorRepository.findById(id);
    }

    public List<Profesor> buscarPorNombre(String nombre) {
        return profesorRepository.findByNombreContainingIgnoreCase(nombre);
    }

    public List<Profesor> buscarPorApellido(String apellido) {
        return profesorRepository.findByApellidoContainingIgnoreCase(apellido);
    }

    public Profesor buscarPorCorreo(String correo) {
        return profesorRepository.findByCorreo(correo);
    }

    public Profesor guardar(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public Profesor actualizar(Long id, Profesor profesor) {
        Profesor profesorExistente = profesorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        profesorExistente.setNombre(profesor.getNombre());
        profesorExistente.setApellido(profesor.getApellido());
        profesorExistente.setCorreo(profesor.getCorreo());
        profesorExistente.setTelefono(profesor.getTelefono());

        return profesorRepository.save(profesorExistente);
    }

    public void eliminar(Long id) {
        profesorRepository.deleteById(id);
    }
}