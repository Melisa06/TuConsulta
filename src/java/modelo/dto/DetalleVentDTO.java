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
public class DetalleVentDTO {

        private int  idProvee;
	private String nombreProv; 
        private String telProv;    
	private String direccion;
	private MedicamentoDTO idMedi;
        
     private VentaDTO idVenta;
     private MedicamentoDTO idMedicamento;
     private int cant;
     private Double precioUni;

    public VentaDTO getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(VentaDTO idVenta) {
        this.idVenta = idVenta;
    }

    public MedicamentoDTO getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(MedicamentoDTO idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public Double getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(Double precioUni) {
        this.precioUni = precioUni;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Double getMontoRecibido() {
        return montoRecibido;
    }

    public void setMontoRecibido(Double montoRecibido) {
        this.montoRecibido = montoRecibido;
    }
      private Double montoTotal;
      private Double montoRecibido;
     
     
   
}
