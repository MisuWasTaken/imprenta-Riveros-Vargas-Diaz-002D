package com.imprenta.service_inventario.service;
import com.imprenta.service_inventario.model.Inventario;
import com.imprenta.service_inventario.repository.InventarioRepository;
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
class InventarioServiceTest 
{

    @Mock
    private InventarioRepository inventarioRepository;

    @InjectMocks
    private InventarioService inventarioService;

    @Test
    void listarTodosTest() 
    {
        Inventario item1 = new Inventario(1L, "Resma carta", 20, "Papel blanco tamaño carta");
        Inventario item2 = new Inventario(2L, "Tóner negro", 5, "Tóner para impresora principal");

        when(inventarioRepository.findAll()).thenReturn(Arrays.asList(item1, item2));

        List<Inventario> resultado = inventarioService.listarTodos();

        assertEquals(2, resultado.size());
        assertEquals("Resma carta", resultado.get(0).getNombre());

        verify(inventarioRepository, times(1)).findAll();
    }

    @Test
    void buscarPorNombreTest() 
    {
        Inventario item = new Inventario(1L, "Resma carta", 20, "Papel blanco tamaño carta");

        when(inventarioRepository.findByNombreContainingIgnoreCase("resma"))
                .thenReturn(Arrays.asList(item));

        List<Inventario> resultado = inventarioService.buscarPorNombre("resma");

        assertEquals(1, resultado.size());
        assertEquals("Resma carta", resultado.get(0).getNombre());

        verify(inventarioRepository, times(1)).findByNombreContainingIgnoreCase("resma");
    }

    @Test
    void guardarTest() 
    {
        Inventario item = new Inventario(null, "Espirales", 100, "Espirales para anillado");
        Inventario itemGuardado = new Inventario(1L, "Espirales", 100, "Espirales para anillado");

        when(inventarioRepository.save(item)).thenReturn(itemGuardado);

        Inventario resultado = inventarioService.guardar(item);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Espirales", resultado.getNombre());

        verify(inventarioRepository, times(1)).save(item);
    }

    @Test
    void actualizarTest() 
    {
        Inventario existente = new Inventario(1L, "Resma carta", 20, "Papel blanco");
        Inventario datosNuevos = new Inventario(null, "Resma carta premium", 30, "Papel de mejor calidad");
        Inventario actualizado = new Inventario(1L, "Resma carta premium", 30, "Papel de mejor calidad");

        when(inventarioRepository.findById(1L)).thenReturn(Optional.of(existente));
        when(inventarioRepository.save(existente)).thenReturn(actualizado);

        Inventario resultado = inventarioService.actualizar(1L, datosNuevos);

        assertEquals("Resma carta premium", resultado.getNombre());
        assertEquals(30, resultado.getCantidad());
        assertEquals("Papel de mejor calidad", resultado.getDescripcion());

        verify(inventarioRepository, times(1)).findById(1L);
        verify(inventarioRepository, times(1)).save(existente);
    }

    @Test
    void agregarCantidadTest() 
    {
        Inventario item = new Inventario(1L, "Resma carta", 20, "Papel blanco");
        Inventario actualizado = new Inventario(1L, "Resma carta", 30, "Papel blanco");

        when(inventarioRepository.findById(1L)).thenReturn(Optional.of(item));
        when(inventarioRepository.save(item)).thenReturn(actualizado);

        Inventario resultado = inventarioService.agregarCantidad(1L, 10);

        assertEquals(30, resultado.getCantidad());

        verify(inventarioRepository, times(1)).findById(1L);
        verify(inventarioRepository, times(1)).save(item);
    }

    @Test
    void quitarCantidadTest() 
    {
        Inventario item = new Inventario(1L, "Resma carta", 20, "Papel blanco");
        Inventario actualizado = new Inventario(1L, "Resma carta", 15, "Papel blanco");

        when(inventarioRepository.findById(1L)).thenReturn(Optional.of(item));
        when(inventarioRepository.save(item)).thenReturn(actualizado);

        Inventario resultado = inventarioService.quitarCantidad(1L, 5);

        assertEquals(15, resultado.getCantidad());

        verify(inventarioRepository, times(1)).findById(1L);
        verify(inventarioRepository, times(1)).save(item);
    }

    @Test
    void eliminarTest() 
    {
        doNothing().when(inventarioRepository).deleteById(1L);

        inventarioService.eliminar(1L);

        verify(inventarioRepository, times(1)).deleteById(1L);
    }
}