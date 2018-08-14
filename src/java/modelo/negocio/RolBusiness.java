package modelo.negocio;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.RolDAO;

import modelo.dto.RolDTO;

/**
 *
 * @author Ricardo Camacho
 */
public class RolBusiness {

    public static RolDTO crear(String nombre, boolean estatus){
        RolDTO dto = new RolDTO();
        RolDAO dao = new RolDAO();
        dto.setNombreRol(nombre);
        dto.setEstatus(estatus);

        try{
            dto = dao.create(dto);
        }
        catch(Exception ex){
            Logger.getLogger(RolBusiness.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
         return dto;
    }

    public static RolDTO buscar(int id){
        RolDTO dto = new RolDTO();
        RolDAO dao = new RolDAO();
        dto.setId(id);

        try{
            dto = dao.read(dto);
        }
        catch(Exception ex){
            Logger.getLogger(RolBusiness.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
         return dto;
    }

    public static List<RolDTO> buscar(){
        RolDAO dao = new RolDAO();
        List<RolDTO> list = new ArrayList<>();
        
        try{
            list = dao.readAll();
        }
        catch(Exception ex){
            Logger.getLogger(RolBusiness.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
        return list;
    }

    public static RolDTO actualizar(String nombre, boolean estatus, int id){
        RolDTO dto = new RolDTO();
        RolDAO dao = new RolDAO();
        dto.setNombreRol(nombre);
        dto.setEstatus(estatus);

        try{
            dto = dao.update(dto);
        }
        catch(Exception ex){
            Logger.getLogger(RolBusiness.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
         return dto;
    }

    public static RolDTO borrar(int id){
        RolDTO dto = new RolDTO();
        RolDAO dao = new RolDAO();
        dto.setId(id);
        dto.setEstatus(false);
        try{
           dto = dao.delete(dto);
        }
        catch(Exception ex){
            Logger.getLogger(RolBusiness.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
        return dto;
    }

    public static RolDTO activar(int id){
        RolDTO dto = new RolDTO();
        RolDAO dao = new RolDAO();
        dto.setId(id);
        dto.setEstatus(true);
        try{
           dto = dao.delete(dto);
        }
        catch(Exception ex){
            Logger.getLogger(RolBusiness.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
        return dto;
    }
	
}
