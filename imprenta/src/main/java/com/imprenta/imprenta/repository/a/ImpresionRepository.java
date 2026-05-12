package com.imprenta.imprenta.repository.a;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.imprenta.imprenta.model.Impresion;

public interface ImpresionRepository 
{
@Repository
public interface ImpresionRepository extends JpaRepository<Impresion, Integer> 
}

public Object findById(Integer id);
