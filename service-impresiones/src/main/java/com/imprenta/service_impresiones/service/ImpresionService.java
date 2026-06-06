package com.imprenta.service_impresiones.service;

import com.imprenta.service_impresiones.dto.*;
import com.imprenta.service_impresiones.model.Impresion;
import com.imprenta.service_impresiones.repository.ImpresionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ImpresionService {

    @Autowired
    private ImpresionRepository impresionRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    private RestTemplate restTemplate = new RestTemplate();

    public List<Impresion> listarTodas() {
        List<Impresion> lista = impresionRepository.findAll();
        lista.forEach(this::completarInformacion);
        return lista;
    }

    public Impresion guardar(Impresion impresion) {

    impresion.setFechaSolicitud(LocalDateTime.now());
    impresion.setEstado("PENDIENTE");

    Impresion guardada = impresionRepository.save(impresion);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String fechaFormateada = guardada.getFechaSolicitud().format(formatter);

    this.Historial(guardada.getId(), fechaFormateada);

    completarInformacion(guardada);

    return guardada;
}

    public Impresion marcarComoListo(Long id) {
        Impresion impresion = buscarPorId(id);
        impresion.setEstado("LISTO");

        Impresion guardada = impresionRepository.save(impresion);
        completarInformacion(guardada);
        return guardada;
    }

    public Impresion buscarPorId(Long id) {
        Impresion imp = impresionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrada"));
        completarInformacion(imp);
        return imp;
    }

    public void eliminar(Long id) {
        impresionRepository.deleteById(id);
    }

    private void completarInformacion(Impresion imp) {
        try {
            imp.setProfesor(webClientBuilder.build().get()
                    .uri("http://localhost:8081/profesores/" + imp.getProfesorId())
                    .retrieve().bodyToMono(ProfesorDTO.class).block());

            imp.setAsignatura(webClientBuilder.build().get()
                    .uri("http://localhost:8082/asignaturas/" + imp.getAsignaturaId())
                    .retrieve().bodyToMono(AsignaturaDTO.class).block());

            imp.setCurso(webClientBuilder.build().get()
                    .uri("http://localhost:8083/cursos/" + imp.getCursoId())
                    .retrieve().bodyToMono(CursoDTO.class).block());
        } catch (Exception e) {
            System.err.println("Error al conectar con microservicios externos: " + e.getMessage());
        }
    }

    private void Historial(Long impresionId, String fecha) 
    {
        String url = "http://localhost:8084/historial";
        Map<String, Object> historial = new HashMap<>();
        historial.put("impresionId", impresionId);
        historial.put("accion", "CREADA");
        historial.put("fecha", fecha);
        try 
        {
            restTemplate.postForEntity(url, historial, String.class);
        } catch (Exception e) {
            System.err.println("Error de comunicación con historial: " + e.getMessage());
        }
    }
}