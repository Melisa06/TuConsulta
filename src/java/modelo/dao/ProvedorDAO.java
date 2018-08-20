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
import modelo.dto.ProveedorDTO;


/**
 *
 * @author daniel
 */
public class ProvedorDAO {
    String URL = "jdbc:postgresql://localhost:5432/itic40";
    String USER = "postgres";
    String PASS = "admin";
    
    @SuppressWarnings("UnnecessaryReturnStatement")
    public ProveedorDTO create(ProveedorDTO pro)  throws Exception {
        Connection connection = null;
        PreparedStatement pst = null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(URL,USER,PASS);
        
        
        pst = connection.prepareStatement("INSERT INTO venta (nombre_prov,tel_prov,direccion,id_medi"
                + ") VALUES (?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
        
        pst.setString(1, pro.getNombreProv());
        pst.setString(2, pro.getTelProv());
        pst.setString(3, pro.getDireccion());
        pst.setInt(4, pro.getIdMedi().getId());        
        int r = pst.executeUpdate();
        
        if(r > 0){
            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next()){
                pro.setIdProvee(1);
            }
            return pro;
        }
        else
            throw new Exception("No insertado");
    }

    public ProvedorDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ProveedorDTO read(ProveedorDTO pro) throws Exception {
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(URL,USER,PASS);
        
        
        pst = connection.prepareStatement("SELECT nombre_prov,tel_prov,direccion,status FROM proveedor  WHERE id = ?");
        pst.setInt(1, pro.getIdProvee());
        rs = pst.executeQuery();
        
        if(rs.next()){
            pro.setIdProvee(rs.getInt("id"));
            pro.setNombreProv(rs.getString("nombre_prov"));
            pro.setDireccion(rs.getString("direccion"));
            pro.setTelProv(rs.getString("tel_prov"));
            
       
            return pro;
        }
        
        else
            throw new Exception("No insertado");
    }
    
     public List<ProveedorDTO> read() throws Exception {
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(URL,USER,PASS);
        List<ProveedorDTO> listProveedorDto = new ArrayList<>();
        
        pst = connection.prepareStatement("SELECT nombre_prov,tel_prov,direccion,status FROM proveedor ");
        rs = pst.executeQuery();
        
        try {
            while(rs.next()){
                ProveedorDTO pro = new ProveedorDTO() ;
                 pro.setNombreProv(rs.getString("nombre_prov"));
                 pro.setDireccion(rs.getString("direccion"));
                 pro.setTelProv(rs.getString("tel_prov"));
                 pro.setStatus(rs.getBoolean("status"));
                 
    
                
                listProveedorDto.add(pro);
            }
            return listProveedorDto;
        } 
        catch (Exception ex) {
            throw new Exception("Error " + ex.getMessage());
        }   
    }
        public ProveedorDTO update(ProveedorDTO pro) throws Exception {
        Connection connection = null;
        PreparedStatement pst = null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(URL,USER,PASS);
        
        pst = connection.prepareStatement("UPDATE proveedor SET nombre_prov = ?, direccion = ?,tel_prov = ? WHERE id = ?");
        pst.setString(1, pro.getNombreProv());
        pst.setString(2, pro.getDireccion());
        pst.setString(3, pro.getTelProv());
        //pst.setInt(4, usuario.getIdRol().getId());
        int r = pst.executeUpdate();
        
        if(r > 0)
            return pro;
        else
            throw new Exception("No insertado");
    }

  
    public ProveedorDTO delete(ProveedorDTO pro) throws Exception {
        Connection connection = null;
        PreparedStatement pst = null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(URL,USER,PASS);
        
        pst = connection.prepareStatement("UPDATE proveedor set estatus = ? WHERE id =(?)");
        pst.setBoolean(1, pro.isStatus());
        pst.setInt(2, pro.getIdProvee());
        int r = pst.executeUpdate();
        
        if(r > 0)
            return pro;
        else
            throw new Exception("No insertado");
    }
    
}
