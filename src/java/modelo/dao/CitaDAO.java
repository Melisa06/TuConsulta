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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.dto.CitaDTO;
import modelo.interfaz.ICita;
import modelo.negocio.MedicoBussines;
import negocio.PacienteBussines;

/**
 *
 * @author Windows
 */
public class CitaDAO implements ICita {

    String URL = "jdbc:postgresql://localhost:5432/tuconsulta";
    String USER = "postgres";
    String PASSWORD = "admin";

    public Connection con = null;
    public PreparedStatement pst = null;

    @Override
    public CitaDTO create(CitaDTO cita) throws Exception {

        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);

        pst = con.prepareStatement("INSERT INTO cita (id,fechacita,id_paciente,id_medico,estatus values (?,?,?,?,?))");

        pst.setInt(1, cita.getId());
        pst.setString(2, cita.getFechacita());
        pst.setInt(2, cita.getId_paciente().getId());
        pst.setInt(3, cita.getId_medico().getId());
        pst.setBoolean(4, cita.isEstatus());

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

        pst = con.prepareStatement("select id,fechacita,id_paciente,id_medico,estatus" + "From cita Where id like ?");

        pst.setInt(1, cita.getId());

        ResultSet result = pst.executeQuery();

        if (result.next()) {

            cita.setId(result.getInt("id"));
            cita.setId_paciente(PacienteBussines.buscar(result.getInt("id_paciente")));
            cita.setId_medico(MedicoBussines.buscar(result.getInt("id_medico")));
            cita.setFechacita(result.getString("fechacita"));
            cita.setEstatus(result.getBoolean("estatus"));

            return cita;
        }

        throw new Exception("No encontrado");

    }

    public List<CitaDTO> read() throws SQLException {

        con = DriverManager.getConnection(URL, USER, PASSWORD);

        List<CitaDTO> ids = new ArrayList<>();

        pst = con.prepareStatement("select id,fechacita,id_paciente,id_medico" + "From cita");

        ResultSet result = pst.executeQuery();

        while (result.next()) {

            CitaDTO dto = new CitaDTO();

            dto.setId(result.getInt("id"));
            dto.setFechacita(result.getString("fechacita"));
            dto.getId_paciente(PacienteBussines.buscar(result.getInt("id_paciente")));
            dto.getId_medico(MedicoBussines.buscar(result.getInt("id_medico")))
           

            ids.add(dto);

        }

        return ids;
    }

    @Override
    public CitaDTO update(CitaDTO cita) throws Exception {

        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(URL, USER, PASSWORD);

        pst = con.prepareStatement("UPDATE cita set fechacita = (?) ,id_medico = ?,estatus = ? WHERE id like ?");

        pst.setString(2, cita.getFechacita());
        pst.setInt(3, cita.getId_medico().getId());
        pst.setBoolean(4, cita.isEstatus());
        pst.setInt(1, cita.getId());

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

}
//duda en read ya que en el bussines solo ocupa el id y el query ocupa todos los datos
