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

    public Funcionario ObtenerFuncionario(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
