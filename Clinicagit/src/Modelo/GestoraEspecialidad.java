/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Taller
 */
public class GestoraEspecialidad {

    
    private static GestoraEspecialidad gestora = null;

    private GestoraEspecialidad() {

    }

    public static GestoraEspecialidad getIntancia() {

        if (gestora == null) {
            return gestora = new GestoraEspecialidad();
        }

        return gestora;

    }

    public boolean AgregarEspecialidad(Especialidad e) {
        BaseDatos bd = new BaseDatos();
        Connection conn = null;
        try {
            conn = bd.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            String query = "insert into Especialidades (Nombre) values (?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1,e.getNombre());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                conn.commit();
            } else {
                conn.rollback();
            }

        }
        catch (Exception a) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException sq) {
            }
            System.out.println("Error: " + a.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException sq) {
                
                return false;   
            }
        }
        return true;
    }
}