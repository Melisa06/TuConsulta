/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.negocio.CitaBussines;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dto.CitaDTO;
import modelo.dto.MedicoDTO;
import modelo.dto.PacienteDTO;
import modelo.dto.RecetaDTO;
import usuario.negocio.RecetaBussines;

/**
 *
 * @author Ricardo Camacho
 */
@WebServlet(name = "controlConsultas", urlPatterns = {"/controlConsultas", "/consultas", "/nuevaConsulta"})
public class controlConsultas extends HttpServlet {

    String url;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        url = request.getServletPath();
        
        switch(url){
            case "/consultas":
                List<CitaDTO> citas = CitaBussines.buscar();
                request.setAttribute("citas", citas);
                request.getRequestDispatcher("WEB-INF/consultas/listConsulta.jsp").forward(request, response);
                break;
            
                
            case "/nuevaConsulta":
                
                request.getRequestDispatcher("WEB-INF/consultas/createConsulta.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id,id_paciente,id_medico;
        String fechacita,hr_cita;
        boolean estatus;
        
        String url = request.getServletPath();

        if (url.equals("/nuevaConsulta")){
            
            id = request.getIntHeader("txtId");
            fechacita = request.getParameter("txtFechacita");
            hr_cita = request.getParameter("txtHr_cita");
            estatus = true;
            try {
                CitaDTO cita = CitaBussines.crear(id, fechacita, hr_cita, new PacienteDTO(id), new MedicoDTO(id), Boolean.TRUE);
            } catch (SQLException ex) {
                Logger.getLogger(controlConsultas.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
