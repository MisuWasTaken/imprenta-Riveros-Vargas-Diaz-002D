package com.imprenta.imprenta.model;
import jakarta.persistence.*;

@Entity
@Table(name = "impresion")
public class ImpresionModel 
{
 @Id
    public Impresion(Integer idImpresion, String documento,
                      Integer cantidadCopias, String fecha,
                      String estado, String asignatura,
                      String profesor, String curso) {
        this.idImpresion = idImpresion;
        this.documento = documento;
        this.cantidadCopias = cantidadCopias;
        this.fecha = fecha;
        this.estado = estado;
        this.asignatura = asignatura;
        this.profesor = profesor;
        this.curso = curso;
    }

    public Integer getIdImpresion() 
    {
        return idImpresion;
    }

    public void setIdImpresion(Integer idImpresion) 
    {
        this.idImpresion = idImpresion;
    }

    public String getDocumento() 
    {
        return documento;
    }

    public void setDocumento(String documento) 
    {
        this.documento = documento;
    }

    public Integer getCantidadCopias() 
    {
        return cantidadCopias;
    }

    public void setCantidadCopias(Integer cantidadCopias) 
    {
        this.cantidadCopias = cantidadCopias;
    }

    public String getFecha() 
    {
        return fecha;
    }

    public void setFecha(String fecha) 
    {
        this.fecha = fecha;
    }

    public String getEstado() 
    {
        return estado;
    }

    public void setEstado(String estado) 
    {
        this.estado = estado;
    }

    public String getAsignatura() 
    {
        return asignatura;
    }

    public void setAsignatura(String asignatura) 
    {
        this.asignatura = asignatura;
    }

    public String getProfesor() 
    {
        return profesor;
    }

    public void setProfesor(String profesor) 
    
        this.profesor = profesor;
    }

    public String getCurso() 
    {
        return curso;
    }

    public void setCurso(String curso) 
    {
        this.curso = curso;
    }

