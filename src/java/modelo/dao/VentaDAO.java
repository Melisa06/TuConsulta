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
import modelo.dto.VentaDTO;
import modelo.interfaz.IVenta;

/**
 *
 * @author daniel
 */
public class VentaDAO implements IVenta{
    String URL = "jdbc:postgresql://localhost:5432/itic40";
    String USER = "postgres";
    String PASS = "admin";

    @Override
    public VentaDTO create(VentaDTO vent) throws Exception {
        Connection connection = null;
        PreparedStatement pst = null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(URL,USER,PASS);
        
        
        pst = connection.prepareStatement("INSERT INTO venta (fecha_vent,estatus"
                + ") VALUES (?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setString(1, vent.getFechaVEnta());
        pst.setBoolean(2, vent.isStatusVenta());
        int r = pst.executeUpdate();
       
        if(r > 0){
            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next()){
                vent.setIdVenta(1);
            }
            return vent;
        }
           
        else
            throw new Exception("No insertado");
    }

    @Override
    public VentaDTO read(VentaDTO vent) throws Exception {
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(URL,USER,PASS);
        
        
        pst = connection.prepareStatement("SELECT id, fecha_vent, status FROM venta  WHERE id = ?");
        pst.setInt(1, vent.getIdVenta());
        rs = pst.executeQuery();
        
        if(rs.next()){
            vent.setIdVenta(rs.getInt("id"));
            vent.setFechaVEnta(rs.getString("fecha_vent"));
            vent.setStatusVenta(rs.getBoolean("estatus"));
            return vent;
        }
        
        else
            throw new Exception("No insertado");
    }
 public List<VentaDTO> read() throws Exception {
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(URL,USER,PASS);
        List<VentaDTO> listVentaDto = new ArrayList<>();
        
        pst = connection.prepareStatement("SELECT estatus,fecha_vent FROM venta");
        rs = pst.executeQuery();
        
        try {
            while(rs.next()){
                VentaDTO vent = new VentaDTO();
                vent.setIdVenta(rs.getInt("id"));
                vent.setStatusVenta(rs.getBoolean("estatus"));
                vent.setFechaVEnta(rs.getString("fecha_vent"));
    
                
                listVentaDto.add(vent);
            }
            return listVentaDto;
        } 
        catch (Exception ex) {
            throw new Exception("Error " + ex.getMessage());
        }   
    }
    @Override
    public VentaDTO update(VentaDTO vent) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public VentaDTO delete(VentaDTO vent) throws Exception {
          Connection connection = null;
        PreparedStatement pst = null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(URL,USER,PASS);
        
        pst = connection.prepareStatement("UPDATE venta set estatus = ? WHERE id =(?)");
        pst.setBoolean(1, vent.isStatusVenta());
        pst.setInt(2, vent.getIdVenta());
        int r = pst.executeUpdate();
        
        if(r > 0)
            return vent;
        else
            throw new Exception("No insertado");
    }
    
}
