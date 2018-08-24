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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.MedicoDTO;
import modelo.interfaz.IMedico;

/**
 *
 * @author lupita
 */
public class MedicoDAO implements IMedico{
      
    String URL = "jdbc:postgresql://localhost:5432/TuConsulta";
    String USER = "postgres";
    String PASSWORD = "admin";

    public Connection con = null;
    public PreparedStatement pst = null;

    
    public MedicoDTO create(MedicoDTO medico) throws Exception {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        pst = con.prepareStatement("INSERT INTO medico (nombre_med,ap_med,am_med,cedula_med,estatus) VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        pst.setString(1, medico.getNombre());
        pst.setString(2, medico.getPaterno());
        pst.setString(3, medico.getMaterno());
        pst.setString(4, medico.getCedula());
        pst.setBoolean(5, medico.isEstatus());
        int r = pst.executeUpdate();

        if(r > 0){
            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next())
                medico.setId(rs.getInt(1));
            
            return medico;
        }
        else
            throw new Exception("No insertado");
    }

    
    public MedicoDTO read(MedicoDTO medico) throws Exception {
        Class.forName("org.postgresql.Driver");
        ResultSet rs = null;
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        pst = con.prepareStatement("SELECT *FROM medico WHERE id = ?");
        pst.setInt(1, medico.getId());
        rs = pst.executeQuery();

        if(rs.next()){
            medico.setNombre(rs.getString("nombre_med"));
            medico.setPaterno(rs.getString("ap_med"));
            medico.setMaterno(rs.getString("am_med"));
            medico.setCedula(rs.getString("cedula_med"));
            medico.setEstatus(rs.getBoolean("estatus"));
            return medico;
        }
        else
            throw new Exception("No existe");
    }
    
    public MedicoDTO buscarId(MedicoDTO medico) throws Exception {
        Class.forName("org.postgresql.Driver");
        ResultSet rs = null;
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        pst = con.prepareStatement("SELECT *FROM medico WHERE id_usuario = ?");
        pst.setInt(1, medico.getIdUsuario().getId());
        rs = pst.executeQuery();

        if(rs.next()){
            medico.setId(rs.getInt("id"));
            return medico;
        }
        else
            throw new Exception("No existe");
    }

    public List<MedicoDTO> readAll() throws Exception{
        Class.forName("org.postgresql.Driver");
        ResultSet rs = null;
        List<MedicoDTO> listMedicoDto = new ArrayList<>();
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        pst = con.prepareStatement("SELECT *FROM medico");
        rs = pst.executeQuery();

        while(rs.next()){
            MedicoDTO medico = new MedicoDTO();
            medico.setId(rs.getInt("id"));
            medico.setNombre(rs.getString("nombre_med"));
            medico.setPaterno(rs.getString("ap_med"));
            medico.setMaterno(rs.getString("am_med"));
            medico.setCedula(rs.getString("cedula_med"));
            medico.setEstatus(rs.getBoolean("estatus"));
            listMedicoDto.add(medico);
        }
        return listMedicoDto;
    }

    
    public MedicoDTO update(MedicoDTO medico) throws Exception {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        pst = con.prepareStatement("UPDATE medico SET nombre_med = ?, estatus = ?, id_us = ? WHERE id = ?");
        pst.setString(1, medico.getNombre());
        pst.setBoolean(2, medico.isEstatus());
        pst.setInt(3, medico.getId());

        int r = pst.executeUpdate();

        if(r > 0){
            return medico;
        }
        else
            throw new Exception("No actualizado");
    }

    
    public MedicoDTO delete(MedicoDTO medico) throws Exception {
        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);
        pst = con.prepareStatement("UPDATE medico SET estatus = ? WHERE id = ?");
        pst.setBoolean(1, medico.isEstatus());
        pst.setInt(2, medico.getId());

        int r = pst.executeUpdate();
        if(r > 0){
            return medico;
        }
        else
            throw new Exception("No actualizado");
    }

    public List<MedicoDTO> read(List<MedicoDTO> m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MedicoDTO create(MedicoDTO medico, Connection con) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}