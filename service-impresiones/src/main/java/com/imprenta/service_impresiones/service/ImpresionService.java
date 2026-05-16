package com.imprenta.service_impresiones.service;
import com.imprenta.service_impresiones.dto.ProfesorDTO;
import com.imprenta.service_impresiones.dto.CursoDTO;
import com.imprenta.service_impresiones.dto.AsignaturaDTO;
import com.imprenta.service_impresiones.dto.*;
import com.imprenta.service_impresiones.model.Impresion;
import com.imprenta.service_impresiones.repository.ImpresionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ImpresionService 
{

    @Autowired
    private ImpresionRepository impresionRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<Impresion> listarTodas() {
        return impresionRepository.findAll();
    }

    public Impresion guardar (Impresion impresion) 
    {
        ProfesorDTO profe = webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/profesores/" + impresion.getProfesorId())
                .retrieve()
                .bodyToMono(ProfesorDTO.class)
                .block();


                CursoDTO curso = webClientBuilder.build()
                .get()
                .uri("http://localhost:8083/cursos/" + impresion.getCursoId())
                .retrieve()
                .bodyToMono(CursoDTO.class)
                .block();

                impresion.setFechaSolicitud(LocalDateTime.now());
                impresion.setEstado("PENDIENTE");

                return impresionRepository.save(impresion);
    }
}
