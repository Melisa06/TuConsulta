/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

/**
 *
 * @author lupita
 */
public class MedicoDTO {
    
    private int id;

    
    private String nombre;
    private String apellido;
    private String curp;
    private PacienteDTO idPaciente;
    private boolean estatus;

    public MedicoDTO(){}
    
    public MedicoDTO(int id){
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public PacienteDTO getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(PacienteDTO idPaciente) {
        this.idPaciente = idPaciente;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
    
    
    
}
