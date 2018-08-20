/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

/**
 *
 * @author daniel
 */
public class VentaDTO {

    
    public VentaDTO(int id){
        this.idVenta = id;
    }
    
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFechaVEnta() {
        return fechaVEnta;
    }

    public void setFechaVEnta(String fechaVEnta) {
        this.fechaVEnta = fechaVEnta;
    }

    public boolean isStatusVenta() {
        return statusVenta;
    }

    public void setStatusVenta(boolean statusVenta) {
        this.statusVenta = statusVenta;
    }    
    private int idVenta;
    private String fechaVEnta;
    private boolean statusVenta;
 
}
