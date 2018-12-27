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
public class Cosulta {    
    int idcosnulata;
    GregorianCalendar fechaConsulta ;
    Paciente paciente;
    String Descripcion;
    Funcionario funcionario;

    public Cosulta() {
        
    }

    public Cosulta(GregorianCalendar fechaConsulta, Paciente paciente, String Descripcion, Funcionario funcionario) {
        this.fechaConsulta = fechaConsulta;
        this.paciente = paciente;
        this.Descripcion = Descripcion;
        this.funcionario = funcionario;
    }

    public int getIdcosnulata() {
        return idcosnulata;
    }

    public void setIdcosnulata(int idcosnulata) {
        this.idcosnulata = idcosnulata;
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

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
}
