/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaz;

import modelo.dto.CitaDTO;

/**
 *
 * @author Windows
 */
public interface ICita {
    
    public CitaDTO create(CitaDTO cita) throws Exception;
    public CitaDTO read(CitaDTO cita) throws Exception;
    public CitaDTO update(CitaDTO cita) throws Exception;
    public CitaDTO delete(CitaDTO cita) throws Exception;
    
}
