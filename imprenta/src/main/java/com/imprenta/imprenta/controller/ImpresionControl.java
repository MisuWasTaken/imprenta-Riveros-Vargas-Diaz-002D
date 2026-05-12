package com.imprenta.imprenta.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.imprenta.imprenta.model.ImpresionModel;
import com.imprenta.imprenta.service.ImpresionService;

@RestController
@RequestMapping("/api/impresiones")
public class ImpresionControl {

    @Autowired
    private ImpresionService impresionService;

    @GetMapping
    public List<ImpresionModel> listar() 
    {
        return impresionService.listar();
    }

    @PostMapping
    public ImpresionModel guardar(@RequestBody ImpresionModel impresion) 
    {
        return impresionService.guardar(impresion);
    }

    @GetMapping("/{id}")
    public ImpresionModel buscar(@PathVariable Integer id) 
    {
        return impresionService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) 
    {
        impresionService.eliminar(id);
    }
}