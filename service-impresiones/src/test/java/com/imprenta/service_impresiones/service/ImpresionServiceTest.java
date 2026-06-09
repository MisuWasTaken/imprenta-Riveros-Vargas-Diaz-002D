package com.imprenta.service_impresiones.service;
import com.imprenta.service_impresiones.model.Impresion;
import com.imprenta.service_impresiones.repository.ImpresionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ImpresionServiceTest 
{

    @Mock
    private ImpresionRepository impresionRepository;

    @Mock
    private WebClient.Builder webClientBuilder;

    @InjectMocks
    private ImpresionService impresionService;

    @Test
    void listarTodasTest() 
    {
        Impresion impresion1 = new Impresion();
        impresion1.setId(1L);
        impresion1.setProfesorId(1L);
        impresion1.setAsignaturaId(1L);
        impresion1.setCursoId(1L);
        impresion1.setCantidadCopias(50);
        impresion1.setEstado("PENDIENTE");
        impresion1.setFechaSolicitud(LocalDateTime.now());
        impresion1.setNotasAdicionales("Prueba 1");

        Impresion impresion2 = new Impresion();
        impresion2.setId(2L);
        impresion2.setProfesorId(1L);
        impresion2.setAsignaturaId(1L);
        impresion2.setCursoId(1L);
        impresion2.setCantidadCopias(30);
        impresion2.setEstado("LISTO");
        impresion2.setFechaSolicitud(LocalDateTime.now());
        impresion2.setNotasAdicionales("Prueba 2");

        when(impresionRepository.findAll()).thenReturn(Arrays.asList(impresion1, impresion2));

        List<Impresion> resultado = impresionService.listarTodas();

        assertEquals(2, resultado.size());
        assertEquals("PENDIENTE", resultado.get(0).getEstado());

        verify(impresionRepository, times(1)).findAll();
    }

    @Test
    void buscarPorIdTest() 
    {
        Impresion impresion = new Impresion();
        impresion.setId(1L);
        impresion.setProfesorId(1L);
        impresion.setAsignaturaId(1L);
        impresion.setCursoId(1L);
        impresion.setCantidadCopias(50);
        impresion.setEstado("PENDIENTE");
        impresion.setFechaSolicitud(LocalDateTime.now());

        when(impresionRepository.findById(1L)).thenReturn(Optional.of(impresion));

        Impresion resultado = impresionService.buscarPorId(1L);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals(50, resultado.getCantidadCopias());

        verify(impresionRepository, times(1)).findById(1L);
    }

    @Test
    void guardarTest() 
    {
        Impresion impresion = new Impresion();
        impresion.setProfesorId(1L);
        impresion.setAsignaturaId(1L);
        impresion.setCursoId(1L);
        impresion.setCantidadCopias(55);
        impresion.setNotasAdicionales("Prueba guardar");

        Impresion guardada = new Impresion();
        guardada.setId(1L);
        guardada.setProfesorId(1L);
        guardada.setAsignaturaId(1L);
        guardada.setCursoId(1L);
        guardada.setCantidadCopias(55);
        guardada.setEstado("PENDIENTE");
        guardada.setFechaSolicitud(LocalDateTime.now());
        guardada.setNotasAdicionales("Prueba guardar");

        when(impresionRepository.save(any(Impresion.class))).thenReturn(guardada);

        Impresion resultado = impresionService.guardar(impresion);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("PENDIENTE", resultado.getEstado());
        assertEquals(55, resultado.getCantidadCopias());

        verify(impresionRepository, times(1)).save(any(Impresion.class));
    }

    @Test
    void marcarComoListoTest() 
    {
        Impresion impresion = new Impresion();
        impresion.setId(1L);
        impresion.setProfesorId(1L);
        impresion.setAsignaturaId(1L);
        impresion.setCursoId(1L);
        impresion.setCantidadCopias(50);
        impresion.setEstado("PENDIENTE");
        impresion.setFechaSolicitud(LocalDateTime.now());

        Impresion guardada = new Impresion();
        guardada.setId(1L);
        guardada.setProfesorId(1L);
        guardada.setAsignaturaId(1L);
        guardada.setCursoId(1L);
        guardada.setCantidadCopias(50);
        guardada.setEstado("LISTO");
        guardada.setFechaSolicitud(LocalDateTime.now());

        when(impresionRepository.findById(1L)).thenReturn(Optional.of(impresion));
        when(impresionRepository.save(any(Impresion.class))).thenReturn(guardada);

        Impresion resultado = impresionService.marcarComoListo(1L);

        assertNotNull(resultado);
        assertEquals("LISTO", resultado.getEstado());

        verify(impresionRepository, times(1)).findById(1L);
        verify(impresionRepository, times(1)).save(any(Impresion.class));
    }

    @Test
    void eliminarTest() 
    {
        doNothing().when(impresionRepository).deleteById(1L);

        impresionService.eliminar(1L);

        verify(impresionRepository, times(1)).deleteById(1L);
    }
}