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
import java.util.ArrayList;
import java.util.List;
import modelo.dto.MedicoDTO;
import modelo.interfaz.IMedico;
import modelo.negocio.MedicoBussines;

/**
 *
 * @author lupita
 */
public class MedicoDAO implements IMedico {

    //modelo : dto,dao,interfaz,bussines
    //Dao Acceder a los datos de bd   
    
    
    String URL = "jdbc:postgresql://localhost:5432/iti40";
    String USER = "postgres";
    String PASSWORD = "admin";
    
    public Connection con = null;
    public PreparedStatement pst = null;
    
     @Override
    public MedicoDTO create(MedicoDTO medico) throws Exception {
        
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        
        pst = con.prepareStatement("INSERT INTO medicos (nombre,apellido,curp,estatus,id) values (?,?,?,?,?)");
        
        pst.setString(1, medico.getNombre());
        pst.setString(2, medico.getApellido());
        pst.setString(3, medico.getCurp());
        pst.setBoolean(4, medico.isEstatus());
        pst.setInt(5, medico.getIdPaciente().getId());
        
        int result = pst.executeUpdate();
        
        if(result > 0){
            
            return medico;
        }
        throw new Exception("No encontrado");
    }
    
    @Override
    public MedicoDTO create(MedicoDTO medico,Connection con2) throws Exception {
        
        Class.forName("org.postgresql.Driver");
     //   con2 = DriverManager.getConnection(URL, USER, PASSWORD);
        
        pst = con2.prepareStatement("INSERT INTO medicos (usuario,paciente,apellido,curp,estatus) values (?,?,?,?,?)");
        
        pst.setString(1, medico.getNombre());
        pst.setInt(2, medico.getIdPaciente().getId());
        pst.setString(3, medico.getApellido());
        pst.setString(4, medico.getCurp());
        pst.setBoolean(5, medico.isEstatus());
        
        int result = pst.executeUpdate();
        
        if(result > 0){
            
            return medico;
        }
        throw new Exception("No encontrado");
    }

    
    @Override
    public MedicoDTO read(MedicoDTO medico) throws Exception {
    
       // Connection con = null;
        
       // PreparedStatement pst = null;
        
        Class.forName("org.postgresql.Driver");
        
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        
        pst = con.prepareStatement("select nombre,apellido,curp,medicos.estatus,id From medicos Where medico like ?");      
                       
        pst.setString(1, medico.getNombre());
        
        ResultSet result = pst.executeQuery();
                
        if(result.next()){
            
            medico.setNombre(result.getString("nombre"));
            medico.setApellido(result.getString("apellido"));
            medico.setCurp(result.getString("curp"));
            medico.setEstatus(result.getBoolean("estatus"));
            //medico.setIdPaciente(PacienteBussines.buscar(result.getInt("id")));
            
            return medico;
        }
        
        throw new Exception("No encontrado");
    }
    
    
     public List<MedicoDTO> read() throws Exception {
       //  Connection con = null;
        
       // PreparedStatement pst = null;
        
        List<MedicoDTO> medicos = new ArrayList<>();
        
        Class.forName("org.postgresql.Driver");
        
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        
        pst = con.prepareStatement("select nombre,apellido,curp,medicos.estatus,id From medicos order by nombre asc");
        
        ResultSet result = pst.executeQuery();
        
     
        while(result.next()){
            
            MedicoDTO dto = new MedicoDTO();
            
            dto.setNombre(result.getString("nombre"));
            dto.setApellido(result.getString("apellido"));
            dto.setCurp(result.getString("curp"));
            dto.setEstatus(result.getBoolean("estatus"));
            //dto.setIdPaciente(PacienteBussines.buscar(result.getInt("id"),con));
            medicos.add(dto);
            
            
        }
        
        return medicos;
        
    }

    @Override
    public MedicoDTO update(MedicoDTO medico) throws Exception {
        
       // Connection con = null;
        
       // PreparedStatement pst = null;
        
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        
        MedicoDTO dto = MedicoBussines.buscar(medico.getNombre());
        
        //if(!dto.getPassword().equals(medico.getPassword())){
        
          //  pst = con.prepareStatement("UPDATE usuarios set password = MD5(?), estatus = ?, id = ? WHERE usuario like ?");


            pst.setString(1, medico.getApellido());
            
            pst.setString(2, medico.getCurp());

            pst.setBoolean(3, medico.isEstatus());
            
            pst.setInt(4, medico.getIdPaciente().getId());

            pst.setString(5, medico.getNombre());
            
            pst = con.prepareStatement("UPDATE medicos set id = ?, estatus = ? WHERE nombre like ?");
            
            pst.setInt(1, medico.getIdPaciente().getId());
            
            pst.setBoolean(2, medico.isEstatus());

            pst.setString(3, medico.getNombre());
        
        int result = pst.executeUpdate();
        
        if(result > 0){
            
            return medico;
        }
        
        throw new Exception("No encontrado");
        
        
    }

    @Override
    public MedicoDTO delete(MedicoDTO medico) throws Exception {
       // Connection con = null;
        
       // PreparedStatement pst = null;
        
        Class.forName("org.postgresql.Driver");
       
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        
        pst = con.prepareStatement("Update medicos set estatus = ? WHERE medico like ?");
        
        pst.setBoolean(1, medico.isEstatus());
        pst.setString(2, medico.getNombre());
        
        int result = pst.executeUpdate();
        
        if(result > 0){
            
            return medico;
        }
        
        throw new Exception("No encontrado"); 
    }
    
}