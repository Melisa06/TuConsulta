package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.RolDTO;
import modelo.interfaz.IRol;
/**
 *
 * @author Ricardo Camacho
 */
public class RolDAO implements IRol{

    String URL = "jdbc:postgresql://localhost:5432/TuConsulta";
    String USER = "postgres";
    String PASSWORD = "admin";

    public Connection con = null;
    public PreparedStatement pst = null;
    
    @Override
    public RolDTO create(RolDTO rol) throws Exception {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        pst = con.prepareStatement("INSERT INTO roles (nombre_rol,  estatus) VALUES (?,?)");
        pst.setString(1, rol.getNombreRol());
        pst.setBoolean(2, rol.isEstatus());
        int r = pst.executeUpdate();

        if(r > 0){
                return rol;
        }
        else
            throw new Exception("No insertado");
    }

    @Override
    public RolDTO read(RolDTO rol) throws Exception {
        Class.forName("org.postgresql.Driver");
        ResultSet rs = null;
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        pst = con.prepareStatement("SELECT *FROM roles WHERE id = ?");
        pst.setInt(1, rol.getId());
        rs = pst.executeQuery();

        if(rs.next()){
            rol.setNombreRol(rs.getString("nombre_rol"));
            rol.setEstatus(rs.getBoolean("estatus"));
            return rol;
        }
        else
            throw new Exception("No existe");
    }

    public List<RolDTO> readAll() throws Exception {
        List<RolDTO> list = new ArrayList<>();
        Class.forName("org.postgresql.Driver");
        ResultSet rs = null;
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        pst = con.prepareStatement("SELECT *FROM roles");
        rs = pst.executeQuery();

        while(rs.next()){
            RolDTO rol = new RolDTO();
            rol.setId(rs.getInt("id"));
            rol.setNombreRol(rs.getString("nombre_rol"));
            rol.setEstatus(rs.getBoolean("estatus"));
            list.add(rol);
        }
        return list;
    }

    @Override
    public RolDTO update(RolDTO rol) throws Exception {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);   
        pst = con.prepareStatement("UPDATE roles SET nombre_rol = ? WHERE id = ?");
        pst.setString(1, rol.getNombreRol());
        pst.setInt(2, rol.getId());
        int r = pst.executeUpdate();

        if(r > 0){
                return rol;
        }
        else
            throw new Exception("No insertado");
    }

    @Override
    public RolDTO delete(RolDTO rol) throws Exception {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);  
        pst = con.prepareStatement("UPDATE roles SET estatus = ? WHERE id = ?");
        pst.setBoolean(1, rol.isEstatus());
        pst.setInt(2, rol.getId());
        int r = pst.executeUpdate();

        if(r > 0){
                return rol;
        }
        else
            throw new Exception("No insertado");
    }

}
