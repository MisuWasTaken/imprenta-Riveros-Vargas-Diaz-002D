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

	@Operation(summary = "Mostrar todas las revisiones de calidad", description = "Obtiene todas las entradas de calidad")
	@GetMapping
	public List<CalidadModel> listar() {
		return calidadService.listarTodas();
	}

	@Operation(summary = "Crear una revisión de calidad", description = "Crea una nueva entrada de calidad para una impresión")
	@PostMapping
	public CalidadModel crear(@RequestBody CalidadModel calidad) {
		return calidadService.guardar(calidad);
	}

	@Operation(summary = "Aprobar revisión", description = "Marca la revisión de calidad como aprobada")
	@PutMapping("/{id}/aprobar")
	public CalidadModel aprobar(@PathVariable Long id) {
		return calidadService.aprobar(id);
	}

	@Operation(summary = "Rechazar revisión", description = "Marca la revisión de calidad como rechazada")
	@PutMapping("/{id}/rechazar")
	public CalidadModel rechazar(@PathVariable Long id) {
		return calidadService.rechazar(id);
	}

	@Operation(summary = "Eliminar revisión", description = "Elimina una revisión de calidad")
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable Long id) {
		calidadService.eliminar(id);
	}

	@Operation(summary = "Obtener revisión por ID", description = "Obtiene una revisión de calidad por su ID")
	@GetMapping("/{id}")
	public CalidadModel obtenerPorId(@PathVariable Long id) {
		return calidadService.buscarPorId(id);
	}

}
