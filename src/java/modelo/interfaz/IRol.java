package modelo.interfaz;

import modelo.dto.RolDTO;

/**
 *
 * @author Ricardo Camacho
 */
public interface IRol {
    public RolDTO create(RolDTO rol) throws Exception;
    public RolDTO read (RolDTO rol) throws Exception;
    public RolDTO update (RolDTO rol) throws Exception;
    public RolDTO delete (RolDTO rol) throws Exception;
}
