package com.imprenta.service_historial.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Historial 
{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long impresionId; //Id de la impresion reflejada en el historial 
    private String accion; //Creada, actualizada, eliminada

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss") //Import que hice para que sea mas facil de leer la f
    private LocalDateTime fecha;
}