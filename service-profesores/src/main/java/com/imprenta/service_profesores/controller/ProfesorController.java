package com.imprenta.service_profesores.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.imprenta.service_profesores.model.Profesor;
import com.imprenta.service_profesores.service.ProfesorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Profesores", description = "Operaciones relacionadas con los profesores")
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/profesores")
public class ProfesorController 
{
    @Autowired
    private ProfesorService profesorService;

    @Operation(summary = "Mostrar todos los profesores", description = "Obtiene todos los profesores registrados")
    @GetMapping
    public List<Profesor> listar() {
        return profesorService.listarTodos();
    }

    @Operation(summary = "Buscar profesor por ID", description = "Obtiene un profesor especifico por la id")
    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtener(@PathVariable Long id) {
        return profesorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Buscar profesor por nombre", description = "Busca un profesor por su nombre")
    @GetMapping("/nombre/{nombre}")
    public List<Profesor> buscarPorNombre(@PathVariable String nombre) {
        return profesorService.buscarPorNombre(nombre);
    }

    @Operation(summary = "Buscar profesores por apellido", description = "Busca un profesor por su apellido")
    @GetMapping("/apellido/{apellido}")
    public List<Profesor> buscarPorApellido(@PathVariable String apellido) {
        return profesorService.buscarPorApellido(apellido);
    }

    @Operation(summary = "Buscar profesor por correo", description = "Busca un profesor por su correo electrónico")
    @GetMapping("/correo")
    public ResponseEntity<Profesor> buscarPorCorreo(@RequestParam String correo) {
        Profesor profesor = profesorService.buscarPorCorreo(correo);

        if (profesor == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(profesor);
    }

    @Operation(summary = "Crear profesor", description = "Crea un nuevo profesor")
    @PostMapping
    public ResponseEntity<Profesor> crear(@RequestBody Profesor profesor) {
        return ResponseEntity.ok(profesorService.guardar(profesor));
    }
    @Operation(summary = "Actualizar profesor", description = "Actualiza los datos de un profesor existente")
    @PutMapping("/{id}")
    public ResponseEntity<Profesor> actualizar(@PathVariable Long id, @RequestBody Profesor profesor) {
        return ResponseEntity.ok(profesorService.actualizar(id, profesor));
    }

    @Operation(summary = "Eliminar profesor", description = "Elimina un profesor")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        profesorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}