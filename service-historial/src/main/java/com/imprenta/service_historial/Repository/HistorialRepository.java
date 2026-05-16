package com.imprenta.service_historial.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.imprenta.service_historial.Model.Historial;
import java.util.List;

@Repository
public interface HistorialRepository extends JpaRepository<Historial, Long> 
{
    List<Historial> findByImpresionId(Long impresionId);
}