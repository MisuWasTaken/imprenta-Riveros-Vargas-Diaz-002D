package com.imprenta.service_historial.Service;

import com.imprenta.service_historial.Model.Historial;
import com.imprenta.service_historial.Repository.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistorialService 
{
    @Autowired
    private HistorialRepository historialRepository;

    public List<Historial> listarTodos() 
    {
        return historialRepository.findAll();
    }

    public List<Historial> buscarPorImpresion(Long impresionId) 
    {
        return historialRepository.findByImpresionId(impresionId);
    }

    public Historial guardar(Historial historial) 
    {
        historial.setFecha(LocalDateTime.now());
        return historialRepository.save(historial);
    }
    
    public Historial buscarPorId(Long id) 
    {
        return historialRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrado"));
    }

    public void eliminar(Long id) 
    {
        historialRepository.deleteById(id);
    }
}
