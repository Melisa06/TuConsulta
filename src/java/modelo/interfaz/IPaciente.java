/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

/**
 *
 * @author Meli
 */
import java.util.List;
import modelo.dto.PacienteDTO;
public interface IPaciente {
    
    public PacienteDTO create (PacienteDTO pd)
            throws Exception;
    
    public PacienteDTO read (PacienteDTO pd)
            throws Exception;
    
    public PacienteDTO update (PacienteDTO pd)
            throws Exception;
    
    public PacienteDTO delete (PacienteDTO pd)
            throws Exception;
}
