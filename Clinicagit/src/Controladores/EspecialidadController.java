/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Especialidad;
import Modelo.GestoraEspecialidad;
import interfaces.IFrmEspecialidad;

/**
 *
 * @author Usuario
 */
public class EspecialidadController {

    IFrmEspecialidad Interface;
    
    public EspecialidadController(IFrmEspecialidad frm) {

Interface=frm;


    }
    
    public boolean AltaEspecialidad(){
    
    Especialidad e = new Especialidad();
    e.setNombre(Interface.getDescripcionEspecialidad());
    e.setDescripcion(Interface.getDescripcionEspecialidad());
   
        return GestoraEspecialidad.getIntancia().AgregarEspecialidad(e);
    
    
    
    }
    
}
