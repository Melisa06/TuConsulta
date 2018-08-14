package modelo.interfaz;

import modelo.dto.PermisoDTO;

/**
 *
 * @author Ricardo Camacho
 */
public interface IPermiso {
    public PermisoDTO create(PermisoDTO permiso) throws Exception;
    public PermisoDTO read (PermisoDTO permiso) throws Exception;
    public PermisoDTO update (PermisoDTO permiso) throws Exception;
    public PermisoDTO delete (PermisoDTO permiso) throws Exception;
}
