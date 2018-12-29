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
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Usuario
 */
public class GestoraAgenda {

    private static GestoraAgenda gestora = null;
    private GestoraAgenda() {

    }

    public static GestoraAgenda getIntancia() {

        if (gestora == null) {
            return gestora = new GestoraAgenda();
        }

        return gestora;

    }
    
    public boolean AgregarAgenda(Agenda a){
   
    BaseDatos bd = new BaseDatos();    
    Connection conn = null;
        try {
            conn = bd.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            String query = "insert into Agenda (Fecha,CedulaPaciente,Descripcion)"
                    + " values (?,?,?)";            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setDate(1, (Date) a.getFechaConsulta().getTime());         
            ps.setString(2,a.getPaciente().getCedula());
            ps.setString(3, a.getDescripcion());               
            int rs = ps.executeUpdate();
            if (rs > 0) {
                System.out.println("Insert correcto");
                conn.commit();
                //JOptionPane.showMessageDialog(null, "Cliente agregado","Alta cliente",JOptionPane.INFORMATION_MESSAGE);
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
            //JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(),"Cliente ingresado",JOptionPane.ERROR_MESSAGE);
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
    
    
    public  ArrayList<Agenda> ObtenerAgendaCompleta()
    {    
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
                Paciente p = GestoraPacientes.getIntancia().ObtenerPaciente(rs.getString("CedulaPaciente"));
                Agenda a = new Agenda((GregorianCalendar)fecha,p,rs.getString("Descripcion"));   
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
    
    
     public  ArrayList<Agenda> ObtenerAgendaDelDia()
    {    
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
              
                if(fecha.equals(Calendar.getInstance()))                
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
    }
    
    
    
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
    
    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    
        
        
        
        
    
    
    
    
     
    
    
    
    
    
    
    
    
    
    
    
