/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ricardo Camacho
 */
@WebServlet(name = "controlCliente", urlPatterns = {"/controlCliente", "/clientes", "/nuevoCliente", "/detalleCliente"})
public class controlCliente extends HttpServlet {

    String url;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        url = request.getServletPath();
        
        switch(url){
            case "/clientes":
                request.getRequestDispatcher("WEB-INF/clientes/listCliente.jsp").forward(request, response);
                break;
            
            case "/nuevoCliente":
                request.getRequestDispatcher("WEB-INF/clientes/createCliente.jsp").forward(request, response);
                break;
                
            case "/detalleCliente":
                request.getRequestDispatcher("WEB-INF/clientes/detailsCliente.jsp").forward(request, response);
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
