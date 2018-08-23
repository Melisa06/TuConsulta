/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.negocio;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.CitaDAO;
import modelo.dto.CitaDTO;
import modelo.dto.MedicoDTO;
import modelo.dto.PacienteDTO;

/**
 *
 * @author Windows
 */
public class CitaBussines {

    public static CitaDTO crear(int id,String fechacita,String hr_cita, PacienteDTO id_paciente,MedicoDTO id_medico,Boolean estatus ) throws SQLException {

        Connection con = null;

        CitaDTO c = new CitaDTO();
        CitaDAO dao = new CitaDAO();

        c.setId(id);
        c.setFechacita(fechacita);
        c.setHr_cita(hr_cita);
        c.setId_paciente(id_paciente);
        c.setId_medico(id_medico);
        

        try {
            c = dao.create(c);
        } catch (Exception ex) {
            Logger.getLogger(CitaBussines.class.getName()).log(Level.SEVERE, null, ex);
            c = null;
            System.out.print("Error: " + ex.getMessage());

        }

        return c;

    }

    public static CitaDTO buscar(int id,String fechacita,String hr_cita,MedicoDTO id_medico) {

        CitaDTO c = new CitaDTO();
        CitaDAO dao = new CitaDAO();

        c.setId(id);
        c.setFechacita(fechacita);
        c.setHr_cita(hr_cita);
        c.setId_medico(id_medico);
        
        try {
            c = dao.read(c);
        } catch (Exception ex) {

            c = null;

            Logger.getLogger(CitaBussines.class.getName()).log(Level.SEVERE, null, ex);

            if (ex.getMessage().equalsIgnoreCase("No encontrado")) {

                System.out.print("Error: " + ex.getMessage());

            } else {
                System.out.print("Error: " + ex.getMessage());
            }

        }

        return c;

    }

    public static List<CitaDTO> buscar() {

        List<CitaDTO> c = new ArrayList<CitaDTO>();
        CitaDAO dao = new CitaDAO();

        try {
            c = dao.read();
        } catch (Exception ex) {

            c = null;

            Logger.getLogger(CitaBussines.class.getName()).log(Level.SEVERE, null, ex);

            if (ex.getMessage().equalsIgnoreCase("No encontrado")) {

                System.out.print("Error: " + ex.getMessage());

            } else {
                System.out.print("Error: " + ex.getMessage());
            }

        }

        return c;

    }

    public static CitaDTO actualizar(int id,String fechacita,String hr_cita,MedicoDTO id_medico,Boolean estatus ) {

        CitaDTO c = new CitaDTO();
        CitaDAO dao = new CitaDAO();

        c.setId(id);
        c.setFechacita(fechacita);
        c.setHr_cita(hr_cita);
        c.setId_medico(id_medico);
        c.setEstatus(estatus);
        

        try {
            c = dao.update(c);
        } catch (Exception ex) {
            Logger.getLogger(CitaBussines.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("Error: " + ex.getMessage());
        }

        return c;

    }

    public static CitaDTO eliminar(int id,Boolean estatus) {

        CitaDTO c = new CitaDTO();
        CitaDAO dao = new CitaDAO();

        c.setId(id);
        c.setEstatus(estatus);

        try {
            c = dao.delete(c);
        } catch (Exception ex) {
            Logger.getLogger(CitaBussines.class.getName()).log(Level.SEVERE, null, ex);
            System.out.print("Error: " + ex.getMessage());
        }

        return c;

    }

}
