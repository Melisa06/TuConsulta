/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario.negocio;

import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.RecetaDAO;
import modelo.dto.PacienteDTO;
import modelo.dto.RecetaDTO;

/**
 *
 * @author Morales
 */
public class RecetaBussines {
    
     public static RecetaDTO crear(int id_paciente,String fecha,String observaciones) {
    
            RecetaDTO u = new RecetaDTO();
            RecetaDAO dao = new RecetaDAO();
            
           
           u.setIdpaciente(new PacienteDTO(id_paciente));
            u.setFecha(fecha);
            u.setDiagnostico(observaciones);
            
            try {
            
                  u = dao.create(u);
                  
            } catch (Exception ex) {
                
                Logger.getLogger(RecetaBussines.class.getName()).log(Level.SEVERE, null, ex);
                
                u = null;
                
                System.out.print("Error: "+ex.getMessage());
            }
            
            
            return u;
    
    }
   
    
     public static RecetaDTO buscar(int id){
    
            RecetaDTO u = new RecetaDTO();
           RecetaDAO dao = new RecetaDAO();
            
            u.setId(id);
            
            
            try {
                u = dao.read(u);
            } catch (Exception ex) {
                
                  u = null;
                
                Logger.getLogger(RecetaBussines.class.getName()).log(Level.SEVERE, null, ex);
                
                if(ex.getMessage().equalsIgnoreCase("No encontrado")){
                    
                    System.out.print("Error: "+ex.getMessage());
                
                }else{
                    System.out.print("Error: "+ex.getMessage());
                }
                
             
            }
            
            return u;
    
    }
    
     
    
}
