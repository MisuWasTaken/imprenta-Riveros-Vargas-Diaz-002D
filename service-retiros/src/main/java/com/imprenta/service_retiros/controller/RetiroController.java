package com.imprenta.service_retiros.controller;
import com.imprenta.service_retiros.model.Retiro;
import com.imprenta.service_retiros.service.RetiroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/retiros")
@Tag(name = "Retiros", description = "Operaciones relacionadas para saber si una impresion ha sido retirada o no")
public class RetiroController {

    @Autowired
    private RetiroService retiroService;

    @Operation(summary = "Mostrar estado de todos los retiros", description = "Muestra el estado de todas las impresiones")
    @GetMapping
    public List<Retiro> listar() 
    {
        return retiroService.listarTodos();
    }

    @Operation(summary = "Crear retiro", description = "Crear un nuevo estado de retiro de impresion")
    @PostMapping
    public Retiro crear(@RequestBody Retiro retiro) 
    {
        return retiroService.guardar(retiro);
    }

    @Operation(summary = "Actualizar retiro", description = "Actualiza el estado de retiro de una impresion por ID")
    @PutMapping("/{id}")
    public Retiro actualizar(@PathVariable Long id, @RequestBody Retiro retiro) {
        return retiroService.actualizar(id, retiro);
    }

    @Operation(summary = "Eliminar retiro", description = "Elimina un estado de retiro de impresion por ID")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        retiroService.eliminar(id);
    }
}