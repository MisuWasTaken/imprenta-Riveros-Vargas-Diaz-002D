package com.imprenta.service_cola.controller;
import com.imprenta.service_cola.model.ColaImpresion;
import com.imprenta.service_cola.service.ColaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/cola")
@CrossOrigin(origins = "*")
@Tag(name = "Cola de impresión", description = "Todo lo relacionado con la cola de impresion")
public class ColaController {

    @Autowired
    private ColaService colaService;

    @Operation(summary = "Mostrar toda la cola", description = "Muestra toda la cola de impresion")
    @GetMapping
    public List<ColaImpresion> listar() {
        return colaService.listarTodos();
    }

    @Operation(summary = "Agregar una impresion a la cola", description = "Agrega una impresion a la cola")
    @PostMapping
    public ColaImpresion crear(@RequestBody ColaImpresion colaImpresion) {
        return colaService.guardar(colaImpresion);
    }

    @Operation(summary = "Actualizar una impresion en la cola", description = "Actualiza los datos de una impresión dentro de la cola")
    @PutMapping("/{id}")
    public ColaImpresion actualizar(@PathVariable Long id, @RequestBody ColaImpresion colaImpresion) {
        return colaService.actualizar(id, colaImpresion);
    }

    @Operation(summary = "Eliminar registro de cola por id", description = "Elimina un registro de la cola por id")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        colaService.eliminar(id);
    }

    @Operation(summary = "Marcar como Lista", description = "Cambia el estado de una impresion en cola a Lista")
    @PutMapping("/{id}/lista")
    public ColaImpresion marcarLista(@PathVariable Long id) {
    return colaService.marcarLista(id);
}

    @Operation(summary = "Mostrar todas las urgentes", description = "Muestra todas las impresiones que esten en URGENTE")
    @GetMapping("/urgentes")
    public List<ColaImpresion> listarUrgentes() {
        return colaService.listarUrgentes();
    }
}