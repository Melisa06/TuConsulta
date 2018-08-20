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
import modelo.dto.DetalleVentDTO;
import modelo.negocio.MedicamentoBussines;
import modelo.negocio.VentaBussines;

/**
 *
 * @author daniel
 */
public class DetalleVentaDAO {
    String URL = "jdbc:postgresql://localhost:5432/itic40";
    String USER = "postgres";
    String PASS = "admin";
    
    
    
    public DetalleVentDTO create(DetalleVentDTO det) throws Exception {
        Connection connection = null;
        PreparedStatement pst = null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(URL,USER,PASS);
        
        
        pst = connection.prepareStatement("INSERT INTO detalle_venta (id_venta, id_medi,cant,precio_uni,monto_total,monto_recibido"
                + ") VALUES (?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setInt(1, det.getIdVenta().getIdVenta());
        pst.setInt(2, det.getIdMedicamento().getId());
        pst.setInt(3, det.getCant());
        pst.setDouble(4, det.getMontoTotal());
        pst.setDouble(5, det.getMontoRecibido());
        
        int r = pst.executeUpdate();
       
        if(r > 0){
            return det;
        }
           
        else
            throw new Exception("No insertado");
    }

  
    public DetalleVentDTO read(DetalleVentDTO det) throws Exception {
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(URL,USER,PASS);
        
        
        pst = connection.prepareStatement("SELECT id_venta, id_medi,cant,precio_uni,monto_total,monto_recibido FROM detalle_vent t1 INNER JOIN venta t2 "
                + "                         ON t1.id_venta = t2.id  WHERE t1.id_venta = ?");
        pst.setInt(1, det.getIdVenta().getIdVenta());
        rs = pst.executeQuery();
        
        if(rs.next()){
            det.setIdVenta(VentaBussines.buscar(rs.getInt("id_venta")));
            det.setIdMedicamento(MedicamentoBussines.buscar(rs.getInt("id_medi")));
            det.setCant(rs.getInt("cant"));
            det.setMontoRecibido(rs.getDouble("monto_recibido"));
            det.setMontoTotal(rs.getDouble("monto_total"));
            det.setPrecioUni(rs.getDouble("precio_uni"));
        
            return det;
        }
        
        else
            throw new Exception("No insertado");
    }
 public List<DetalleVentDTO> read() throws Exception {
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(URL,USER,PASS);
        List<DetalleVentDTO> listDetalleVenDto = new ArrayList<>();
        
        pst = connection.prepareStatement("SELECT id_venta, id_medi,cant,precio_uni,monto_total,monto_recibido FROM detalle_vent t1 INNER JOIN venta t2 "
                + "                         ON t1.id_venta = t2.id  WHERE t1.id_venta = ?");
        rs = pst.executeQuery();
        
        try {
            while(rs.next()){
                DetalleVentDTO det = new DetalleVentDTO();
            det.setIdVenta(VentaBussines.buscar(rs.getInt("id_venta")));
            det.setIdMedicamento(MedicamentoBussines.buscar(rs.getInt("id_medi")));
            det.setCant(rs.getInt("cant"));
            det.setMontoRecibido(rs.getDouble("monto_recibido"));
            det.setMontoTotal(rs.getDouble("monto_total"));
            det.setPrecioUni(rs.getDouble("precio_uni"));
    
                
                listDetalleVenDto.add(det);
            }
            return listDetalleVenDto;
        } 
        catch (Exception ex) {
            throw new Exception("Error " + ex.getMessage());
        }   
    }
    

    
}
