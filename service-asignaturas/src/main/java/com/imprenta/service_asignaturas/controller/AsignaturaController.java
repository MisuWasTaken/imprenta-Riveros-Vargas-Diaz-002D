package com.imprenta.service_asignaturas.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.imprenta.service_asignaturas.model.Asignatura;
import com.imprenta.service_asignaturas.service.AsignaturaService;

@RequestMapping("/asignaturas")
public class AsignaturaController 
{
    @Autowired
    private AsignaturaService asignaturaService;

    @GetMapping
    public List<Asignatura> listar() 
    {
        return asignaturaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> obtener(@PathVariable Long id) 
    {
        return asignaturaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public List<Asignatura> buscarPorNombre(@PathVariable String nombre) 
    {
        return asignaturaService.buscarPorNombre(nombre);
    }

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

    @PostMapping
    public ResponseEntity<Asignatura> crear(@RequestBody Asignatura asignatura) 
    {
        return ResponseEntity.ok(asignaturaService.guardar(asignatura));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asignatura> actualizar(@PathVariable Long id, @RequestBody Asignatura asignatura) 
    {
        return ResponseEntity.ok(asignaturaService.actualizar(id, asignatura));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) 
    {
        asignaturaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}