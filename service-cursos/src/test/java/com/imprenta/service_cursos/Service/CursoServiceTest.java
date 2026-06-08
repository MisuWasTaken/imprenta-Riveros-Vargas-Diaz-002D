package com.imprenta.service_cursos.Service;
import com.imprenta.service_cursos.Model.Curso;
import com.imprenta.service_cursos.Repository.CursoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CursoServiceTest 
{

    @Mock
    private CursoRepository cursoRepository;

    @InjectMocks
    private CursoService cursoService;

    @Test
    void listarTodosTest() 
    {
        Curso curso1 = new Curso(1L, "1 Basico A", "Basico", "Diurna");
        Curso curso2 = new Curso(2L, "1 Medio A", "Medio", "Nocturno");

        when(cursoRepository.findAll()).thenReturn(Arrays.asList(curso1, curso2));

        List<Curso> resultado = cursoService.listarTodos();

        assertEquals(2, resultado.size());
        assertEquals("1 Basico A", resultado.get(0).getNombre());

        verify(cursoRepository, times(1)).findAll();
    }

    @Test
    void buscarPorIdTest() 
    {
        Curso curso = new Curso(1L, "1 Basico A", "Basico", "Diurna");
        
        when(cursoRepository.findById(1L)).thenReturn(Optional.of(curso));

        Optional<Curso> resultado = cursoService.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals("1 Basico A", resultado.get().getNombre());

        verify(cursoRepository, times(1)).findById(1L);
    }

    @Test
    void guardarTest() 
    {
        Curso curso = new Curso(null, "2 Basico B", "Basico", "Diurna");
        Curso cursoGuardado = new Curso(1L, "2 Basico B", "Basico", "Diurna");

        when(cursoRepository.save(curso)).thenReturn(cursoGuardado);

        Curso resultado = cursoService.guardar(curso);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("2 Basico B", resultado.getNombre());

        verify(cursoRepository, times(1)).save(curso);
    }

    @Test
    void buscarPorNombreTest() 
    {
        Curso curso = new Curso(1L, "1 Basico A", "Basico", "Diurna");
        when(cursoRepository.findByNombreContainingIgnoreCase("Basico"))
                .thenReturn(Arrays.asList(curso));

        List<Curso> resultado = cursoService.buscarPorNombre("Basico");

        assertEquals(1, resultado.size());
        assertEquals("1 Basico A", resultado.get(0).getNombre());

        verify(cursoRepository, times(1)).findByNombreContainingIgnoreCase("Basico");
    }

    @Test
    void buscarPorNivelTest() 
    {
        Curso curso = new Curso(1L, "1 Basico A", "Basico", "Diurna");
        when(cursoRepository.findByNivelIgnoreCase("Basico"))
                .thenReturn(Arrays.asList(curso));

        List<Curso> resultado = cursoService.buscarPorNivel("Basico");

        assertEquals(1, resultado.size());
        assertEquals("Basico", resultado.get(0).getNivel());

        verify(cursoRepository, times(1)).findByNivelIgnoreCase("Basico");
    }

    @Test
    void buscarPorJornadaTest() 
    {
        Curso curso = new Curso(1L, "1 Basico A", "Basico", "Diurna");

        when(cursoRepository.findByJornadaIgnoreCase("Diurna"))
                .thenReturn(Arrays.asList(curso));

        List<Curso> resultado = cursoService.buscarPorJornada("Diurna");

        assertEquals(1, resultado.size());
        assertEquals("Diurna", resultado.get(0).getJornada());

        verify(cursoRepository, times(1)).findByJornadaIgnoreCase("Diurna");
    }

    @Test
    void buscarPorNombreYJornadaTest() 
    {
        Curso curso = new Curso(1L, "1 Basico A", "Basico", "Diurna");
        when(cursoRepository.findByNombreContainingIgnoreCaseAndJornadaIgnoreCase("Basico", "Diurna"))
                .thenReturn(Arrays.asList(curso));

        List<Curso> resultado = cursoService.buscarPorNombreYJornada("Basico", "Diurna");

        assertEquals(1, resultado.size());
        assertEquals("1 Basico A", resultado.get(0).getNombre());

        verify(cursoRepository, times(1))
                .findByNombreContainingIgnoreCaseAndJornadaIgnoreCase("Basico", "Diurna");
    }

    @Test
    void actualizarTest() 
    {
        Curso existente = new Curso(1L, "1 Basico A", "Basico", "Diurna");
        Curso datosNuevos = new Curso(null, "1 Medio A", "Medio", "Nocturno");
        Curso actualizado = new Curso(1L, "1 Medio A", "Medio", "Nocturno");

        when(cursoRepository.findById(1L)).thenReturn(Optional.of(existente));
        when(cursoRepository.save(existente)).thenReturn(actualizado);

        Curso resultado = cursoService.actualizar(1L, datosNuevos);

        assertEquals("1 Medio A", resultado.getNombre());
        assertEquals("Medio", resultado.getNivel());
        assertEquals("Nocturno", resultado.getJornada());

        verify(cursoRepository, times(1)).findById(1L);
        verify(cursoRepository, times(1)).save(existente);
    }

    @Test
    void eliminarTest() 
    {
        doNothing().when(cursoRepository).deleteById(1L);
        cursoService.eliminar(1L);
        verify(cursoRepository, times(1)).deleteById(1L);
    }
}