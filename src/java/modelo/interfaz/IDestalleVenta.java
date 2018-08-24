/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.interfaz;

import modelo.dto.DetalleVentDTO;
/**
 *
 * @author daniel
 */
public interface IDestalleVenta {
    public DetalleVentDTO create(DetalleVentDTO det) throws Exception;
    public DetalleVentDTO read(DetalleVentDTO det) throws Exception;
    public DetalleVentDTO createDetalle(DetalleVentDTO venta) throws Exception;
    
}
