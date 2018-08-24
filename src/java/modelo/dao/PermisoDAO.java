package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.PermisoDTO;
import modelo.interfaz.IPermiso;
import modelo.negocio.RolBusiness;

/**
 *
 * @author Ricardo Camacho
 */
public class PermisoDAO implements IPermiso{

    String URL = "jdbc:postgresql://localhost:5432/TuConsulta";
    String USER = "postgres";
    String PASSWORD = "admin";

    public Connection con = null;
    public PreparedStatement pst = null;
    
    @Override
    public PermisoDTO create(PermisoDTO permiso) throws Exception {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        pst = con.prepareStatement("INSERT INTO permisos(id_rol, id_usuario, estatus, usuarios, medicos, pacientes, citas, recetas, medicamentos, venta, proveedores, sucursales, almacen, compra, estatus) " +
                                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, true)");
        pst.setInt(1, permiso.getIdRol().getId());
        pst.setInt(2, permiso.getIdUsuario());
        pst.setBoolean(3, permiso.isEstatus());
        pst.setInt(4, permiso.getUsuarios());
        pst.setInt(5, permiso.getMedicos());
        pst.setInt(6, permiso.getPacientes());
        pst.setInt(7, permiso.getCitas());
        pst.setInt(8, permiso.getRecetas());
        pst.setInt(9, permiso.getMedicamentos());
        pst.setInt(10, permiso.getVenta());
        pst.setInt(11, permiso.getProveedores());
        pst.setInt(12, permiso.getSucursales());
        pst.setInt(13, permiso.getAlmacen());
        pst.setInt(14, permiso.getCompra());
        int r = pst.executeUpdate();

        if(r > 0)
            return permiso;
        else{
            permiso = null;
            return permiso;
        }
            
    }

    @Override
    public PermisoDTO read(PermisoDTO permiso) throws Exception {
        Class.forName("org.postgresql.Driver");
        ResultSet rs = null;
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        pst = con.prepareStatement("SELECT *FROM permisos WHERE id_usuario = ?");
        pst.setInt(1, permiso.getIdUsuario());
        rs = pst.executeQuery();

        if(rs.next()){
            permiso.setId(rs.getInt("id"));
            permiso.setIdRol(RolBusiness.buscar(rs.getInt("id_rol")));
            permiso.setEstatus(rs.getBoolean("estatus"));
            permiso.setUsuarios(rs.getInt("usuarios"));
            permiso.setMedicos(rs.getInt("medicos"));
            permiso.setPacientes(rs.getInt("pacientes"));
            permiso.setCitas(rs.getInt("citas"));
            permiso.setRecetas(rs.getInt("recetas"));
            permiso.setMedicamentos(rs.getInt("medicamentos"));
            permiso.setVenta(rs.getInt("venta"));
            permiso.setProveedores(rs.getInt("proveedores"));
            permiso.setSucursales(rs.getInt("sucursales"));
            permiso.setAlmacen(rs.getInt("almacen"));
            permiso.setCompra(rs.getInt("compra"));
            return permiso;
        }
        else
            throw new Exception("No existe");
    }

    public List<PermisoDTO> readAll() throws Exception{
        List<PermisoDTO> list = new ArrayList<>();
        Class.forName("org.postgresql.Driver");
        ResultSet rs = null;
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        pst = con.prepareStatement("SELECT *FROM permisos");
        rs = pst.executeQuery();

        while(rs.next()){
            PermisoDTO permiso = new PermisoDTO();
            permiso.setId(rs.getInt("id"));
            permiso.setEstatus(rs.getBoolean("estatus"));
            list.add(permiso);
        }
        return list;
    }
    
    public List<PermisoDTO> PermisosRol(int id) throws Exception{
        List<PermisoDTO> list = new ArrayList<>();
        Class.forName("org.postgresql.Driver");
        ResultSet rs = null;
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        pst = con.prepareStatement("SELECT *FROM permisos WHERE id IN(SELECT id_permiso FROM rol_permiso WHERE id_rol = ?)");
        pst.setInt(1, id);
        rs = pst.executeQuery();

        while(rs.next()){
            PermisoDTO permiso = new PermisoDTO();
            permiso.setId(rs.getInt("id"));
            permiso.setEstatus(rs.getBoolean("estatus"));
            list.add(permiso);
        }
        return list;
    }

    @Override
    public PermisoDTO update(PermisoDTO permiso) throws Exception {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        pst = con.prepareStatement(
                "UPDATE permisos SET "
                + "id_rol = ?, "
                + "usuarios = ?, "
                + "medicos = ?, "
                + "pacientes = ?, "
                + "citas = ?, "
                + "recetas = ?, "
                + "medicamentos = ?, "
                + "venta = ?, "
                + "proveedores = ?, "
                + "sucursales = ?, "
                + "almacen = ?, "
                + "compra = ? WHERE id_usuario = ?");
        
        pst.setInt(1, permiso.getIdRol().getId());
        pst.setInt(2, permiso.getUsuarios());
        pst.setInt(3, permiso.getMedicos());
        pst.setInt(4, permiso.getPacientes());
        pst.setInt(5, permiso.getCitas());
        pst.setInt(6, permiso.getRecetas());
        pst.setInt(7, permiso.getMedicamentos());
        pst.setInt(8, permiso.getVenta());
        pst.setInt(9, permiso.getProveedores());
        pst.setInt(10, permiso.getSucursales());
        pst.setInt(11, permiso.getAlmacen());
        pst.setInt(12, permiso.getCompra());
        pst.setInt(13, permiso.getIdUsuario());
        int r = pst.executeUpdate();

        if(r > 0){
                return permiso;
        }
        else
            throw new Exception("No insertado");
    }

    @Override
    public PermisoDTO delete(PermisoDTO permiso) throws Exception {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD); 
        pst = con.prepareStatement("UPDATE permisos SET estatus = ? WHERE id = ?");
        pst.setBoolean(1, permiso.isEstatus());
        pst.setInt(2, permiso.getId());
        int r = pst.executeUpdate();

        if(r > 0){
                return permiso;
        }
        else
            throw new Exception("No insertado");
    }

}
