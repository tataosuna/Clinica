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
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Usuario
 */
public class GestoraPacientes {
    
    
     private static GestoraPacientes gestora = null;
    private GestoraPacientes() {

    }

    public static GestoraPacientes getIntancia() {

        if (gestora == null) {
            return gestora = new GestoraPacientes();
        }

        return gestora;

    }

    public Paciente ObtenerPaciente(String Cedula) {
        
        BaseDatos bd = new BaseDatos();   
        Connection conn = null;     
        try {
            conn = bd.getConnection();
            String query = "select * from Pacientes where CiPaciente = " + Cedula ;
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Paciente P = new Paciente();
            P.setApellido(rs.getString("Apellido"));
            P.setTelefono(rs.getString("Telefono"));
            P.setCedula(rs.getString("CiPaciente"));
            P.setNombre(rs.getString("Nombre"));
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(rs.getDate("FechaRegistro"));
            P.setFechaderegistro((GregorianCalendar)calendar);
       return P;
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


     
        
        
        
        
   
    
    
    
    
