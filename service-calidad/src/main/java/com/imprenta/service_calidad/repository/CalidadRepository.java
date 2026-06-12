package com.imprenta.service_calidad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.imprenta.service_calidad.model.CalidadModel;

@Repository
public interface CalidadRepository extends JpaRepository<CalidadModel, Long> {

}
