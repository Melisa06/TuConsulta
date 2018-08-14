/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.dto.PacienteDTO;
import modelo.dto.RecetaDTO;
import modelo.interfaz.Ireceta;

/**
 *
 * @author Morales
 */
public class RecetaDAO implements Ireceta {
       
    String URL = "jdbc:postgresql://localhost:5432/receta";
    String USER = "postgres";
    String PASSWORD = "admin";
    
    public Connection con = null;
    public PreparedStatement pst = null;

    @Override
    public RecetaDTO create(RecetaDTO receta) throws Exception {
    
        
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        
        
            System.out.println(receta.getIdpaciente().getId()+" "+receta.getFecha()+" "+receta.getDiagnostico());
        
        pst = con.prepareStatement("INSERT INTO receta (id_paciente,observaciones) values (?,'?')",
                PreparedStatement.RETURN_GENERATED_KEYS);
        
        pst.setInt(1, receta.getIdpaciente().getId());
        pst.setString(2, receta.getDiagnostico());
       
        
        
        int result = pst.executeUpdate();
        
        if(result > 0){
            
            
            ResultSet rs= pst.getGeneratedKeys();
               if(rs.next()) {
                receta.setId(rs.getInt(1));
                
            }
           
            
            return receta;
        }
        throw new Exception("No encontrado");
    }

    @Override
    public RecetaDTO read(RecetaDTO receta) throws Exception {
         
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        
        pst = con.prepareStatement("SELECT * FROM receta where id = ?");
               
        pst.setInt(1, receta.getId());
       
       
   ResultSet result = pst.executeQuery();
   while(result.next()){
       receta.setIdpaciente(new PacienteDTO( result.getInt("id_paciente")));
   }
            
            return receta; 
    }
    
    
}
