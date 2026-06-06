package com.imprenta.service_profesores;

import com.imprenta.service_profesores.model.Profesor;
import com.imprenta.service_profesores.repository.ProfesorRepository;
import com.imprenta.service_profesores.service.ProfesorService;

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
class ServiceProfesoresApplicationTests {

    @Mock
    private ProfesorRepository profesorRepository;

    @InjectMocks
    private ProfesorService profesorService;

    @Test
    void listarTodosTest() {
        Profesor profesor1 = new Profesor(1L, "Francisco", "Riveros", "f.riveros@duocuc.cl", "912345678");
        Profesor profesor2 = new Profesor(2L, "Carlos", "Muñoz", "c.munoz@duocuc.cl", "987654321");

        when(profesorRepository.findAll()).thenReturn(Arrays.asList(profesor1, profesor2));

        List<Profesor> resultado = profesorService.listarTodos();

        assertEquals(2, resultado.size());
        assertEquals("Francisco", resultado.get(0).getNombre());

        verify(profesorRepository, times(1)).findAll();
    }

    @Test
    void buscarPorIdTest() {
        Profesor profesor = new Profesor(1L, "Francisco", "Riveros", "f.riveros@duocuc.cl", "912345678");

        when(profesorRepository.findById(1L)).thenReturn(Optional.of(profesor));

        Optional<Profesor> resultado = profesorService.buscarPorId(1L);

        assertTrue(resultado.isPresent());
        assertEquals("Francisco", resultado.get().getNombre());

        verify(profesorRepository, times(1)).findById(1L);
    }

    @Test
    void guardarTest() {
        Profesor profesor = new Profesor(null, "Carlos", "Muñoz", "c.munoz@duocuc.cl", "912345678");
        Profesor profesorGuardado = new Profesor(1L, "Carlos", "Muñoz", "c.munoz@duocuc.cl", "912345678");

        when(profesorRepository.save(profesor)).thenReturn(profesorGuardado);

        Profesor resultado = profesorService.guardar(profesor);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Carlos", resultado.getNombre());

        verify(profesorRepository, times(1)).save(profesor);
    }

    @Test
    void actualizarTest() {
        Profesor existente = new Profesor(1L, "Carlos", "Muñoz", "c.munoz@duocuc.cl", "912345678");
        Profesor datosNuevos = new Profesor(null, "Carlos", "Pérez", "c.perez@duocuc.cl", "911111111");
        Profesor actualizado = new Profesor(1L, "Carlos", "Pérez", "c.perez@duocuc.cl", "911111111");

        when(profesorRepository.findById(1L)).thenReturn(Optional.of(existente));
        when(profesorRepository.save(existente)).thenReturn(actualizado);

        Profesor resultado = profesorService.actualizar(1L, datosNuevos);

        assertEquals("Pérez", resultado.getApellido());
        assertEquals("c.perez@duocuc.cl", resultado.getCorreo());
        assertEquals("911111111", resultado.getTelefono());

        verify(profesorRepository, times(1)).findById(1L);
        verify(profesorRepository, times(1)).save(existente);
    }

    @Test
    void eliminarTest() {
        doNothing().when(profesorRepository).deleteById(1L);

        profesorService.eliminar(1L);

        verify(profesorRepository, times(1)).deleteById(1L);
    }
}