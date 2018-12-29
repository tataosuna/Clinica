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

    public Paciente ObtenerPaciente(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
    
}
