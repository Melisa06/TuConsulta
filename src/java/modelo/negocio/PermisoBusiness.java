package modelo.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.PermisoDAO;

import modelo.dto.PermisoDTO;

/**
 *
 * @author Ricardo Camacho
 */
public class PermisoBusiness {
	
    public static PermisoDTO crear(PermisoDTO dto){
        PermisoDAO dao = new PermisoDAO();

        try{
            dto = dao.create(dto);
        }
        catch(Exception ex){
            Logger.getLogger(PermisoBusiness.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
         return dto;
    }
	
    public static PermisoDTO buscar(int idUsuario){
        PermisoDTO dto = new PermisoDTO();
        PermisoDAO dao = new PermisoDAO();
        dto.setIdUsuario(idUsuario);
        try{
           dto = dao.read(dto);
        }
        catch(Exception ex){
            Logger.getLogger(PermisoBusiness.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
        return dto;
    }

    public static List<PermisoDTO> buscar(){
        PermisoDAO dao = new PermisoDAO();
        List<PermisoDTO> list = new ArrayList<>();
        
        try{
            list = dao.readAll();
        }
        catch(Exception ex){
            Logger.getLogger(PermisoBusiness.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
        return list;
    }

    public static PermisoDTO actualizar(String nombre, boolean estatus, int id){
        PermisoDTO dto = new PermisoDTO();
        PermisoDAO dao = new PermisoDAO();
        dto.setId(id);
        dto.setEstatus(estatus);
        try{
           dto = dao.update(dto);
        }
        catch(Exception ex){
            Logger.getLogger(PermisoBusiness.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
        return dto;
    }

    public static PermisoDTO borrar(int id){
        PermisoDTO dto = new PermisoDTO();
        PermisoDAO dao = new PermisoDAO();
        dto.setId(id);
        dto.setEstatus(false);
        try{
           dto = dao.delete(dto);
        }
        catch(Exception ex){
            Logger.getLogger(PermisoBusiness.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
        return dto;
    }

    public static PermisoDTO activar(int id){
        PermisoDTO dto = new PermisoDTO();
        PermisoDAO dao = new PermisoDAO();
        dto.setId(id);
        dto.setEstatus(true);
        try{
           dto = dao.delete(dto);
        }
        catch(Exception ex){
            Logger.getLogger(PermisoBusiness.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
        return dto;
    }
}
