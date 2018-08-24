/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

/**
 
 * 
 * @author Morales
 */
public class RecetaDTO {
    private int id;
    private String fecha;
   private String diagnostico ;
   private CitaDTO idcita;
   private PacienteDTO idpaciente;
   
   public RecetaDTO(){}
   
   public RecetaDTO(int id){
       this.id = id;
   }

    /**
     * @return the receta


    /**
     * @return the diagnostico
     */
    public String getDiagnostico() {
        return diagnostico;
    }

    /**
     * @param diagnostico the diagnostico to set
     */
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    /**
     * @return the idcita
     */
    public CitaDTO getIdcita() {
        return idcita;
    }

    /**
     * @param idcita the idcita to set
     */
    public void setIdcita(CitaDTO idcita) {
        this.idcita = idcita;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idpaciente
     */
    public PacienteDTO getIdpaciente() {
        return idpaciente;
    }

    /**
     * @param idpaciente the idpaciente to set
     */
    public void setIdpaciente(PacienteDTO idpaciente) {
        this.idpaciente = idpaciente;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
  
            
}
