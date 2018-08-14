/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaz;

import modelo.dto.RecetaDTO;

/**
 *
 * @author Morales
 */
public interface Ireceta {
    
    public RecetaDTO create(RecetaDTO receta) throws Exception;
    public RecetaDTO read(RecetaDTO receta) throws Exception;
    
}
