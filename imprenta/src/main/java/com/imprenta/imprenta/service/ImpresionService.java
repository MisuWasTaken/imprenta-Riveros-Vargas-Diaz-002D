package com.imprenta.imprenta.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.imprenta.imprenta.model.Impresion;
import com.imprenta.imprenta.repository.a.ImpresionRepository;

public class ImpresionService 
{
    @Autowired
    private ImpresionRepository impresionRepository;

    public List<Impresion> listar() 
    {
        return impresionRepository.findAll();
    }

    public Impresion guardar(Impresion impresion) 
    {
        return impresionRepository.save(impresion);
    }

    public Impresion buscarPorId(Integer id) 
    {
        return impresionRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) 
    {
        impresionRepository.deleteById(id);
    }
}
