/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.negocio;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.DetalleVentaDAO;
import modelo.dto.DetalleVentDTO;
import modelo.dto.MedicamentoDTO;
import modelo.dto.VentaDTO;

/**
 *
 * @author daniel
 */
public class DetalleVentaBussines {
    public static DetalleVentDTO crear(int idVenta,int idMedi,int cant,double precioUni,double montoTotal){
             
        DetalleVentDTO d = new DetalleVentDTO();
        DetalleVentaDAO dao = new DetalleVentaDAO();
        
        d.setIdVenta(new VentaDTO(idVenta));
        d.setIdMedicamento(new MedicamentoDTO(idMedi));
        d.setCant(cant);
        d.setPrecioUni(precioUni);
        d.setMontoTotal(montoTotal);
        
        try {
            d = dao.create(d);
        } 
        catch (Exception ex) {
            Logger.getLogger(VentaBussines.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
        
        return d;
    }
        
    
    
    
    
    
}
