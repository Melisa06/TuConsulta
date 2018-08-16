/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dto;

import java.util.Date;

/**
 *
 * @author Windows
 */
public class CitaDTO {
    
    private int id;
    private String fechacita;
    private PacienteDTO id_paciente;
    private MedicoDTO id_medico;
    private boolean estatus;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechacita() {
        return fechacita;
    }

    public void setFechacita(String fechacita) {
        this.fechacita = fechacita;
    }

    public PacienteDTO getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(PacienteDTO id_paciente) {
        this.id_paciente = id_paciente;
    }

    public MedicoDTO getId_medico() {
        return id_medico;
    }

    public void setId_medico(MedicoDTO id_medico) {
        this.id_medico = id_medico;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    
    

    
}
