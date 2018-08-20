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
import modelo.dao.ProvedorDAO;
import modelo.dto.MedicamentoDTO;
import modelo.dto.ProveedorDTO;

/**
 *
 * @author daniel
 */
public class ProveedorBussines {
    public static ProveedorDTO crear(int idProve, String nombrePro, String direccion,String telefono, boolean status,int idMed){
        
        
        ProveedorDTO u = new ProveedorDTO();
        ProvedorDAO dao = new ProvedorDAO();
        
        u.setIdProvee(idProve);
        u.setNombreProv(nombrePro);
        u.setTelProv(telefono);
        u.setDireccion(direccion);
       
        u.setStatus(status);
       
        u.setIdMedi(new MedicamentoDTO(idMed));
        try {
            u = dao.create(u);
        } 
        catch (Exception ex) {
            Logger.getLogger(ProveedorBussines.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
        
        return u;
    }
     public static ProveedorDTO crearBatch(int idProve, String nombrePro, String direccion,String telefono, boolean status,int idMed){
        
        
       ProveedorDTO u = new ProveedorDTO();
        ProvedorDAO dao = new ProvedorDAO();
       
        
         u.setIdProvee(idProve);
        u.setNombreProv(nombrePro);
        u.setTelProv(telefono);
        u.setDireccion(direccion);
        u.setStatus(status);
       
        u.setIdMedi(new MedicamentoDTO(idMed));
        
        try {
            u = dao.create(u);
        } 
        catch (Exception ex) {
            Logger.getLogger(ProveedorBussines.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
        
        return u;
    }
    public static ProveedorDTO buscar(int idProv){
        ProveedorDTO u = new ProveedorDTO();
        ProvedorDAO dao = new ProvedorDAO();
        
        u.setIdProvee(idProv);
        try {
            u = dao.read(u);
        }
        catch (Exception ex) {
            u = null;
            Logger.getLogger(ProveedorBussines.class.getName()).log(Level.SEVERE, null, ex);
            if(ex.getMessage().equalsIgnoreCase("No encontrado")){
                System.out.println("No encontrado");
            }
            else{
                System.out.println("Error " + ex.getMessage());
            }
        }
        return u;
    }
    
    public static List<ProveedorDTO> buscar(){
        List<ProveedorDTO> u = new ArrayList<>();
        ProvedorDAO dao = new ProvedorDAO();
        try {
            u = dao.read();
        } 
        catch (Exception ex) {
            Logger.getLogger(ProveedorBussines.class.getName()).log(Level.SEVERE, null, ex);
            if(ex.getMessage().equalsIgnoreCase("No encontrado")){
                System.out.println("No encontrado");
            }
            else{
                System.out.println("Error " + ex.getMessage());
            }
        }
        return u;
    }
    
    public static ProveedorDTO actualizar(int idProv, String nombreProv, String direccionProv,String telProv, boolean estatus, int idMed){
        ProveedorDTO u = new ProveedorDTO();
        ProvedorDAO dao = new ProvedorDAO();
        
        u.setIdProvee(idProv);
        u.setNombreProv(nombreProv);
        u.setDireccion(direccionProv);
        u.setTelProv(telProv);

        u.setStatus(estatus);
        u.setIdMedi(MedicamentoBussines.buscar(idMed));
      
        
        try {
            u = dao.update(u);
        } 
        catch (Exception ex) {
            Logger.getLogger(ProveedorBussines.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
        
        return u;
    }
    
    public static ProveedorDTO borrar(int idProv){
        ProveedorDTO u = new ProveedorDTO();
        ProvedorDAO dao = new ProvedorDAO();
        
        u.setIdProvee(idProv);
        u.setStatus(false);
        
        try {
            u = dao.delete(u);
        } 
        catch (Exception ex) {
            Logger.getLogger(ProveedorBussines.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
        
        return u;
    }
     public static ProveedorDTO activar(int idProv){
        ProveedorDTO u = new ProveedorDTO();
        ProvedorDAO dao = new ProvedorDAO();
        
        u.setIdProvee(idProv);
        u.setStatus(true);
        
        try {
            u = dao.delete(u);
        } 
        catch (Exception ex) {
            Logger.getLogger(ProveedorBussines.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
        
        return u;
    }
    
    
}
