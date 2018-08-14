package control;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.dto.RolDTO;
import modelo.dto.UsuarioDTO;
import modelo.negocio.PermisoBusiness;
import modelo.negocio.RolBusiness;
import modelo.negocio.UsuarioBusiness;

/**
 *
 * @author Ricardo Camacho
 */
@WebServlet(name = "ControlUsuario", urlPatterns = {"/login", "/validar", "/crearUsuario"})
public class ControlUsuario extends HttpServlet {

    String url;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        url = request.getServletPath();

        switch(url){
            case "/login":
                request.getRequestDispatcher("WEB-INF/usuarios/login.jsp").forward(request, response);
                break;
            
            case "/crearUsuario":
                List<RolDTO> roles = RolBusiness.buscar();
                request.setAttribute("roles", roles);
                request.getRequestDispatcher("WEB-INF/usuarios/crearUsuario.jsp").forward(request, response);
                break;
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email, password;
        url = request.getServletPath();
        
        try {
            switch(url){
            case "/validar":
                email = request.getParameter("txtEmail");
                password = request.getParameter("txtPassword");
                UsuarioDTO dto = new UsuarioDTO();
                dto = UsuarioBusiness.verificar(email);
    
                if(dto != null){
                    if(dto.getPassword().equals(UsuarioBusiness.getMD5(password))){
                        
                        dto.setIdPermiso(PermisoBusiness.buscar(dto.getId()));
                        
                        response.sendRedirect("medicamento");
                    }
                    else{
                        request.setAttribute("email", email);
                        request.getRequestDispatcher("WEB-INF/usuarios/login.jsp").forward(request, response);
                    }
                }
                else{
                    request.setAttribute("email", email);
                    request.getRequestDispatcher("WEB-INF/usuarios/login.jsp").forward(request, response);
                }
                break;
            case "/crearUsuario":
                
                
                break;
            }
        }
        catch (Exception ex) {
            System.out.println("Error " + ex.getMessage());
            response.sendRedirect("login");
        }
        
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
