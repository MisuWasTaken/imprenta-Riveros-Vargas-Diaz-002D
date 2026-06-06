package com.imprenta.service_impresiones.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.imprenta.service_impresiones.dto.AsignaturaDTO;
import com.imprenta.service_impresiones.dto.CursoDTO;
import com.imprenta.service_impresiones.dto.ProfesorDTO;
import com.fasterxml.jackson.annotation.JsonProperty;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Impresion 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long profesorId;
    
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long asignaturaId;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long cursoId;

    private Integer cantidadCopias; 
    private String estado;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss") //Para que la fecha sea mas legible 
    private LocalDateTime fechaSolicitud;
    private String notasAdicionales;


    //Agregue esto hecho con ia que es para que se muestren los datos reales enves de un 1, 2 o 3 en los datos
    @Transient
    private ProfesorDTO profesor;

    @Transient
    private CursoDTO curso;

    @Transient
    private AsignaturaDTO asignatura;
}