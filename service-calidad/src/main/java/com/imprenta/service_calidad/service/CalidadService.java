package com.imprenta.service_calidad.service;

import com.imprenta.service_calidad.model.CalidadModel;
import com.imprenta.service_calidad.repository.CalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CalidadService {

	@Autowired
	private CalidadRepository calidadRepository;

	public List<CalidadModel> listarTodas() {
		return calidadRepository.findAll();
	}

	public CalidadModel guardar(CalidadModel calidad) {
		calidad.setEstado("PENDIENTE");
		return calidadRepository.save(calidad);
	}

	public CalidadModel aprobar(Long id) {
		CalidadModel calidad = buscarPorId(id);
		calidad.setEstado("APROBADA");
		return calidadRepository.save(calidad);
	}

	public CalidadModel rechazar(Long id) {
		CalidadModel calidad = buscarPorId(id);
		calidad.setEstado("RECHAZADA");
		return calidadRepository.save(calidad);
	}

	public CalidadModel buscarPorId(Long id) {
		return calidadRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("No encontrada"));
	}

	public void eliminar(Long id) {
		calidadRepository.deleteById(id);
	}

}
