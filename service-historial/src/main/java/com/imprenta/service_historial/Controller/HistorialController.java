package com.imprenta.service_historial.Controller;

import com.imprenta.service_historial.Model.Historial;
import com.imprenta.service_historial.Service.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/historial")
public class HistorialController 
{
    @Autowired
    private HistorialService historialService;

    @GetMapping
    public ResponseEntity<List<Historial>> listarTodos() 
    {
        return ResponseEntity.ok(historialService.listarTodos());
    }

    @GetMapping("/impresion/{impresionId}")
    public List<Historial> obtenerPorImpresion(@PathVariable Long impresionId) 
    {
        return historialService.buscarPorImpresion(impresionId);
    }

    @PostMapping
    public ResponseEntity<Historial> crear(@RequestBody Historial historial) 
    {
        return ResponseEntity.ok(historialService.guardar(historial));
    }
}
