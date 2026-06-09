package com.imprenta.service_impresiones.controller;
import com.imprenta.service_impresiones.model.Impresion;
import com.imprenta.service_impresiones.service.ImpresionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/impresiones")
@Tag(name = "Impresiones", description = "Operaciones relacionadas con las impresiones")
public class ImpresionController 
{
    @Autowired
    private ImpresionService impresionService;

    @Operation(summary = "Mostrar todas las impresiones", description = "Obtiene todas las solicitudes de impresión con sus datos relacionados")
    @GetMapping
    public List<Impresion> listar() 
    {
        return impresionService.listarTodas();
    }

    @Operation(summary = "Crear una nueva impresión", description = "Crea una nueva solicitud de impresión")
    @PostMapping
    public Impresion crear(@RequestBody Impresion impresion) 
    {
        return impresionService.guardar(impresion);
    }

    @Operation(summary = "Cambiar estado de impresion por ID", description = "Marca una solicitud de impresión como lista")
    @PutMapping("/{id}/listo")
    public Impresion marcarListo(@PathVariable Long id)
    {
        return impresionService.marcarComoListo(id);
    }

    @Operation(summary = "Eliminar impresión", description = "Elimina una solicitud de impresión")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) 
    {
    impresionService.eliminar(id);}

    @Operation(summary = "Obtener impresión por ID", description = "Obtiene una solicitud de impresión por su ID")
    @GetMapping("/{id}")
    public Impresion obtenerPorId(@PathVariable Long id) 
    {
        return impresionService.buscarPorId(id);
    }

}
