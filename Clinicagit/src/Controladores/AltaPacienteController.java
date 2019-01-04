/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.GestoraPacientes;
import Modelo.Paciente;
import Vistas.FrmPaciente;
import interfaces.IFrmAltaPaciente;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;

/**
 *
 * @author Usuario
 */
public class AltaPacienteController {
    IFrmAltaPaciente Interface;
    
    public AltaPacienteController(IFrmAltaPaciente I) {
        Interface = I;
    }
    public boolean AgregarPaciente() throws ParseException{
    
        Paciente p = new Paciente();
        p.setApellido(Interface.getApellidos());
        p.setCedula(Interface.getcedula());        
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy");
        dateFormat.setLenient(false);
        Date d = (Date) dateFormat.parse(Interface.getFechaNac());       
        GregorianCalendar g = new GregorianCalendar(d.getYear(), d.getMonth(), d.getDate());
        p.setFechaderegistro(GregorianCalendar.from(ZonedDateTime.now()));        
        p.setFechanacimiento(g);
        p.setMail(Interface.getMail());
        p.setTelefono(Interface.getTelefono());
        p.setNombre(Interface.getNombres());
        
        return GestoraPacientes.getIntancia().AgregarPaciente(p);
        
        
        
        
        
        
        
        
        
    
    }
    
    
    
    
}
