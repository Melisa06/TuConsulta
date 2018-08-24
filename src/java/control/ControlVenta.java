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
import modelo.dao.VentaDAO;
import modelo.dto.MedicamentoDTO;
import modelo.dao.MedicoDAO;
import modelo.dto.DetalleVentDTO;
import modelo.dto.VentaDTO;
import modelo.negocio.DetalleVentaBussines;
import modelo.negocio.MedicamentoBussines;
import modelo.negocio.VentaBussines;

/**
 *
 * @author daniel
 */
@WebServlet(name = "ControlVenta", urlPatterns = {"/ControlVenta","/agregarVentaProducto" ,"/venta", "/detalleVenta", "/agregarVenta", "/actualizarVenta"})
public class ControlVenta extends HttpServlet {

    String url;
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             url = request.getServletPath();
        
        switch(url){
            case "/venta":
                
                List<VentaDTO> datos = VentaBussines.buscar();
                request.setAttribute("usuarios", datos);
                request.getRequestDispatcher("WEB-INF/venta/lisVenta.jsp").forward(request, response);
                break;
            
            case "/detalleVenta":
                             break;
                
            case "/agregarVenta":
                List<MedicamentoDTO> dato = MedicamentoBussines.buscar();
                request.setAttribute("medicamentos", dato);
                request.setAttribute("idVenta", 0);
                request.getRequestDispatcher("WEB-INF/venta/nuvaVenta.jsp").forward(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        url = request.getServletPath();
        
        switch(url){
            case "/agregarVentaProducto":
               
                int idVenta;
                
                idVenta = Integer.parseInt(request.getParameter("idVentaVal"));
                if(idVenta == 0){
                     boolean estatus;
                
                 estatus = true; 
                VentaDTO dto = VentaBussines.crear(estatus);
                idVenta = dto.getIdVenta();             
                
                }
                
                int  idMedi,cant;
                double precioUni,montoTotal;
                
                idMedi = Integer.parseInt(request.getParameter("medicamentosVt"));
                cant = Integer.parseInt(request.getParameter("cantidad"));
                DetalleVentDTO dto = new DetalleVentDTO();
                dto.setIdMedicamento(MedicamentoBussines.buscar(idMedi));
                precioUni = dto.getIdMedicamento().getPrecio();
                montoTotal = cant * dto.getIdMedicamento().getPrecio();
                
                if(cant > dto.getIdMedicamento().getStock()){
                
                    
                }
                
                dto = DetalleVentaBussines.crear(idVenta, idMedi, cant, precioUni, montoTotal);
                   
                
                break; 
                        
     
    }
    }
    
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
