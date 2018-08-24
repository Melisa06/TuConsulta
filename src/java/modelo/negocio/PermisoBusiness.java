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
            dto = null;
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

    public static PermisoDTO actualizar(PermisoDTO dto){
        PermisoDAO dao = new PermisoDAO();
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
    
    public PermisoDTO getTipoUsuario(int id){
        
        /**
         * 3 SIN ACCESO
         * 2 LECTURA
         * 1 EDITAR
         */
        
        PermisoDTO dto = new PermisoDTO();
        
        if(id == 1){
            dto.setUsuarios(1);
            dto.setMedicos(1);
            dto.setPacientes(1);
            dto.setCitas(1);
            dto.setRecetas(1);
            dto.setMedicamentos(1);
            dto.setVenta(1);
            dto.setProveedores(1);
            dto.setSucursales(1);
            dto.setAlmacen(1);
            dto.setCompra(1);
        }
        else if(id == 2){
            dto.setUsuarios(2);
            dto.setMedicos(2);
            dto.setPacientes(1);
            dto.setCitas(1);
            dto.setRecetas(1);
            dto.setMedicamentos(1);
            dto.setVenta(1);
            dto.setProveedores(3);
            dto.setSucursales(3);
            dto.setAlmacen(2);
            dto.setCompra(2);
        }
        else if(id == 3){
          dto.setUsuarios(3);
            dto.setMedicos(3);
            dto.setPacientes(3);
            dto.setCitas(2);
            dto.setRecetas(2);
            dto.setMedicamentos(2);
            dto.setVenta(2);
            dto.setProveedores(3);
            dto.setSucursales(3);
            dto.setAlmacen(3);
            dto.setCompra(3);  
        }
        return dto;
    }
}
