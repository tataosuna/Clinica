/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Funcionario {
    
    int IdFuncionario;
    String Nombre;
    String Apellido;
    String Celular;
    String NombreUsuario;
    String Contraseña;

    public Funcionario() {
    }

    public Funcionario(int IdFuncionario, String Nombre, String Apellido, String Celular, String NombreUsuario, String Contraseña) {
        this.IdFuncionario = IdFuncionario;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Celular = Celular;
        this.NombreUsuario = NombreUsuario;
        this.Contraseña = Contraseña;
    }

    public int getIdFuncionario() {
        return IdFuncionario;
    }

    public void setIdFuncionario(int IdFuncionario) {
        this.IdFuncionario = IdFuncionario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getNombreUsuario() {
        return NombreUsuario;
    }

    public void setNombreUsuario(String NombreUsuario) {
        this.NombreUsuario = NombreUsuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }
    
    
    
    
}
