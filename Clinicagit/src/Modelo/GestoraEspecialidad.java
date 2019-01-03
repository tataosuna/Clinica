/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

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
    
    
    
    
    
    
    
    
    
    
    
}
