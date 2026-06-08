package com.imprenta.service_asignaturas.service;
import com.imprenta.service_asignaturas.model.Asignatura;
import com.imprenta.service_asignaturas.repository.AsignaturaRepository;
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
class AsignaturaServiceTest {

    @Mock
    private AsignaturaRepository asignaturaRepository;

    @InjectMocks
    private AsignaturaService asignaturaService;

    @Test
    void listarTodasTest() {
        Asignatura asignatura1 = new Asignatura(1L, "MAT", "Matematicas");
        Asignatura asignatura2 = new Asignatura(2L, "LEN", "Lenguaje");

        when(asignaturaRepository.findAll()).thenReturn(Arrays.asList(asignatura1, asignatura2));

        List<Asignatura> resultado = asignaturaService.listarTodas();

        assertEquals(2, resultado.size());
        assertEquals("Matematicas", resultado.get(0).getNombre());

        verify(asignaturaRepository, times(1)).findAll();
    }

    @Test
    void buscarPorIdTest() {
        Asignatura asignatura = new Asignatura(1L, "MAT", "Matematicas");

        when(asignaturaRepository.findById(1L)).thenReturn(Optional.of(asignatura));

        Optional<Asignatura> resultado = asignaturaService.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals("MAT", resultado.get().getSigla());

        verify(asignaturaRepository, times(1)).findById(1L);
    }

    @Test
    void buscarPorNombreTest() {
        Asignatura asignatura = new Asignatura(1L, "MAT", "Matematicas");

        when(asignaturaRepository.findByNombreContainingIgnoreCase("mate"))
                .thenReturn(Arrays.asList(asignatura));

        List<Asignatura> resultado = asignaturaService.buscarPorNombre("mate");

        assertEquals(1, resultado.size());
        assertEquals("Matematicas", resultado.get(0).getNombre());

        verify(asignaturaRepository, times(1)).findByNombreContainingIgnoreCase("mate");
    }

    @Test
    void buscarPorSiglaTest() {
        Asignatura asignatura = new Asignatura(1L, "MAT", "Matematicas");

        when(asignaturaRepository.findBySigla("MAT")).thenReturn(asignatura);

        Asignatura resultado = asignaturaService.buscarPorSigla("MAT");

        assertNotNull(resultado);
        assertEquals("Matematicas", resultado.getNombre());

        verify(asignaturaRepository, times(1)).findBySigla("MAT");
    }

    @Test
    void guardarTest() {
        Asignatura asignatura = new Asignatura(null, "HIS", "Historia");
        Asignatura asignaturaGuardada = new Asignatura(1L, "HIS", "Historia");

        when(asignaturaRepository.save(asignatura)).thenReturn(asignaturaGuardada);

        Asignatura resultado = asignaturaService.guardar(asignatura);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Historia", resultado.getNombre());

        verify(asignaturaRepository, times(1)).save(asignatura);
    }

    @Test
    void actualizarTest() {
        Asignatura existente = new Asignatura(1L, "MAT", "Matematicas");
        Asignatura datosNuevos = new Asignatura(null, "MAT2", "Matematicas II");
        Asignatura actualizada = new Asignatura(1L, "MAT2", "Matematicas II");

        when(asignaturaRepository.findById(1L)).thenReturn(Optional.of(existente));
        when(asignaturaRepository.save(existente)).thenReturn(actualizada);

        Asignatura resultado = asignaturaService.actualizar(1L, datosNuevos);

        assertEquals("MAT2", resultado.getSigla());
        assertEquals("Matematicas II", resultado.getNombre());

        verify(asignaturaRepository, times(1)).findById(1L);
        verify(asignaturaRepository, times(1)).save(existente);
    }

    @Test
    void eliminarTest() {
        doNothing().when(asignaturaRepository).deleteById(1L);

        asignaturaService.eliminar(1L);

        verify(asignaturaRepository, times(1)).deleteById(1L);
    }
}