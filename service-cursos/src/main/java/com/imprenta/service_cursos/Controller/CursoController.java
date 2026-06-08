package com.imprenta.service_cursos.Controller;
import com.imprenta.service_cursos.Model.Curso;
import com.imprenta.service_cursos.Service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/cursos")
@Tag(name = "Cursos", description = "Todo lo relacionado con los cursos")
public class CursoController 
{
    @Autowired
    private CursoService cursoService;

    @Operation(summary = "Mostrar todos los cursos", description = "Muestra todos los cursos registrados")
    @GetMapping
    public List<Curso> listar() 
    {
        return cursoService.listarTodos();
    }

    @Operation(summary = "Obtener curso", description = "Obtiene un curso por la ID")   
    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtener(@PathVariable Long id) 
    {
        return cursoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Buscar un curso por su nombre", description = "Busca cursos por su nombre")
    @GetMapping("/nombre/{nombre}")
    public List<Curso> buscarPorNombre(@PathVariable String nombre) 
    {
        return cursoService.buscarPorNombre(nombre);
    }

    @Operation(summary = "Crear un curso", description = "Crea un nuevo curso")
    @PostMapping
    public ResponseEntity<Curso> crear(@RequestBody Curso curso) 
    {
        return ResponseEntity.ok(cursoService.guardar(curso));
    }

    @Operation(summary = "Actualizar curso", description = "Actualiza los datos de un curso por id")
    @PutMapping("/{id}")
    public ResponseEntity<Curso> actualizar(@PathVariable Long id, @RequestBody Curso curso) 
    {
        return ResponseEntity.ok(cursoService.actualizar(id, curso));
    }

    @Operation(summary = "Eliminar curso", description = "Elimina un curso por su ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) 
    {
        cursoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Buscar cursos por nivel", description = "Busca cursos por su nivel")
    @GetMapping("/nivel/{nivel}")
    public List<Curso> buscarPorNivel(@PathVariable String nivel) 
    {
        return cursoService.buscarPorNivel(nivel);
    }

    @Operation(summary = "Buscar cursos por jornada", description = "Busca cursos por jornada")
    @GetMapping("/jornada/{jornada}")
    public List<Curso> buscarPorJornada(@PathVariable String jornada) 
    {
        return cursoService.buscarPorJornada(jornada);
    }

    @Operation(summary = "Buscar cursos por nombre y jornada", description = "Busca cursos por nombre y jornada")
    @GetMapping("/buscar")
    public List<Curso> buscarPorNombreYJornada(
            @RequestParam String nombre, 
            @RequestParam String jornada) 
            {
        return cursoService.buscarPorNombreYJornada(nombre, jornada);
    }
}