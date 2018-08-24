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
import modelo.dao.VentaDAO;
import modelo.dto.VentaDTO;

/**
 *
 * @author daniel
 */
public class VentaBussines {
    public static VentaDTO crear(Boolean estatusVenta){
        
        VentaDTO v = new VentaDTO();
        VentaDAO dao = new VentaDAO();
        
       
        v.setStatusVenta(estatusVenta);
        try {
            v = dao.create(v);
        } 
        catch (Exception ex) {
            Logger.getLogger(VentaBussines.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
        
        return v;
    }

     public static VentaDTO buscar(int id){
        VentaDTO v = new VentaDTO();
        VentaDAO dao = new VentaDAO();
        
        v.setIdVenta(id);
        try {
            v = dao.read(v);
        }
        catch (Exception ex) {
            v = null;
            Logger.getLogger(VentaBussines.class.getName()).log(Level.SEVERE, null, ex);
            if(ex.getMessage().equalsIgnoreCase("No encontrado")){
                System.out.println("No encontrado");
            }
            else{
                System.out.println("Error " + ex.getMessage());
            }
        }
        return v;
    }
    
    public static List<VentaDTO> buscar(){
        List<VentaDTO> venta = new ArrayList<>();
        VentaDAO dao = new VentaDAO();
        try {
            venta = dao.read();
        } 
        catch (Exception ex) {
            Logger.getLogger(VentaBussines.class.getName()).log(Level.SEVERE, null, ex);
            if(ex.getMessage().equalsIgnoreCase("No encontrado")){
                System.out.println("No encontrado");
            }
            else{
                System.out.println("Error " + ex.getMessage());
            }
        }
        return venta;
    }
    
    
    public static VentaDTO borrar(int id){
        VentaDTO v = new VentaDTO();
        VentaDAO dao = new VentaDAO();
        
        v.setIdVenta(id);
        v.setStatusVenta(false);
        
        try {
            v = dao.delete(v);
        } 
        catch (Exception ex) {
            Logger.getLogger(VentaBussines.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
        
        return v;
    }
     public static VentaDTO activar(int id){
        VentaDTO v = new VentaDTO();
        VentaDAO dao = new VentaDAO();
        
        v.setIdVenta(id);
        v.setStatusVenta(true);
        
        try {
            v = dao.delete(v);
        } 
        catch (Exception ex) {
            Logger.getLogger(VentaBussines.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
        
        return v;
    }
    
    
}
