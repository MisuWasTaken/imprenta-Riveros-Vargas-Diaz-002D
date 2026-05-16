package com.imprenta.service_impresiones.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.imprenta.service_impresiones.model.Impresion;

@Repository
public interface ImpresionRepository extends JpaRepository<Impresion, Long> 
{
}

