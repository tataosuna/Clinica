/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.GregorianCalendar;
import java.util.Objects;

/**
 *
 * @author Usuario
 */
public class Paciente {
    
    String nombre;
    String apellido;
    GregorianCalendar fechanacimiento;
    String cedula;
    String telefono;
    GregorianCalendar fechaderegistro;
    String mail;

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Paciente other = (Paciente) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public GregorianCalendar getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(GregorianCalendar fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public GregorianCalendar getFechaderegistro() {
        return fechaderegistro;
    }

    public void setFechaderegistro(GregorianCalendar fechaderegistro) {
        this.fechaderegistro = fechaderegistro;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    
    
    
    
}
