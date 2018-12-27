/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.GregorianCalendar;

/**
 *
 * @author Usuario
 */
public class Agenda {
    
    int idAgenda;
    GregorianCalendar fechaConsulta ;
    Paciente paciente;
    String Descripcion;

    public Agenda(GregorianCalendar fechaConsulta, Paciente paciente, String Descripcion) {
        this.fechaConsulta = fechaConsulta;
        this.paciente = paciente;
        this.Descripcion = Descripcion;
    }
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idAgenda;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Agenda other = (Agenda) obj;
        if (this.idAgenda != other.idAgenda) {
            return false;
        }
        return true;
    }

    public int getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(int idAgenda) {
        this.idAgenda = idAgenda;
    }

    public GregorianCalendar getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(GregorianCalendar fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
    
    
    
    
}
