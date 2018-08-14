/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaz;

import java.sql.Connection;
import modelo.dto.MedicoDTO;

/**
 *
 * @author lupita
 */
public interface IMedico {
    public MedicoDTO create(MedicoDTO medico,Connection con) throws Exception;
    public MedicoDTO create(MedicoDTO medico) throws Exception;
    public MedicoDTO read(MedicoDTO medico) throws Exception;
    public MedicoDTO update(MedicoDTO medico) throws Exception;
    public MedicoDTO delete(MedicoDTO medico) throws Exception;
    
}
