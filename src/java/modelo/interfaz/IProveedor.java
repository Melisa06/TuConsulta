/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaz;

import modelo.dto.ProveedorDTO;


/**
 *
 * @author daniel
 */
public interface IProveedor {
    public ProveedorDTO create(ProveedorDTO pro) throws Exception;
    public ProveedorDTO read(ProveedorDTO pro) throws Exception;
    public ProveedorDTO update(ProveedorDTO pro) throws Exception;
    public ProveedorDTO delete(ProveedorDTO pro) throws Exception;
    
}
