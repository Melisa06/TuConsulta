/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;



public class ProveedorDTO {
    private int  idProvee;
	private String nombreProv; 
        private String telProv;    
	private String direccion;
        private boolean status;
	private MedicamentoDTO idMedi;

    public int getIdProvee() {
        return idProvee;
    }

    public void setIdProvee(int idProvee) {
        this.idProvee = idProvee;
    }

    public String getNombreProv() {
        return nombreProv;
    }

    public void setNombreProv(String nombreProv) {
        this.nombreProv = nombreProv;
    }

    public String getTelProv() {
        return telProv;
    }

    public void setTelProv(String telProv) {
        this.telProv = telProv;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public MedicamentoDTO getIdMedi() {
        return idMedi;
    }

    public void setIdMedi(MedicamentoDTO idMedi) {
        this.idMedi = idMedi;
    }
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
        
    
}
