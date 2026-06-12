package com.imprenta.service_calidad.service;

import com.imprenta.service_calidad.model.CalidadModel;
import com.imprenta.service_calidad.repository.CalidadRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CalidadService {

    private final CalidadRepository calidadRepository;

    public CalidadService(CalidadRepository calidadRepository) {
        this.calidadRepository = calidadRepository;
    }

    public List<CalidadModel> listarTodas() {
        return calidadRepository.findAll();
    }

    public CalidadModel guardar(CalidadModel calidad) {
        return calidadRepository.save(calidad);
    }

    @Transactional
    public CalidadModel actualizar(Long id, CalidadModel calidad) {
        CalidadModel existente = buscarPorId(id);

        if (calidad.getImpresionId() != null) {
            existente.setImpresionId(calidad.getImpresionId());
        }
        if (calidad.getCantidadDefectuosas() != null) {
            existente.setCantidadDefectuosas(calidad.getCantidadDefectuosas());
        }
        if (calidad.getNotasExtras() != null) {
            existente.setNotasExtras(calidad.getNotasExtras());
        }

        return calidadRepository.save(existente);
    }

    public CalidadModel buscarPorId(Long id) {
        return calidadRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Revisión de calidad no encontrada"));
    }

    public void eliminar(Long id) {
        calidadRepository.deleteById(id);
    }

}
