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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Usuario
 */
public class GestoraConsulta 
{
     private static GestoraConsulta gestora = null;
    
     private GestoraConsulta() {

    }

    public static GestoraConsulta getIntancia() {

        if (gestora == null) {
            return gestora = new GestoraConsulta();
        }

        return gestora;

    }
    
    
    
    public boolean AgregarConsulta(Consulta consulta){
   
    BaseDatos bd = new BaseDatos();    
    Connection conn = null;
        try {
            conn = bd.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            String query = "insert into Agenda (Fecha,CedulaPaciente,Descripcion,CiFuncionario)"
                    + " values (?,?,?,?)";            
            PreparedStatement ps = conn.prepareStatement(query);
          
            ps.setDate(1, (Date) consulta.getFechaConsulta().getTime());         
            ps.setString(2,consulta.getPaciente().getCedula());
            ps.setString(3, consulta.getDescripcion());      
            ps.setString(4, consulta.getFuncionario().NombreUsuario);            
            
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("Insert correcto");
                conn.commit();
            } else {
                conn.rollback();
            }

        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException sq) {
            }
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sq) {
            }
        }
        return true;
    }     
    
    
    public  ArrayList<Consulta> ObtenerTodasLasConsultas()
    {    
        ArrayList<Consulta> lst = new ArrayList<>();
        BaseDatos bd = new BaseDatos();   
        Connection conn = null;     
        try {
            conn = bd.getConnection();
            String query = "select * from Consultas";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {           
                Calendar fecha = Calendar.getInstance();
                fecha.setTime(rs.getDate("Fecha"));
                Paciente p = GestoraPacientes.getIntancia().ObtenerPaciente(rs.getString("CedulaPaciente"));
                Funcionario f = GestoraFuncionarios.getIntancia().ObtenerFuncionario(rs.getString("NomUsuario"));
                Consulta C = new Consulta((GregorianCalendar)fecha,p,rs.getString("Descripcion"),f);
                lst.add(C);                
            }
            return lst;
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
        return lst;
    }
    
    
     public  ArrayList<Consulta> HistoriaClinica(Paciente p)
    {    
        ArrayList<Consulta> lst = new ArrayList<>();
        BaseDatos bd = new BaseDatos();   
        Connection conn = null;     
        try {
            conn = bd.getConnection();
            String query = "select * from Consultas where CiPaciente = " + p.getCedula();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) { 
                Calendar fecha = Calendar.getInstance();
                fecha.setTime(rs.getDate("Fecha"));
                Funcionario f = GestoraFuncionarios.getIntancia().ObtenerFuncionario(rs.getString("NomUsuario"));
                Consulta C = new Consulta((GregorianCalendar)fecha,p,rs.getString("Descripcion"),f);
                lst.add(C); 
            }
            return lst;
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
        return lst;
    }
    
    
    /*
    public  ArrayList<Agenda> ObtenerConsultasAgendadasDadoUnDia(Calendar Dia){
    
        ArrayList<Agenda> lst = new ArrayList<>();
        BaseDatos bd = new BaseDatos();   
        Connection conn = null;     
        try {
            conn = bd.getConnection();
            String query = "select * from personas";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {        
                
                Calendar fecha = Calendar.getInstance();              
                fecha.setTime(rs.getDate("Fecha"));
              
                if(fecha.equals(Dia))                
                {
                Paciente p = GestoraPacientes.getIntancia().ObtenerPaciente(rs.getString("CedulaPaciente"));
                Agenda a = new Agenda((GregorianCalendar)fecha,p,rs.getString("Descripcion"));               
                lst.add(a);                
                }
            }
            return lst;
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
        return lst;
    
    
    
    
    
    
   
    
    
    } */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
