/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaz;

import modelo.dto.MedicamentoDTO;

/**
 *
 * @author Jhazmin Alvarez
 */
public interface IMedicamento {
      public MedicamentoDTO create(MedicamentoDTO NombreMedicamento) throws Exception;
    public MedicamentoDTO read(MedicamentoDTO NombreMedicamento) throws Exception;
    public MedicamentoDTO update(MedicamentoDTO NombreMedicamento) throws Exception;
    public MedicamentoDTO delete(MedicamentoDTO NombreMedicamento) throws Exception;
    
}
