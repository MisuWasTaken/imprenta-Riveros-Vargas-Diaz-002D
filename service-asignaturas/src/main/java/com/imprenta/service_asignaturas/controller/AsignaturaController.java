package com.imprenta.service_asignaturas.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.imprenta.service_asignaturas.model.Asignatura;
import com.imprenta.service_asignaturas.service.AsignaturaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/asignaturas")
@Tag(name = "Asignaturas", description = "Operaciones relacionadas con las asignaturas")
public class AsignaturaController 
{
    @Autowired
    private AsignaturaService asignaturaService;

    @Operation(summary = "Mostrar todas las asignaturas")
    @GetMapping
    public List<Asignatura> listar() 
    {
        return asignaturaService.listarTodas();
    }

    @Operation(summary = "Buscar una asignatura por su ID")
    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> obtener(@PathVariable Long id) 
    {
        return asignaturaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Buscar asignaturas por nombre")
    @GetMapping("/nombre/{nombre}")
    public List<Asignatura> buscarPorNombre(@PathVariable String nombre) 
    {
        return asignaturaService.buscarPorNombre(nombre);
    }

    @Operation(summary = "Buscar una asignatura por su sigla")
    @GetMapping("/sigla/{sigla}")
    public ResponseEntity<Asignatura> buscarPorSigla(@PathVariable String sigla) 
    {
        Asignatura asignatura = asignaturaService.buscarPorSigla(sigla);
        if (asignatura == null) 
            {
            return ResponseEntity.notFound().build();
         }
        return ResponseEntity.ok(asignatura);
    }

    @Operation(summary = "Crear una nueva asignatura")
    @PostMapping
    public ResponseEntity<Asignatura> crear(@RequestBody Asignatura asignatura) 
    {
        return ResponseEntity.ok(asignaturaService.guardar(asignatura));
    }

    @Operation(summary = "Actualizar una asignatura existente")
    @PutMapping("/{id}")
    public ResponseEntity<Asignatura> actualizar(@PathVariable Long id, @RequestBody Asignatura asignatura) 
    {
        return ResponseEntity.ok(asignaturaService.actualizar(id, asignatura));
    }

    @Operation(summary = "Eliminar una asignatura por su id")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) 
    {
        asignaturaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}