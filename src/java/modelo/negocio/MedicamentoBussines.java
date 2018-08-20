/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.negocio;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.MedicamentoDAO;
import modelo.dto.MedicamentoDTO;

/**
 *
 * @author Jhazmin Alvarez
 */
public class MedicamentoBussines {
     public static List<MedicamentoDTO> buscar(){
    
            List<MedicamentoDTO> u ;
            MedicamentoDAO dao = new MedicamentoDAO();
            
            try {
              
                u = dao.read();
                
            } catch (Exception ex) {
                
                u = null;
                
                Logger.getLogger(MedicamentoBussines.class.getName()).log(Level.SEVERE, null, ex);
                
                System.out.print("Error: "+ex.getMessage());
                
            }
            
            return u;
    
    }

    public static MedicamentoDTO crear(String nombreM, String descripcion, int stock, float precio  ,boolean estatus) {
            MedicamentoDTO u = new MedicamentoDTO();
            MedicamentoDAO dao = new MedicamentoDAO();                    
            u.setNombreMedicamento(nombreM);
            u.setDescripcion(descripcion);
//          u.setFechaActualizacion(fechaActualizacion);
//          u.setImagen(imagen);
            u.setEstatus(estatus);
            u.setPrecio(precio);
            u.setStock(stock);
           
            
            try {
            
                  u = dao.create(u);
                  
            } catch (Exception ex) {
                
                Logger.getLogger(MedicamentoBussines.class.getName()).log(Level.SEVERE, null, ex);
                
                u = null;
                
                System.out.print("Error: "+ex.getMessage());
            }
            
            
            return u;
    
    }

    public static MedicamentoDTO buscar(int Id) {
           MedicamentoDTO u = new MedicamentoDTO();
           MedicamentoDAO dao = new MedicamentoDAO();
            
            u.setId(Id);
            
            try {
                u = dao.read(u);
            } catch (Exception ex) {
                
                  u = null;
                
                Logger.getLogger(MedicamentoBussines.class.getName()).log(Level.SEVERE, null, ex);
                
                if(ex.getMessage().equalsIgnoreCase("No encontrado")){
                    
                    System.out.print("Error: "+ex.getMessage());
                
                }else{
                    System.out.print("Error: "+ex.getMessage());
                }
                
             
            }
            
            return u;
    
    }

         

    public static MedicamentoDTO update(int id,String nombreM, String descripcion, int stock, float precio) {
       MedicamentoDTO u = new MedicamentoDTO();
       MedicamentoDAO dao = new MedicamentoDAO();
            u.setId(id);
            u.setNombreMedicamento(nombreM);
            u.setDescripcion(descripcion);
//            u.setImagen(imagen);
            
            u.setPrecio(precio);
            u.setStock(stock);
        
        try {
            u = dao.update(u);
        } 
        catch (Exception ex) {
            Logger.getLogger(MedicamentoBussines.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
        
        return u;
    }

    public static MedicamentoDTO eliminar(int m, boolean status) {
           MedicamentoDTO u = new MedicamentoDTO();
            MedicamentoDAO dao = new MedicamentoDAO();
            
            u.setId(m);
            u.setEstatus(status);
           
            
            try {
                u = dao.delete(u);
            } catch (Exception ex) {
                Logger.getLogger(MedicamentoBussines.class.getName()).log(Level.SEVERE, null, ex);
                u = null;
                System.out.print("Error: "+ex.getMessage());
            }
            
            return u;
    
    } 

   
    
}

