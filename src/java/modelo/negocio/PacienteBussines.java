/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.negocio;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.PacienteDAO;
import modelo.dto.PacienteDTO;
import modelo.dto.UsuarioDTO;
import modelo.dao.UsuarioDAO; 

/**
 *
 * @author Meli
 */

public class PacienteBussines {
    PacienteDTO paciente; 
    PacienteDAO pDao;
    private List<PacienteDTO> lista; 
    
    public PacienteBussines(){
       paciente = new  PacienteDTO();
       pDao = new PacienteDAO(); 
    }
    
    public PacienteDTO crear(String nombrePaciente, String apellidoPaterno, String apellidoMaterno, Date fechNac , Double peso , 
            String alergias, double estatura , String telPaciente,UsuarioDTO usuario  , Boolean estatus){
        this.paciente.setNombrePaciente(nombrePaciente);
        this.paciente.setApellidoPaterno(apellidoPaterno);
        this.paciente.setApellidoMaterno(apellidoMaterno);
        this.paciente.setFechNac(fechNac);
        this.paciente.setPeso(peso);
        this.paciente.setAlergias(alergias);
        this.paciente.setEstatura(estatura);
        this.paciente.setTelPaciente(telPaciente);
        this.paciente.setIdUsuarioDTO(usuario);
        this.paciente.setEstatus(estatus);
        
        try {
            this.paciente = pDao.create(paciente);
            
        } catch (Exception e) {
            Logger.getLogger(PacienteBussines.class.getName()).log(Level.SEVERE, null, e);
            this.paciente = null; 
        }
        
        return this.paciente;
    }
    
    public static PacienteDTO buscar(String nombrePaciente, String apellidoPaterno , String apellidoMaterno, Date fechNac, String telPaciente, Boolean estatus){
        PacienteDTO pacientedto = new PacienteDTO(); 
        PacienteDAO pacientedao = new PacienteDAO(); 
        
        pacientedto.setNombrePaciente(nombrePaciente);
        pacientedto.setApellidoPaterno(apellidoPaterno);
        pacientedto.setApellidoMaterno(apellidoMaterno);
        pacientedto.setFechNac(fechNac);
        pacientedto.setTelPaciente(telPaciente);
        pacientedto.setEstatus(estatus);
        
        try {
            
            pacientedto = pacientedao.read(pacientedto);
        } catch (Exception e) {
            Logger.getLogger(PacienteBussines.class.getName()).log(Level.SEVERE, null, e);
            pacientedto = null; 
        }
        return pacientedto;
    }
    
    public static List<PacienteDTO> BuscarTodos (){
        List<PacienteDTO> lista = null; 
        PacienteDAO dao = new PacienteDAO(); 
        
        try {
            lista = dao.read();
        } catch (Exception e) {
            Logger.getLogger(PacienteBussines.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
        return lista;  
    }
    
    public PacienteDTO eliminar(String nombrePaciente, String apellidoPaterno , String apellidoMaterno){
        this.paciente.setNombrePaciente(nombrePaciente);
        this.paciente.setApellidoPaterno(apellidoPaterno);
        this.paciente.setApellidoMaterno(apellidoMaterno);
        
        try {
            this.paciente = pDao.delete(this.paciente);
        } catch (Exception e) {
           Logger.getLogger(PacienteBussines.class.getName()).log(Level.SEVERE, null, e);
           this.paciente = null;      
        }
        
        return this.paciente;
    
    }
    
    
    
}
