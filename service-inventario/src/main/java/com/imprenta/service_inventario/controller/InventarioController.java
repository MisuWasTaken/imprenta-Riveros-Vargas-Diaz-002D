package com.imprenta.service_inventario.controller;
import com.imprenta.service_inventario.model.Inventario;
import com.imprenta.service_inventario.service.InventarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/inventario")
@CrossOrigin(origins = "*")
@Tag(name = "Inventario", description = "Operaciones relacionadas con el inventario de materiales")
public class InventarioController 
{
    @Autowired
    private InventarioService inventarioService;

    @Operation(summary = "Mostrar todos los materiales", description = "Muestra todos los materiales disponibles en el inventario")
    @GetMapping
    public List<Inventario> listarTodos() {
        return inventarioService.listarTodos();
    }

    @Operation(summary = "Buscar materiales por nombre", description = "Busca materiales que contengan el nombre especificado")
    @GetMapping("/nombre/{nombre}")
    public List<Inventario> buscarPorNombre(@PathVariable String nombre) {
        return inventarioService.buscarPorNombre(nombre);
    }

    @Operation(summary = "Crear nuevo material", description = "Registra un nuevo material en el inventario")
    @PostMapping
    public Inventario crear(@RequestBody Inventario inventario) {
        return inventarioService.guardar(inventario);
    }

    
    @Operation(summary = "Actualizar material existente", description = "Actualiza la información de un material existente en el inventario")
    @PutMapping("/{id}")
    public Inventario actualizar(@PathVariable Long id, @RequestBody Inventario inventario) {
        return inventarioService.actualizar(id, inventario);
    }

    @Operation(summary = "Eliminar material por id", description = "Elimina un material del inventario por su ID")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        inventarioService.eliminar(id);
    }

    @Operation(summary = "Agregar x cantidad a material", description = "Agrega una cantidad específica a un material existente en el inventario")
    @PostMapping("/{id}/agregar")
    public Inventario agregarCantidad(@PathVariable Long id, @RequestParam Integer cantidad) {
        return inventarioService.agregarCantidad(id, cantidad);
    }


    @Operation(summary = "Quitar x cantidad de material", description = "Quita una cantidad específica de un material existente en el inventario")
    @PostMapping("/{id}/quitar")
    public Inventario quitarCantidad(@PathVariable Long id, @RequestParam Integer cantidad) {
        return inventarioService.quitarCantidad(id, cantidad);
    }
}
