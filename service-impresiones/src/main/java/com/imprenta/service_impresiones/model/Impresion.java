package com.imprenta.service_impresiones.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Impresion 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long profesorId;

    private Long asignaturaId;
    private Long cursoId;
    private Integer cantidadCopias; 
    private String estado;

    private LocalDateTime fechaSolicitud;
    private String notasAdicionales;
}
