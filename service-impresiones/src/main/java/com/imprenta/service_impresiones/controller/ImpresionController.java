package com.imprenta.service_impresiones.controller;

import com.imprenta.service_impresiones.model.Impresion;
import com.imprenta.service_impresiones.service.ImpresionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/impresiones")
public class ImpresionController 
{
    @Autowired
    private ImpresionService impresionService;

    @GetMapping
    public List<Impresion> listar() 
    {
        return impresionService.listarTodas();
    }

    @PostMapping
    public Impresion crear(@RequestBody Impresion impresion) 
    {
        return impresionService.guardar(impresion);
    }

     @PutMapping("/{id}/listo")
    public Impresion marcarListo(@PathVariable Long id)
    {
        return impresionService.marcarComoListo(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) 
    {
    impresionService.eliminar(id);}

    @GetMapping("/{id}")
    public Impresion obtenerPorId(@PathVariable Long id) 
    {
        return impresionService.buscarPorId(id);
    }

}
