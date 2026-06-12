package com.imprenta.service_calidad.controller;

import com.imprenta.service_calidad.model.CalidadModel;
import com.imprenta.service_calidad.service.CalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;


@RestController
@RequestMapping("/calidad")
@Tag(name = "Calidad", description = "Operaciones relacionadas con la calidad de impresiones")
public class CalidadController {

	@Autowired
	private CalidadService calidadService;

	@Operation(summary = "Mostrar todas las revisiones de calidad", description = "Muestra todas las anotaciones de calidad registradas")
	@GetMapping
	public List<CalidadModel> listar() {
		return calidadService.listarTodas();
	}

	@Operation(summary = "Crear una anotacion de calidad", description = "Crea una nueva entrada de calidad para una impresion")
	@PostMapping
	public CalidadModel crear(@RequestBody CalidadModel calidad) {
		return calidadService.guardar(calidad);
	}

	@Operation(summary = "Actualizar anotacion de calidad", description = "Actualiza los datos de una anotacion de calidad existente")
	@PutMapping("/{id}")
	public CalidadModel actualizar(@PathVariable Long id, @RequestBody CalidadModel calidad) {
		return calidadService.actualizar(id, calidad);
	}

	@Operation(summary = "Eliminar anotacion de calidad", description = "Elimina una anotacion por su id")
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		calidadService.eliminar(id);
	}

	@Operation(summary = "Mostrar una anotacion de calidad por su ID", description = "Muestra una anotacion por su id")
	@GetMapping("/{id}")
	public CalidadModel obtenerPorId(@PathVariable Long id) {
		return calidadService.buscarPorId(id);
	}
}
