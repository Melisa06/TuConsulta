
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dto.MedicoDTO;
import modelo.negocio.MedicoBussines;


/**
 *
 * @author lupita
 */
@WebServlet(name = "controlMedico", urlPatterns = {"/controlMedico", "/medicos", "/nuevoMedico", "/detalleMedico"})
public class controlMedico extends HttpServlet {

    String url;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        url = request.getServletPath();
        
        switch(url){
            case "/medicos":
                List<MedicoDTO> listaM = MedicoBussines.buscar();
                request.setAttribute("listaMedicos", listaM);
                request.getRequestDispatcher("WEB-INF/medicos/listMedico.jsp").forward(request, response);
                break;
            
            case "/nuevoMedico":
                request.getRequestDispatcher("WEB-INF/medicos/createMedico.jsp").forward(request, response);
                break;
                
            case "/detalleMedico":
                request.getRequestDispatcher("WEB-INF/medicos/detailsMedico.jsp").forward(request, response);
                break;
        }
    }
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
