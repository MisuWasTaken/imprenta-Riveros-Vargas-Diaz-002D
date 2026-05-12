package com.imprenta.imprenta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.imprenta.imprenta.service.ImpresionService;

public class ImpresionControl 
{
 @Autowired
    private ImpresionService impresionService;

    @GetMapping
    public List<Impresion> listar() 
    {
        return impresionService.listar();
    }

    @PostMapping
    public Impresion guardar(@RequestBody Impresion impresion) 
    {
        return impresionService.guardar(impresion);
    }

    @GetMapping("/{id}")
    public Impresion buscar(@PathVariable Integer id) 
    {
        return impresionService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) 
    {
        impresionService.eliminar(id);
    }
}
