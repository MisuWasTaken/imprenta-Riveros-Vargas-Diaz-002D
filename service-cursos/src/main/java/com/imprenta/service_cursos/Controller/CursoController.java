package com.imprenta.service_cursos.Controller;
import com.imprenta.service_cursos.Model.Curso;
import com.imprenta.service_cursos.Service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/cursos")
public class CursoController 
{
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> listar() 
    {
        return cursoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtener(@PathVariable Long id) 
    {
        return cursoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nombre/{nombre}")
    public List<Curso> buscarPorNombre(@PathVariable String nombre) 
    {
        return cursoService.buscarPorNombre(nombre);
    }

    @PostMapping
    public ResponseEntity<Curso> crear(@RequestBody Curso curso) 
    {
        return ResponseEntity.ok(cursoService.guardar(curso));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizar(@PathVariable Long id, @RequestBody Curso curso) 
    {
        return ResponseEntity.ok(cursoService.actualizar(id, curso));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) 
    {
        cursoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/nivel/{nivel}")
    public List<Curso> buscarPorNivel(@PathVariable String nivel) 
    {
        return cursoService.buscarPorNivel(nivel);
    }

    @GetMapping("/jornada/{jornada}")
    public List<Curso> buscarPorJornada(@PathVariable String jornada) 
    {
        return cursoService.buscarPorJornada(jornada);
    }

    @GetMapping("/buscar")
    public List<Curso> buscarPorNombreYJornada(
            @RequestParam String nombre, 
            @RequestParam String jornada) 
            {
        return cursoService.buscarPorNombreYJornada(nombre, jornada);
    }
}