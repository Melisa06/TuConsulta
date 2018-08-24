/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.dto.CitaDTO;
import modelo.dto.MedicoDTO;
import modelo.dto.PacienteDTO;
import modelo.interfaz.ICita;

/**
 *
 * @author Windows
 */
public class CitaDAO implements ICita {

    String URL = "jdbc:postgresql://localhost:5432/TuConsulta";
    String USER = "postgres";
    String PASSWORD = "admin";

    public Connection con = null;
    public PreparedStatement pst = null;

    @Override
    public CitaDTO create(CitaDTO cita) throws Exception {

        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = formatter.parse(cita.getFechacita());
        java.sql.Date fechaCita = new java.sql.Date(date.getTime());   
        
        pst = con.prepareStatement("INSERT INTO cita (fechacita,hr_cita,id_paciente,id_medico,estatus) values (?,?,?,?,?)");
        pst.setDate(1, fechaCita);
        pst.setString(2, cita.getHr_cita());
        pst.setInt(3, cita.getId_paciente().getId());
        pst.setInt(4, cita.getId_medico().getId());
        pst.setBoolean(5, cita.isEstatus());

        int result = pst.executeUpdate();

        if (result > 0) {

            return cita;
        }

        throw new Exception("No encontrado");

    }

    @Override
    public CitaDTO read(CitaDTO cita) throws Exception {

        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);

        pst = con.prepareStatement("select id,fechacita,hr_cita,id_paciente,id_medico,estatus" + "From cita Where id like ?");

        pst.setInt(1, cita.getId());

        ResultSet result = pst.executeQuery();

        if (result.next()) {

            cita.setId(result.getInt("id"));
            cita.setFechacita(result.getString("fechacita"));
            cita.setHr_cita(result.getString("hr_cita"));
            cita.setId_paciente(new PacienteDTO(result.getInt("id_paciente")));
            cita.setId_medico(new MedicoDTO(result.getInt("id_medico")));
            cita.setEstatus(result.getBoolean("estatus"));

            return cita;
        }

        throw new Exception("No encontrado");

    }

    public List<CitaDTO> read() throws Exception {

        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);

        List<CitaDTO> ids = new ArrayList<>();

        pst = con.prepareStatement("select id,fechacita,hr_cita,id_paciente,id_medico,estatus " + "From cita");

        ResultSet result = pst.executeQuery();

        while (result.next()) {

            CitaDTO dto = new CitaDTO();

            dto.setId(result.getInt("id"));
            dto.setFechacita(result.getString("fechacita"));
            dto.setHr_cita(result.getString("hr_cita"));
            dto.setId_paciente(new PacienteDTO(result.getInt("id_paciente")));
            dto.setId_medico(new MedicoDTO(result.getInt("id_medico")));
            dto.setEstatus(result.getBoolean("estatus"));
            
           

            ids.add(dto);

        }

        return ids;
    }

    @Override
    public CitaDTO update(CitaDTO cita) throws Exception {

        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);

        pst = con.prepareStatement("UPDATE cita set fechacita = (?),hr_cita = ? ,id_medico = ?,estatus = ? WHERE id like ?");

        pst.setString(1, cita.getFechacita());
        pst.setString(2, cita.getHr_cita());
        pst.setInt(3, cita.getId_medico().getId());
        pst.setBoolean(4, cita.isEstatus());
        pst.setInt(5, cita.getId());

        int result = pst.executeUpdate();

        if (result > 0) {

            return cita;
        }

        throw new Exception("No encontrado");
    }

    @Override
    public CitaDTO delete(CitaDTO cita) throws Exception {

        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);

        pst = con.prepareStatement("UPDATE cita set estatus = false WHERE id like ?");

        pst.setInt(1, cita.getId());

        int result = pst.executeUpdate();

        if (result > 0) {

            return cita;
        }

        throw new Exception("No encontrado");
    }
    
    public boolean consultaExistencia(String fechacita,String hr_cita,int id_paciente, int id_medico){
    
    try{
    
    Class.forName("org.postgresql.Driver");
    con = DriverManager.getConnection(URL, USER, PASSWORD);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = formatter.parse(fechacita);
        java.sql.Date fechaCita = new java.sql.Date(date.getTime());  
        
    pst = con.prepareStatement("Select * from cita where fechacita = ? and hr_cita = ? and id_paciente = ? and id_medico = ?");
    pst.setDate(1, fechaCita);
    pst.setString(2, hr_cita);
    pst.setInt(3, id_paciente);
    pst.setInt(4, id_medico);
    
     ResultSet result;
     result= pst.executeQuery();
     
     if(result.next()){
            return false;
    }
     else{
         return true;
     }
         
    }
    catch (Exception ex)
    {
     return false;
    }
    }

}
