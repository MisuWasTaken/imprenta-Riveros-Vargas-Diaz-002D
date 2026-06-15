package com.imprenta.service_retiros.service;
import com.imprenta.service_retiros.model.Retiro;
import com.imprenta.service_retiros.repository.RetiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetiroService {

    @Autowired
    private RetiroRepository retiroRepository;

    public List<Retiro> listarTodos() 
    {
        return retiroRepository.findAll();
    }

    public Retiro guardar(Retiro retiro) 
    {
        return retiroRepository.save(retiro);
    }

    public Retiro actualizar(Long id, Retiro retiro) {
        Retiro retiroExistente = retiroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Retiro no encontrado"));

        retiroExistente.setImpresionId(retiro.getImpresionId());
        retiroExistente.setEstadoRetiro(retiro.getEstadoRetiro());

        return retiroRepository.save(retiroExistente);
    }

    public void eliminar(Long id) 
    {
        retiroRepository.deleteById(id);
    }
}