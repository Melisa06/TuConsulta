package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.dto.UsuarioDTO;
import modelo.interfaz.IUsuario;
/**
 *
 * @author Ricardo Camacho
 */
public class UsuarioDAO implements IUsuario{
  
    String URL = "jdbc:postgresql://localhost:5432/TuConsulta";
    String USER = "postgres";
    String PASSWORD = "admin";

    public Connection con = null;
    public PreparedStatement pst = null;

    @Override
    public UsuarioDTO create(UsuarioDTO usuario) throws Exception {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        pst = con.prepareStatement("INSERT INTO Usuarios (email, password, fecha_ingreso, estatus) VALUES (?,MD5(?),NOW(),?)", Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, usuario.getEmail());
        pst.setString(2, usuario.getPassword());
        pst.setBoolean(3, usuario.isEstatus());
        int r = pst.executeUpdate();

        if(r > 0){
            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next())
                usuario.setId(rs.getInt(1));
            
            return usuario;
        }
        else
            throw new Exception("No insertado");
    }

    @Override
    public UsuarioDTO read(UsuarioDTO usuario) throws Exception {
        Class.forName("org.postgresql.Driver");
        ResultSet rs = null;
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        pst = con.prepareStatement("SELECT *FROM Usuarios WHERE id = ?");
        pst.setInt(1, usuario.getId());
        rs = pst.executeQuery();

        if(rs.next()){
            usuario.setEmail(rs.getString("email"));
            usuario.setPassword(rs.getString("password"));
            usuario.setFechaIngreso(rs.getDate("fecha_ingreso"));
            usuario.setEstatus(rs.getBoolean("estatus"));
            return usuario;
        }
        else
            throw new Exception("No existe");
    }

    public List<UsuarioDTO> readAll() throws Exception{
        Class.forName("org.postgresql.Driver");
        ResultSet rs = null;
        List<UsuarioDTO> listUsuarioDto = new ArrayList<>();
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        pst = con.prepareStatement("SELECT *FROM Usuarios");
        rs = pst.executeQuery();

        while(rs.next()){
            UsuarioDTO usuario = new UsuarioDTO();
            usuario.setEmail(rs.getString("email"));
            usuario.setPassword(rs.getString("password"));
            usuario.setFechaIngreso(rs.getDate("fecha_ingreso"));
            usuario.setEstatus(rs.getBoolean("estatus"));
            listUsuarioDto.add(usuario);
        }
        return listUsuarioDto;
    }

    @Override
    public UsuarioDTO update(UsuarioDTO usuario) throws Exception {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        pst = con.prepareStatement("UPDATE usuarios SET password = ?, estatus = ?, id_rol = ? WHERE id = ?");
        pst.setString(1, usuario.getPassword());
        pst.setBoolean(2, usuario.isEstatus());
        pst.setInt(4, usuario.getId());

        int r = pst.executeUpdate();

        if(r > 0){
            return usuario;
        }
        else
            throw new Exception("No actualizado");
    }

    @Override
    public UsuarioDTO delete(UsuarioDTO usuario) throws Exception {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        pst = con.prepareStatement("UPDATE usuarios SET estatus = ? WHERE id = ?");
        pst.setBoolean(1, usuario.isEstatus());
        pst.setInt(2, usuario.getId());

        int r = pst.executeUpdate();
        if(r > 0){
            return usuario;
        }
        else
            throw new Exception("No actualizado");
    }
    
    public UsuarioDTO verificar(UsuarioDTO usuario) throws Exception {
        Class.forName("org.postgresql.Driver");
        ResultSet rs = null;
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        pst = con.prepareStatement("SELECT *FROM Usuarios WHERE email = ? AND estatus = true");
        pst.setString(1, usuario.getEmail());
        rs = pst.executeQuery();

        if(rs.next()){
            usuario.setId(rs.getInt("id"));
            usuario.setEmail(rs.getString("email"));
            usuario.setPassword(rs.getString("password"));
            usuario.setFechaIngreso(rs.getDate("fecha_ingreso"));
            usuario.setEstatus(rs.getBoolean("estatus"));
            return usuario;
        }
        else{
            return null;
            //throw new Exception("No existe");
        }
            
    }

}
