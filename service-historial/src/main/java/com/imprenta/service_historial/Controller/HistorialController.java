package com.imprenta.service_historial.Controller;

import com.imprenta.service_historial.Model.Historial;
import com.imprenta.service_historial.Service.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/historial")
public class HistorialController 
{
    @Autowired
    private HistorialService historialService;

    @GetMapping
    public List<Historial> listar() {
        return historialService.listarTodos();
    }

    @GetMapping("/{id}")
    public Historial buscar(@PathVariable Long id) {
        return historialService.buscarPorId(id);
    }

    @PostMapping
    public Historial crear(@RequestBody Historial historial) {
        return historialService.guardar(historial);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        historialService.eliminar(id);
    }
}
