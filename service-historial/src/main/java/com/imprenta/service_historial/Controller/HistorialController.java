package com.imprenta.service_historial.Controller;
import com.imprenta.service_historial.Model.Historial;
import com.imprenta.service_historial.Service.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;


@RestController
@RequestMapping("/historial")
@CrossOrigin(origins = "*")
@Tag(name = "Historial", description = "Operaciones relacionadas con el historial de pedidos")
public class HistorialController 
{
    @Autowired
    private HistorialService historialService;

    @Operation(summary = "Mostrar el historial de todos los pedidos", description = "Mostrar el historial de todos los pedidos")
    @GetMapping
    public List<Historial> listar() {
        return historialService.listarTodos();
    }

    @Operation(summary = "Buscar por ID", description = "Busca un registro de historial por su ID")
    @GetMapping("/{id}")
    public Historial buscar(@PathVariable Long id) {
        return historialService.buscarPorId(id);
    }

    @Operation(summary = "Crear un nuevo registro", description = "Crear un nuevo registro de historial")
    @PostMapping
    public Historial crear(@RequestBody Historial historial) {
        return historialService.guardar(historial);
    }

    @Operation(summary = "Eliminar un registro por ID", description = "Elimina un registro de historial por su ID")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        historialService.eliminar(id);
    }
}
