/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.sql.Date;
/**
 *
 * @author Meli
 */
public class PacienteDTO {

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public Date getFechNac() {
        return fechNac;
    }

    public void setFechNac(Date fechNac) {
        this.fechNac = fechNac;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public String getTelPaciente() {
        return telPaciente;
    }

    public void setTelPaciente(String telPaciente) {
        this.telPaciente = telPaciente;
    }

    public UsuarioDTO getIdUsuarioDTO() {
        return idUsuarioDTO;
    }

    public void setIdUsuarioDTO(UsuarioDTO idUsuarioDTO) {
        this.idUsuarioDTO = idUsuarioDTO;
    }
    
    private int id; 
    private String nombrePaciente;
    private String apellidoPaterno; 
    private String apellidoMaterno;
    private Date fechNac;
    private double peso; 
    private String alergias;
    private double estatura;
    private String telPaciente;
    private UsuarioDTO idUsuarioDTO;
    private boolean  estatus; 
    
    
    public PacienteDTO(){}
    
    public PacienteDTO(int id){
        this.id = id;
    }
    
    public PacienteDTO(int id, String nombrePaciente, String apellidoPaterno,String apellidoMaterno, Date fechNac,double peso, String alergias,double estatura , String telPaciente, boolean  estatus){
    
        this.id = id; 
        this.nombrePaciente = nombrePaciente; 
        this.apellidoPaterno = apellidoPaterno; 
        this.apellidoMaterno = apellidoMaterno;
        this.fechNac =fechNac;
        this.peso = peso ; 
        this.alergias = alergias;
        this.estatura = estatura; 
        this.telPaciente = telPaciente; 
        this.estatus = estatus;    
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }
    
}
