/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dto.PacienteDTO;
import modelo.dto.RecetaDTO;
import usuario.negocio.RecetaBussines;

/**
 *
 * @author Morales
 */
@WebServlet(name = "ControlReceta", urlPatterns = {"/nueva_receta"})
public class ControlReceta extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = request.getServletPath();
        
        System.out.println(url);
        
        if (url.equalsIgnoreCase("/nueva_receta")){
            List<PacienteDTO> pacientes = new ArrayList<>(); 
            
            for(int i = 1; i<5; i++ ){
                
                 PacienteDTO dto = new PacienteDTO(i);
                 dto.setNombrePaciente("Abril"+i);
             pacientes.add(dto);
            }
            
            request.setAttribute("pacientes", pacientes);
           SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
        request.setAttribute("fecha" , formatter.format(date));
        
        System.out.print (formatter.format(date));
        
            request.getRequestDispatcher("/WEB-INF/receta.jsp").forward(request, response);
                  
           
        }
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int paciente;
        String  fecha;
        String Observaciones;
        
        paciente = Integer.parseInt(request.getParameter("txtpaciente"));
        fecha = request.getParameter("txtfecha");
        Observaciones =request.getParameter("txtObservaciones");
                
        if((paciente != 0) && (!fecha.isEmpty())  && (!Observaciones.isEmpty())){
            
          //  RecetaDTO dto1 = RecetaBussines.buscar(1);
            
          // System.out.println("id "+dto1.getId());
                    
          RecetaDTO DTO = RecetaBussines.crear(paciente, fecha, Observaciones);
            
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
