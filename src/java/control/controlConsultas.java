/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo Camacho
 */
@WebServlet(name = "controlConsultas", urlPatterns = {"/controlConsultas", "/consultas", "/detalleConsulta", "/nuevaConsulta"})
public class controlConsultas extends HttpServlet {

    String url;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        url = request.getServletPath();
        
        switch(url){
            case "/consultas":
                request.getRequestDispatcher("WEB-INF/consultas/listConsulta.jsp").forward(request, response);
                break;
            
            case "/detalleConsulta":
                request.getRequestDispatcher("WEB-INF/consultas/detailsConsulta.jsp").forward(request, response);
                break;
                
            case "/nuevaConsulta":
                request.getRequestDispatcher("WEB-INF/consultas/createConsulta.jsp").forward(request, response);
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
