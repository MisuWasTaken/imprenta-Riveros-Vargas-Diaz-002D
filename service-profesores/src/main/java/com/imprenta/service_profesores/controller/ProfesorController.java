package com.imprenta.service_profesores.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.imprenta.service_profesores.model.Profesor;
import com.imprenta.service_profesores.service.ProfesorService;

@RestController
@RequestMapping("/profesores")
public class ProfesorController 
{
    @Autowired
    private ProfesorService profesorService;

    @GetMapping
    public List<Profesor> listar() {
        return profesorService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> obtener(@PathVariable Long id) {
        return profesorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public List<Profesor> buscarPorNombre(@PathVariable String nombre) {
        return profesorService.buscarPorNombre(nombre);
    }

    @GetMapping("/apellido/{apellido}")
    public List<Profesor> buscarPorApellido(@PathVariable String apellido) {
        return profesorService.buscarPorApellido(apellido);
    }

    @GetMapping("/correo")
    public ResponseEntity<Profesor> buscarPorCorreo(@RequestParam String correo) {
        Profesor profesor = profesorService.buscarPorCorreo(correo);

        if (profesor == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(profesor);
    }

    @PostMapping
    public ResponseEntity<Profesor> crear(@RequestBody Profesor profesor) {
        return ResponseEntity.ok(profesorService.guardar(profesor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Profesor> actualizar(@PathVariable Long id, @RequestBody Profesor profesor) {
        return ResponseEntity.ok(profesorService.actualizar(id, profesor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        profesorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}