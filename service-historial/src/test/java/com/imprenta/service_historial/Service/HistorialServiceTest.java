package com.imprenta.service_historial.Service;
import com.imprenta.service_historial.Model.Historial;
import com.imprenta.service_historial.Repository.HistorialRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HistorialServiceTest {

    @Mock
    private HistorialRepository historialRepository;

    @InjectMocks
    private HistorialService historialService;

    @Test
    void listarTodosTest() {
        Historial historial1 = new Historial(1L, 10L, "CREADA", LocalDateTime.now());
        Historial historial2 = new Historial(2L, 11L, "CREADA", LocalDateTime.now());

        when(historialRepository.findAll()).thenReturn(Arrays.asList(historial1, historial2));

        List<Historial> resultado = historialService.listarTodos();

        assertEquals(2, resultado.size());
        assertEquals(10L, resultado.get(0).getImpresionId());

        verify(historialRepository, times(1)).findAll();
    }

    @Test
    void buscarPorImpresionTest() {
        Historial historial = new Historial(1L, 10L, "CREADA", LocalDateTime.now());

        when(historialRepository.findByImpresionId(10L)).thenReturn(Arrays.asList(historial));

        List<Historial> resultado = historialService.buscarPorImpresion(10L);

        assertEquals(1, resultado.size());
        assertEquals("CREADA", resultado.get(0).getAccion());

        verify(historialRepository, times(1)).findByImpresionId(10L);
    }

    @Test
    void guardarTest() {
        Historial historial = new Historial(null, 10L, "CREADA", null);
        Historial historialGuardado = new Historial(1L, 10L, "CREADA", LocalDateTime.now());

        when(historialRepository.save(any(Historial.class))).thenReturn(historialGuardado);

        Historial resultado = historialService.guardar(historial);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("CREADA", resultado.getAccion());

        verify(historialRepository, times(1)).save(any(Historial.class));
    }

    @Test
    void buscarPorIdTest() {
        Historial historial = new Historial(1L, 10L, "CREADA", LocalDateTime.now());

        when(historialRepository.findById(1L)).thenReturn(Optional.of(historial));

        Historial resultado = historialService.buscarPorId(1L);

        assertNotNull(resultado);
        assertEquals(10L, resultado.getImpresionId());

        verify(historialRepository, times(1)).findById(1L);
    }

    @Test
    void eliminarTest() {
        doNothing().when(historialRepository).deleteById(1L);

        historialService.eliminar(1L);

        verify(historialRepository, times(1)).deleteById(1L);
    }
}