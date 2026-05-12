package com.imprenta.imprenta.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.imprenta.imprenta.model.ImpresionModel;
import com.imprenta.imprenta.repository.a.ImpresionRepository;

@Service
public class ImpresionService {

    @Autowired
    private ImpresionRepository impresionRepository;

    public List<ImpresionModel> listar() {
        return impresionRepository.findAll();
    }

    public ImpresionModel guardar(ImpresionModel impresion) {
        return impresionRepository.save(impresion);
    }

    public ImpresionModel buscarPorId(Integer id) {
        return impresionRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        impresionRepository.deleteById(id);
    }
}