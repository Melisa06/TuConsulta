/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.MedicoDAO;
import modelo.dto.MedicoDTO;
import modelo.dto.UsuarioDTO;

/**
 *
 * @author lupita
 */
public class MedicoBussines {
    
     public static MedicoDTO crear(String nombre,String paterno,String materno,String cedula,Boolean estatus,int id) {
    
            MedicoDTO m = new MedicoDTO();
            MedicoDAO dao = new MedicoDAO();
            
           
            m.setNombre(nombre);
            m.setPaterno(paterno);
            m.setMaterno(materno);
            m.setCedula(cedula);
            m.setEstatus(estatus);
            m.setIdUsuario(new UsuarioDTO(id));
            
            try {
            
                  m = dao.create(m);
                  
            } catch (Exception ex) {
                
                Logger.getLogger(MedicoBussines.class.getName()).log(Level.SEVERE, null, ex);
                
                m = null;
                
                System.out.print("Error: "+ex.getMessage());
            }
            
            
            return m;
    
    }
   
    
     public static MedicoDTO buscar(String nombre, int id){
    
            MedicoDTO m = new MedicoDTO();
            MedicoDAO dao = new MedicoDAO();
            
            m.setNombre(nombre);
            m.setId(id);
            
            try {
                m = dao.read(m);
            } catch (Exception ex) {
                
                  m = null;
                
                Logger.getLogger(MedicoBussines.class.getName()).log(Level.SEVERE, null, ex);
                
                if(ex.getMessage().equalsIgnoreCase("No encontrado")){
                    
                    System.out.print("Error: "+ex.getMessage());
                
                }else{
                    System.out.print("Error: "+ex.getMessage());
                }
                
             
            }
            
            return m;
    
    }
    
     
     public static List<MedicoDTO> buscar(){
    
            List<MedicoDTO> m = new ArrayList<>();
            MedicoDAO dao = new MedicoDAO();
            
            
            try {
                m = dao.readAll();
            } catch (Exception ex) {
                
                m = null;
                
                Logger.getLogger(MedicoBussines.class.getName()).log(Level.SEVERE, null, ex);
                
                if(ex.getMessage().equalsIgnoreCase("No encontrado")){
                    
                    System.out.print("Error: "+ex.getMessage());
                
                }else{
                    System.out.print("Error: "+ex.getMessage());
                }
                
              
            }
            
            return m;
    
    }
    
     
      public static MedicoDTO actualizar(String nombre,String paterno,String materno,String cedula,Boolean estatus,int usuario){
          
            MedicoDTO m = new MedicoDTO();
            MedicoDAO dao = new MedicoDAO();
            
            m.setNombre(nombre);
            m.setPaterno(paterno);
            m.setMaterno(materno);
            m.setCedula(cedula);
            m.setEstatus(estatus);
            m.setIdUsuario(new UsuarioDTO(usuario));
            
            try {
                m = dao.update(m);
            } catch (Exception ex) {
                Logger.getLogger(MedicoBussines.class.getName()).log(Level.SEVERE, null, ex);
                m = null;
                System.out.print("Error: "+ex.getMessage());
            }
            
            return m;
    
    }
      
     
      
     public static MedicoDTO eliminar(String nombre,Boolean estatus){
    
            MedicoDTO m = new MedicoDTO();
            MedicoDAO dao = new MedicoDAO();
            
            m.setNombre(nombre);
            m.setEstatus(estatus);
            
            try {
                m = dao.delete(m);
            } catch (Exception ex) {
                Logger.getLogger(MedicoBussines.class.getName()).log(Level.SEVERE, null, ex);
                m = null;
                System.out.print("Error: "+ex.getMessage());
            }
            
            return m;
    
    }
     
     public static MedicoDTO buscarId(int id){
        MedicoDTO pacientedto = new MedicoDTO(); 
        MedicoDAO pacientedao = new MedicoDAO(); 
        try {
            pacientedto.setIdUsuario(new UsuarioDTO(id));
            pacientedto = pacientedao.buscarId(pacientedto);
        } catch (Exception e) {
            Logger.getLogger(PacienteBussines.class.getName()).log(Level.SEVERE, null, e);
            pacientedto = null; 
        }
        return pacientedto;
    }
    
}
