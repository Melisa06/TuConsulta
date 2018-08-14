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
import modelo.dto.MedicamentoDTO;
import modelo.interfaz.IMedicamento;

/**
 *
 * @author Jhazmin Alvarez
 */
public class MedicamentoDAO  implements IMedicamento{
    String URL = "jdbc:postgresql://localhost:5432/TuConsulta";
    String USER = "postgres";
    String PASSWORD = "admin";
    
    public Connection con = null;
    public PreparedStatement pst = null;

    @Override
    public MedicamentoDTO create(MedicamentoDTO medicamento) throws Exception {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        
        pst = con.prepareStatement("INSERT INTO medicamento (nombremedicamento,descripcion,precio,stock,fechaactualizacion,estatus) values (?,?,?,?,current_date,?)",
                PreparedStatement.RETURN_GENERATED_KEYS);
        
        pst.setString(1, medicamento.getNombreMedicamento());
        pst.setString(2, medicamento.getDescripcion());
        pst.setFloat(3, medicamento.getPrecio());
        pst.setInt(4,medicamento.getStock());
        pst.setBoolean(5, medicamento.getEstatus());
//        pst.setString(6, medicamento.getImagen());
 
        
       int result = pst.executeUpdate();
        
        if(result > 0){
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()){
                medicamento.setId(rs.getInt(1));
                
            }
            
            return medicamento;
        }
        throw new Exception("No encontrado");
       
    }

    @Override
    public MedicamentoDTO read(MedicamentoDTO dto) throws Exception {
       MedicamentoDTO medicamento = new MedicamentoDTO();
        
        Class.forName("org.postgresql.Driver");
        
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        
        pst = con.prepareStatement("select * From medicamento where Id =?");
        
        pst.setInt(1, dto.getId());
        
        ResultSet result = pst.executeQuery();
        
        while(result.next()){
            
            medicamento.setId(result.getInt("Id"));
            medicamento.setNombreMedicamento(result.getString("nombremedicamento"));
            medicamento.setDescripcion(result.getString("descripcion"));
            medicamento.setStock(result.getInt("stock"));
            medicamento.setPrecio(result.getFloat("precio"));
            medicamento.setFechaActualizacion(result.getDate("fechaactualizacion"));
            medicamento.setEstatus(result.getBoolean("estatus"));
            medicamento.setImagen(result.getString("imagen"));
            
           
        }
        
        return medicamento;
        }
        

    @Override
    public MedicamentoDTO update(MedicamentoDTO NombreMedicamento) throws Exception {
        Connection connection = null;
        pst = null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(URL,USER,PASSWORD);
        
        pst = connection.prepareStatement("UPDATE medicamento SET nombremedicamento =? ,descripcion = ?,precio = ? ,stock = ?,fechaactualizacion = current_date WHERE Id = ?");
        
        pst.setString(1, NombreMedicamento.getNombreMedicamento());
        pst.setString(2, NombreMedicamento.getDescripcion());
        pst.setFloat(3, NombreMedicamento.getPrecio());
        pst.setInt(4,NombreMedicamento.getStock());
//       pst.setString(5, NombreMedicamento.getImagen());
       pst.setInt(5, NombreMedicamento.getId());
        int r = pst.executeUpdate();
        
        if(r > 0)
            return NombreMedicamento;
        else
            throw new Exception("No insertado");
    }

    @Override
    public MedicamentoDTO delete(MedicamentoDTO medicamento) throws Exception {
        Class.forName("org.postgresql.Driver");
      
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        
            pst = con.prepareStatement("Update medicamento SET estatus = ? WHERE Id = ?");
        
       
        pst.setInt(2, medicamento.getId());
        pst.setBoolean(1, medicamento.getEstatus());
        
        
        int result = pst.executeUpdate();
        
        if(result > 0){
            
            return medicamento;
        }
        
        throw new Exception("No encontrado");
        
        
    }

    
    
    public List<MedicamentoDTO> read() throws Exception {
        
        List<MedicamentoDTO> medicamento = new ArrayList<>();
        
        Class.forName("org.postgresql.Driver");
        
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        
        pst = con.prepareStatement("select * From medicamento  order by id asc");
        
        ResultSet result = pst.executeQuery();
        
        while(result.next()){
            
            MedicamentoDTO mdc = new MedicamentoDTO();
            mdc.setId(result.getInt("id"));
            mdc.setNombreMedicamento(result.getString("nombremedicamento"));
            mdc.setDescripcion(result.getString("descripcion"));
            mdc.setPrecio(result.getFloat("precio"));
            mdc.setStock(result.getInt("stock"));
            mdc.setFechaActualizacion(result.getDate("fechaActualizacion"));
            mdc.setEstatus(result.getBoolean("estatus"));
            mdc.setImagen(result.getString("imagen"));
            medicamento.add(mdc);
        }
        
        return medicamento;
    }

}
