/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class GestoraFuncionarios {

  
     private static GestoraFuncionarios gestora = null;
    
     private GestoraFuncionarios() {

    }

    public static GestoraFuncionarios getIntancia() {

        if (gestora == null) {
            return gestora = new GestoraFuncionarios();
        }

        return gestora;

    }

    public Funcionario ObtenerFuncionario(String NomUsuario) {

        BaseDatos bd = new BaseDatos();   
        Connection conn = null;     
        try {
            conn = bd.getConnection();
            String query = "select * from Funcionario where NomUsuario = " + NomUsuario ;
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Funcionario f = new Funcionario();
            f.setApellido(rs.getString("Apellido"));
            f.setCelular(rs.getString("Celular"));
            f.setContraseña(rs.getString("Contraseña"));
            f.setNombre(rs.getString("Nombre"));
            f.setNombreUsuario(rs.getString("NomUsuario"));
            f.setIdFuncionario(rs.getInt("IdFuncionario"));     
       return f;
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException sq) {
            }
            
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sq) {
            }
        }
     return null;
    }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
