package modelo.negocio;

import java.util.List;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.UsuarioDAO;

import modelo.dto.UsuarioDTO;

/**
 *
 * @author Ricardo Camacho
 */
public class UsuarioBusiness {

    public static UsuarioDTO crear(String email, String password, Date fechaIngreso, boolean estatus){
        UsuarioDTO dto = new UsuarioDTO();
        UsuarioDAO dao = new UsuarioDAO();
        dto.setEmail(email);
        dto.setPassword(password);
        dto.setFechaIngreso(fechaIngreso);
        dto.setEstatus(estatus);

        try{
            dto = dao.create(dto);
        }
        catch(Exception ex){
            Logger.getLogger(UsuarioBusiness.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
        return dto;
    }

    public static UsuarioDTO buscar(int id){
        UsuarioDTO dto = new UsuarioDTO();
        UsuarioDAO dao = new UsuarioDAO();
        dto.setId(id);

        try{
            dto = dao.read(dto);
        }
        catch(Exception ex){
            Logger.getLogger(UsuarioBusiness.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
         return dto;
    }

    public static List<UsuarioDTO> buscar(){
        UsuarioDAO dao = new UsuarioDAO();
        List<UsuarioDTO> list = new ArrayList<>();

        try{
            list = dao.readAll();
        }
        catch(Exception ex){
            Logger.getLogger(RolBusiness.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
        return list;
    }

    public static UsuarioDTO actualizar(String email, String password, Date fechaIngreso, boolean estatus){
        UsuarioDTO dto = new UsuarioDTO();
        UsuarioDAO dao = new UsuarioDAO();
        dto.setEmail(email);
        dto.setPassword(password);
        dto.setFechaIngreso(fechaIngreso);
        dto.setEstatus(estatus);

        try{
            dto = dao.update(dto);
        }
        catch(Exception ex){
            Logger.getLogger(UsuarioBusiness.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
        return dto;
    }

    public static UsuarioDTO borrar(int id){
        UsuarioDTO dto = new UsuarioDTO();
        UsuarioDAO dao = new UsuarioDAO();
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

    public static UsuarioDTO activar(int id){
        UsuarioDTO dto = new UsuarioDTO();
        UsuarioDAO dao = new UsuarioDAO();
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
    
    public static UsuarioDTO verificar(String email){
        UsuarioDTO dto = new UsuarioDTO();
        UsuarioDAO dao = new UsuarioDAO();
        dto.setEmail(email);

        try{
            dto = dao.verificar(dto);
        }
        catch(Exception ex){
            Logger.getLogger(UsuarioBusiness.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error " + ex.getMessage());
        }
         return dto;
    }

    public static String getMD5(String input){
    try {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());
        BigInteger number = new BigInteger(1, messageDigest);
        String hashtext = number.toString(16);

        while(hashtext.length() < 32){
            hashtext = "0"+ hashtext;
        }
        return hashtext;

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
