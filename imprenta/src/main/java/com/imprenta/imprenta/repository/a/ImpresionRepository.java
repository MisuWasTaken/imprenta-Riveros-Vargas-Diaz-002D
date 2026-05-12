package com.imprenta.imprenta.repository.a;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.imprenta.imprenta.model.ImpresionModel;
import org.springframework.stereotype.Repository;

public interface ImpresionRepository 
{
@Repository
public interface ImpresionRepository extends JpaRepository<ImpresionModel, Integer>
}

public Object findById(Integer id);
