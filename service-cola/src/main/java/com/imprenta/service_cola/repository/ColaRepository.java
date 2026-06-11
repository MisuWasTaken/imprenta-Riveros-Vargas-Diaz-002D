package com.imprenta.service_cola.repository;
import com.imprenta.service_cola.model.ColaImpresion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaRepository extends JpaRepository<ColaImpresion, Long> {

    List<ColaImpresion> findByEstadoCola(String estadoCola);
    List<ColaImpresion> findByPrioridad(String prioridad);
    List<ColaImpresion> findByImpresionId(Long impresionId);
}