/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

/**
 *
 * @author Meli
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.PacienteDTO;
import modelo.interfaz.IPaciente;
import java.sql.Date;
import modelo.dao.UsuarioDAO; 

public class PacienteDAO  implements IPaciente{
    public static PacienteDTO create(int id, String nombrePaciente, String apellidoPaterno,String apellidoMaterno, Date fechNac,double peso, String alergias,double estatura , String telPaciente,UsuarioDAO usuario , boolean  estatus){
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
private final String URL ="jdbc:postgresql://localhost:5432/TuConsulta";
private final String USR ="postgres";
private final String PDW ="admin";

   
    public PacienteDTO create(PacienteDTO pd) throws Exception {
        Connection conn = null; 
        PreparedStatement pst = null; 
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyecto1", USR,PDW);
        pst = conn.prepareStatement("INERT INTO paciente (nombre_pac, ap_pac, am_pac, fech_nac, peso, alergias,estatura,tel_pac,id_us ,estatus"
                + " )  VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
        pst.setString(1, pd.getNombrePaciente());
        pst.setString(2, pd.getApellidoPaterno());
        pst.setString(3, pd.getApellidoMaterno());
        pst.setDate(4, pd.getFechNac());
        pst.setDouble(5, pd.getPeso());
        pst.setString(6, pd.getAlergias());
        pst.setDouble(7, pd.getEstatura());
        pst.setString(8, pd.getTelPaciente());
        pst.setInt(9, pd.getIdUsuarioDTO().getId());
        pst.setBoolean(10, pd.isEstatus());
        
        int r = pst.executeUpdate();
        if(r>0){
            return pd; 
        }
        else{
        throw new Exception("Error al ingresar ");}
    }

    
    public PacienteDTO read(PacienteDTO pd) throws Exception {
        Connection conn = null ; 
        PreparedStatement pst = null;
        ResultSet rs=null;
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(URL,USR,PDW);
        pst = conn.prepareStatement("SELECT nombre_pac, ap_pac, am_pac, , fechNac, peso, alergias,estatura,tel_pac,id_us,estatus"
                + "FROM paciente WHERE nom_pac = ? , ap_pac= ?, am_pac = ?, fech_nac = ? , id_us = ?, estatus = ?");
        pst.setString(1, pd.getNombrePaciente());
        pst.setString(2, pd.getApellidoPaterno());
        pst.setString(3, pd.getApellidoMaterno());
        pst.setDate(4, pd.getFechNac());
        pst.setInt(5, pd.getIdUsuarioDTO().getId());
        pst.setBoolean(6, pd.isEstatus());
        rs =pst.executeQuery();
        
        List<PacienteDAO> entities =  new java.util.ArrayList<>();
        
        if(rs.next()){
             pd.setNombrePaciente(rs.getString("nombre_pac"));
            pd.setApellidoPaterno(rs.getString("ap_pac"));
            pd.setApellidoMaterno(rs.getString("am_pac"));
            pd.setFechNac(rs.getDate("fech_ac"));
          //pd.setIdUsuarioDTO(rs.getInt("id_us"));
            pd.setEstatus(rs.getBoolean("estatus"));
        }
        
        else{
            pd = null;
        }
        return pd;
    }
    

    
    public PacienteDTO update(PacienteDTO pd) throws Exception {
        Connection conn = null;
        PreparedStatement pst = null; 
        conn = DriverManager.getConnection(URL, USR,PDW);
        pst = conn.prepareStatement("UPDATE  paciente SET peso = ?, estatura = ?, tel_pac = ? , estatus= ? WHERE nombre_pac LIKE ?");
        pst.setDouble(1, pd.getPeso());
        pst.setDouble(2, pd.getEstatura());
        pst.setString(3, pd.getTelPaciente());
        pst.setBoolean(4, pd.isEstatus());
        
        int rs = pst.executeUpdate(); 
        if(rs > 0){
            pd = read(pd);
            return pd; 
        }
        else{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        }
    
    public List<PacienteDTO> read() throws Exception{
    List<PacienteDTO> lista = new ArrayList<>();
        PacienteDTO pd; 
        Connection conn = null; 
        PreparedStatement pst = null; 
        ResultSet rs = null; 
        conn = DriverManager.getConnection(URL, USR,PDW);
        pst = conn.prepareStatement("SELECT id, nombre_pac, ap_pac, am_pac, fech_Nac, peso , alergias, estatura, tel_pac, id_us, estatus "
                + "FROM paciente");
        rs = pst.executeQuery(); 
        while (rs.next()) {
            pd = new PacienteDTO();
            pd.setId(rs.getInt("id"));
            pd.setNombrePaciente(rs.getString("nombre_pac"));
            pd.setApellidoPaterno(rs.getString("ap_pac"));
            pd.setApellidoMaterno(rs.getString("am_pac"));
            pd.setFechNac(rs.getDate("fech_nac"));
            pd.setPeso(rs.getDouble("peso"));
            pd.setAlergias(rs.getString("alergias"));
            pd.setEstatura(rs.getDouble("estatura"));
            pd.setTelPaciente(rs.getString("tel_pac"));
          //pd.setIdUsuarioDTO(rs.getIdUsuarioDTO("id_us"));
            pd.setEstatus(rs.getBoolean("estatus"));
            
            lista.add(pd);
        }
        return lista;   
    }

   
    public PacienteDTO delete(PacienteDTO pd) throws Exception {
        Connection conn = null; 
        PreparedStatement pst = null; 
        conn = DriverManager.getConnection(URL, USR,PDW);
        
        pst = conn.prepareStatement("UPDATE paciente SET estatus = false WHERE nombre_pac = like ?%");
        pst.setString(1, pd.getNombrePaciente());
        int rs =  pst.executeUpdate(); 
        if (rs > 0 ) {
            pd = read(pd); 
            return pd; 
        }
        else{
        throw new Exception("error al eliminar"); //To change body of generated methods, choose Tools | Templates.
        }
        }
    
    public PacienteDTO buscarId(PacienteDTO pd) throws Exception {
        Connection conn = null ; 
        PreparedStatement pst = null;
        ResultSet rs=null;
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(URL,USR,PDW);
        pst = conn.prepareStatement("SELECT * from paciente where id_us = ?");
        pst.setInt(1, pd.getIdUsuarioDTO().getId());
        rs =pst.executeQuery();

        if(rs.next()){
            pd.setId(rs.getInt("id"));
        }
        
        else{
            pd = null;
        }
        return pd;
    }
}
