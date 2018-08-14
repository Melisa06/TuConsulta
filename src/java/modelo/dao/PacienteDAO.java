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
import interfaz.IPaciente;
import java.sql.Date;

public class PacienteDAO  implements IPaciente{
    public static PacienteDTO create(int id, String nombrePaciente, String apellidoPaterno,String apellidoMaterno, Date fechNac,double peso, String alergias,double estatura , String telPaciente, boolean  estatus){
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
private final String URL ="jdbc:postgresql://localhost:5432/postgres";
private final String USR ="postgres";
private final String PDW ="admin";

    @Override
    public PacienteDTO create(PacienteDTO pd) throws Exception {
        Connection conn = null; 
        PreparedStatement pst = null; 
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyecto1", USR,PDW);
        pst = conn.prepareStatement("INERT INTO paciente (nombrePaciente, apellidoPterno, apellidoMaterno, fechNac, peso, alergias,estatura,telPaciente, estatus"
                + " )  VALUES (?,?,?,?,?,?,?,?,?,?,?)");
        pst.setString(1, pd.getNombrePaciente());
        pst.setString(2, pd.getApellidoPaterno());
        pst.setString(3, pd.getApellidoMaterno());
        pst.setDate(4, pd.getFechNac());
        pst.setDouble(5, pd.getPeso());
        pst.setString(6, pd.getAlergias());
        pst.setDouble(7, pd.getEstatura());
        pst.setString(8, pd.getTelPaciente());
        pst.setBoolean(9, pd.isEstatus());
        
        int r = pst.executeUpdate();
        if(r>0){
            return pd; 
        }
        else{
        throw new Exception("Error al ingresar ");}
    }

    @Override
    public PacienteDTO read(PacienteDTO pd) throws Exception {
        Connection conn = null ; 
        PreparedStatement pst = null;
        ResultSet rs=null;
        Class.forName("org.postgresql.Driver");
        conn = DriverManager.getConnection(URL,USR,PDW);
        pst = conn.prepareStatement("SELECT nombrePaciente, apellidoPaterno, apellidoMaterno,nombrePaciente, apellidoPterno, apellidoMaterno, fechNac, peso, alergias,estatura,telPaciente, estatus"
                + "FROM paciente WHERE nombrePaciente = ? , apellidoPaterno= ?, apellidoMaterno = ?, fechNac = ? , estatus = ?");
        pst.setString(1, pd.getNombrePaciente());
        pst.setString(2, pd.getApellidoPaterno());
        pst.setString(3, pd.getApellidoMaterno());
        pst.setDate(4, pd.getFechNac());
        pst.setBoolean(5, pd.isEstatus());
        rs =pst.executeQuery();
        
        List<PacienteDAO> entities =  new java.util.ArrayList<>();
        
        if(rs.next()){
            pd.setNombrePaciente(rs.getString("nombrePaciente"));
            pd.setApellidoPaterno(rs.getString("apellidoPaterno"));
            pd.setApellidoMaterno(rs.getString("ApellidoMaterno"));
            pd.setFechNac(rs.getDate("fechNac"));
            pd.setEstatus(rs.getBoolean("estatus"));
        }
        
        else{
            pd = null;
        }
        return pd;
            }
    

    @Override
    public PacienteDTO update(PacienteDTO pd) throws Exception {
        Connection conn = null;
        PreparedStatement pst = null; 
        conn = DriverManager.getConnection(URL, USR,PDW);
        pst = conn.prepareStatement("UPDATE  paciente SET peso = ?, estatura = ?, telPAciente = ? , estatus= ? WHERE nombrePaciente LIKE ?");
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
        pst = conn.prepareStatement("SELECT nombrePaciente, apellidoPaterno, apellidoMaterno, fechNac, peso , alergias, estatura, telPaciente, estatus"
                + "FROM paciente");
        rs = pst.executeQuery(); 
        while (rs.next()) {
            pd = new PacienteDTO();
            pd.setNombrePaciente(rs.getString("nombrePaciente"));
            pd.setApellidoPaterno(rs.getString("apellidoPaterno"));
            pd.setApellidoMaterno(rs.getString("apellidoMaterno"));
            pd.setFechNac(rs.getDate("fechNac"));
            pd.setPeso(rs.getDouble("peso"));
            pd.setAlergias(rs.getString("alergias"));
            pd.setEstatura(rs.getDouble("estatura"));
            pd.setTelPaciente(rs.getString("telPaciente"));
            pd.setEstatus(rs.getBoolean("eststus"));
            lista.add(pd);
        }
        return lista;   
    }

    @Override
    public PacienteDTO delete(PacienteDTO pd) throws Exception {
        Connection conn = null; 
        PreparedStatement pst = null; 
        conn = DriverManager.getConnection(URL, USR,PDW);
        
        pst = conn.prepareStatement("UPDATE paciente SET estatus = false WHERE nombrePaciente = like ?%");
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
    
    
}
