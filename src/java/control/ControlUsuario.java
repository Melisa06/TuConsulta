package control;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dto.RolDTO;
import modelo.dto.UsuarioDTO;
import modelo.negocio.PermisoBusiness;
import modelo.negocio.RolBusiness;
import modelo.negocio.UsuarioBusiness;

/**
 *
 * @author Ricardo Camacho
 */
@WebServlet(name = "ControlUsuario", urlPatterns = {"/login", "/validar", "/crearUsuario", "/paciente", "/medico", "/admin"})
public class ControlUsuario extends HttpServlet {

    String url;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        url = request.getServletPath();

        switch(url){
            case "/login":
                request.setAttribute("error", "none");
                request.getRequestDispatcher("WEB-INF/usuarios/login.jsp").forward(request, response);
                break;
            
            case "/crearUsuario":
                List<RolDTO> roles = RolBusiness.buscar();
                request.setAttribute("roles", roles);
                request.getRequestDispatcher("WEB-INF/usuarios/crearUsuario.jsp").forward(request, response);
                break;
                
            case "/paciente":
                request.getRequestDispatcher("WEB-INF/usuarios/indexCliente.jsp").forward(request, response);
                break;
            
            case "/medico":
                request.getRequestDispatcher("WEB-INF/usuarios/indexMedico.jsp").forward(request, response);
                break;
                
            case "/admin":
                request.getRequestDispatcher("WEB-INF/usuarios/indexAdmin.jsp").forward(request, response);
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
            case "/login":
                email = request.getParameter("txtEmail");
                UsuarioDTO dto = new UsuarioDTO();
                dto = UsuarioBusiness.verificar(email);

                if(dto != null){
                    request.setAttribute("error", "none");
                    request.setAttribute("email", email);
                    request.getRequestDispatcher("WEB-INF/usuarios/verificar.jsp").forward(request, response); 
                }
                else{
                    request.setAttribute("email", email);
                    request.setAttribute("error", "block");
                    request.getRequestDispatcher("WEB-INF/usuarios/login.jsp").forward(request, response);
                }
                break;

            case "/validar":
                password = request.getParameter("txtPassword");
                email = request.getParameter("txtEmail");
                dto = UsuarioBusiness.verificar(email);
                if(dto != null){

                    if(dto.getPassword().equals(UsuarioBusiness.getMD5(password))){
                        dto.setIdPermiso(PermisoBusiness.buscar(dto.getId()));
                        
                        HttpSession sesion = request.getSession(true);
                        
                        sesion.setAttribute("datos", dto.getIdPermiso());
                        
                        switch (dto.getIdPermiso().getIdRol().getId()) {
                            case 1:
                                response.sendRedirect("admin");
                                break;
                            case 2:
                                response.sendRedirect("medico");
                                break;
                            case 3:
                                response.sendRedirect("paciente");
                                break;
                            default:
                                response.sendRedirect("/");
                                break;
                        }
                    }
                    else{
                        request.setAttribute("error", "block");
                        request.setAttribute("email", email);
                        request.getRequestDispatcher("WEB-INF/usuarios/verificar.jsp").forward(request, response); 
                    }
                }
                else{
                    request.setAttribute("error", "block");
                    request.setAttribute("email", email);
                    request.getRequestDispatcher("WEB-INF/usuarios/verificar.jsp").forward(request, response); 
                }
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
