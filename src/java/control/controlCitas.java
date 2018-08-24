/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import modelo.negocio.CitaBussines;
import java.io.IOException;
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

/**
 *
 * @author Ricardo Camacho
 */
@WebServlet(name = "controlCitas", urlPatterns = {"/controlCitas", "/citas", "/detalleCita", "/nuevaCita"})
public class controlCitas extends HttpServlet {

    String url;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        url = request.getServletPath();
        
        switch(url){
            case "/citas":
                List<CitaDTO> citas = CitaBussines.buscar();
                request.setAttribute("citas", citas);
                request.getRequestDispatcher("WEB-INF/citas/listCita.jsp").forward(request, response);
                break;
            
            case "/detalleCita":
                request.getRequestDispatcher("WEB-INF/citas/detailsCita.jsp").forward(request, response);
                break;
                
            case "/nuevaCita":
                request.getRequestDispatcher("WEB-INF/citas/createCita.jsp").forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        url = request.getServletPath();
        
        int id,id_paciente,id_medico;
        String fechacita,hr_cita;
        boolean estatus;
        
        switch(url){
            case "/nuevaConsulta":
                 id = request.getIntHeader("txtId");
                fechacita = request.getParameter("txtFechacita");
                hr_cita = request.getParameter("txtHr_cita");
                estatus = true;
                try {
                    CitaDTO cita = CitaBussines.crear(id, fechacita, hr_cita, new PacienteDTO(id), new MedicoDTO(id), Boolean.TRUE);
                } catch (Exception ex) {
                    Logger.getLogger(controlCitas.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
