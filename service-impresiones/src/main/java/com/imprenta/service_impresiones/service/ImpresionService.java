package com.imprenta.service_impresiones.service;
import com.imprenta.service_impresiones.dto.*;
import com.imprenta.service_impresiones.model.Impresion;
import com.imprenta.service_impresiones.repository.ImpresionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ImpresionService {

    @Autowired
    private ImpresionRepository impresionRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<Impresion> listarTodas() {
        List<Impresion> lista = impresionRepository.findAll();
        lista.forEach(this::completarInformacion);
        return lista;
    }

    public Impresion guardar(Impresion impresion) {
        webClientBuilder.build().get()
                .uri("http://localhost:8081/profesores/" + impresion.getProfesorId())
                .retrieve().bodyToMono(ProfesorDTO.class).block();

        webClientBuilder.build().get()
                .uri("http://localhost:8083/cursos/" + impresion.getCursoId())
                .retrieve().bodyToMono(CursoDTO.class).block();

        impresion.setFechaSolicitud(LocalDateTime.now());
        impresion.setEstado("PENDIENTE");
        return impresionRepository.save(impresion);
    }

    public Impresion marcarComoListo(Long id) {
        Impresion impresion = buscarPorId(id);
        impresion.setEstado("LISTO");
        return impresionRepository.save(impresion);
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
}