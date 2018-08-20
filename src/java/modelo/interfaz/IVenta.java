/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaz;

import modelo.dto.VentaDTO;

/**
 *
 * @author daniel
 */
public interface IVenta {
    public VentaDTO create(VentaDTO vent) throws Exception;
    public VentaDTO read(VentaDTO vent) throws Exception;
    public VentaDTO update(VentaDTO vent) throws Exception;
    public VentaDTO delete(VentaDTO vent) throws Exception;
}
