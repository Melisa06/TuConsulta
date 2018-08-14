package modelo.interfaz;

import modelo.dto.UsuarioDTO;

/**
 *
 * @author Ricardo Camacho
 */
public interface IUsuario {
    public UsuarioDTO create(UsuarioDTO usuario) throws Exception;
    public UsuarioDTO read (UsuarioDTO usuario) throws Exception;
    public UsuarioDTO update (UsuarioDTO usuario) throws Exception;
    public UsuarioDTO delete (UsuarioDTO usuario) throws Exception;
	
}
