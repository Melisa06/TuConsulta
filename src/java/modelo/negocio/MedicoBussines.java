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
import modelo.dto.PacienteDTO;

/**
 *
 * @author lupita
 */
public class MedicoBussines {
    
//      public static List<MedicoDTO> crear(List<String> medico) throws SQLException{
//    
//            List<MedicoDTO> m = new ArrayList<MedicoDTO>();
//            MedicoDAO dao = new MedicoDAO();
//            
//                String URL = "jdbc:postgresql://localhost:5432/iti40";
//                String USER = "postgres";
//                String PASSWORD = "admin";
//            
//           Connection con2 = DriverManager.getConnection(URL, USER, PASSWORD);
//           
//            try {
//                con2.setAutoCommit(false);
//            
//                  for(int i=0;i<medico.size();i++){
//                    MedicoDTO mdto= new MedicoDTO();
//
//                    mdto.setNombre(nombre.get(i));
//                    mdto.setApellido(apellido.get(i));
//                    mdto.setPassword(password.get(i));
//                    mdto.setEstatus(true);
//                    
//                     m.add(dao.create(mdto,con2));
//                   }
//                
//                 con2.commit();
//                  
//               // con2.close();
//            } catch (Exception ex) {
//                
//                con2.rollback();
//                
//                Logger.getLogger(MedicoBussines.class.getName()).log(Level.SEVERE, null, ex);
//                
//                m = null;
//                
//                
//                System.out.print("Error: "+ex.getMessage());
//            }
//            
//            
//            return m;
//    
//    }
    
     public static MedicoDTO crear(String nombre,String apellido,String curp,Boolean estatus,int id) {
    
            MedicoDTO m = new MedicoDTO();
            MedicoDAO dao = new MedicoDAO();
            
           
            m.setNombre(nombre);
            m.setApellido(apellido);
            m.setCurp(curp);
            m.setEstatus(estatus);
            m.setIdPaciente(new PacienteDTO(id));
            
            try {
            
                  m = dao.create(m);
                  
            } catch (Exception ex) {
                
                Logger.getLogger(MedicoBussines.class.getName()).log(Level.SEVERE, null, ex);
                
                m = null;
                
                System.out.print("Error: "+ex.getMessage());
            }
            
            
            return m;
    
    }
   
    
     public static MedicoDTO buscar(String nombre){
    
            MedicoDTO m = new MedicoDTO();
            MedicoDAO dao = new MedicoDAO();
            
            m.setNombre(nombre);
            
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
                m = dao.read();
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
    
     
      public static MedicoDTO actualizar(String nombre,String apellido,String curp,Boolean estatus,int paciente){
          
            MedicoDTO m = new MedicoDTO();
            MedicoDAO dao = new MedicoDAO();
            
            m.setNombre(nombre);
            m.setApellido(apellido);
            m.setCurp(curp);
            m.setEstatus(estatus);
            m.setIdPaciente(new PacienteDTO(paciente));
            
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
    
}
