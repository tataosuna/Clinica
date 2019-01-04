/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.Date;
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
            Calendar FechaReg = new GregorianCalendar();
            FechaReg.setTime(rs.getDate("FechaRegistro"));
            P.setFechaderegistro((GregorianCalendar)FechaReg);
            
            Calendar FechaNac = new GregorianCalendar();
            FechaNac.setTime(rs.getDate("FechaRegistro"));
            P.setFechanacimiento((GregorianCalendar)FechaNac);
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

    public boolean AgregarPaciente(Paciente p) {        
        BaseDatos bd = new BaseDatos();
        Connection conn = null;
        try {
            conn = bd.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            String query = "insert into Pacientes (CiPaciente,Nombres,Apellidos,FechaNacimiento,Celular,Telefono,Mail,FechaRegistro)"
                    + " values (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,p.getCedula());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getApellido());
            ps.setDate(4, (Date)p.getFechanacimiento().getTime());
            ps.setString(5, p.getCelular());
            ps.setString(6, p.getTelefono());
            ps.setString(7, p.getMail());
            ps.setDate(8, (Date) p.getFechaderegistro().getTime());

            int rs = ps.executeUpdate();
            if (rs > 0) {
                conn.commit();
                return true;
            } else {
                conn.rollback();
                 return false;
            }

        }
        catch (Exception a) {
            try {
                if (conn != null) {
                    conn.rollback();
                       return false;
                }
            } catch (SQLException sq) {
                   return false;
            }
            System.out.println("Error: " + a.getMessage());
               return false;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sq) {
                
                return false;   
            }
        }
    }
        
        
        
        
        
        
        
        
        
    }


     
        
        
        
        
   
    
    
    
    
