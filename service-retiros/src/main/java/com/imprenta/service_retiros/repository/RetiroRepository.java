package com.imprenta.service_retiros.repository;

import com.imprenta.service_retiros.model.Retiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetiroRepository extends JpaRepository<Retiro, Long> 
{
}