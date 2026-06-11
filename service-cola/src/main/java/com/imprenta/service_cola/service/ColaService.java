package com.imprenta.service_cola.service;
import com.imprenta.service_cola.model.ColaImpresion;
import com.imprenta.service_cola.repository.ColaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ColaService {

    @Autowired
    private ColaRepository colaRepository;

    public List<ColaImpresion> listarTodos() 
    {
        return colaRepository.findAll();
    }

    public ColaImpresion guardar(ColaImpresion colaImpresion) 
    {
        return colaRepository.save(colaImpresion);
    }

    public ColaImpresion actualizar(Long id, ColaImpresion colaImpresion) 
    {
        ColaImpresion colaExistente = colaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de cola no encontrado"));

        colaExistente.setImpresionId(colaImpresion.getImpresionId());
        colaExistente.setPrioridad(colaImpresion.getPrioridad());
        colaExistente.setEstadoCola(colaImpresion.getEstadoCola());

        return colaRepository.save(colaExistente);
    }

    public void eliminar(Long id) 
    {
        colaRepository.deleteById(id);
    }

    public ColaImpresion marcarLista(Long id) 
    {
        ColaImpresion colaExistente = colaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Registro de cola no encontrado"));

        colaExistente.setEstadoCola("LISTA");

        return colaRepository.save(colaExistente);
    }

    public List<ColaImpresion> listarUrgentes() 
    {
        return colaRepository.findByPrioridad("URGENTE");
    }
}