package control;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.dto.PermisoDTO;
import modelo.dto.RolDTO;
import modelo.dto.UsuarioDTO;
import modelo.negocio.MedicoBussines;
import modelo.negocio.PacienteBussines;
import modelo.negocio.PermisoBusiness;
import modelo.negocio.RolBusiness;
import modelo.negocio.UsuarioBusiness;

/**
 *
 * @author Ricardo Camacho
 */
@WebServlet(name = "ControlUsuario", urlPatterns = {"/login", "/validar", "/crearUsuario", "/paciente", "/medico", "/admin", "/inicio", "/usuarios", "/editarUsuario", "/estatusUsuario", "/logout"})
public class ControlUsuario extends HttpServlet {

    String url;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        url = request.getServletPath();
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        PermisoDTO permisoDTO = new PermisoDTO();
        List<RolDTO> roles = RolBusiness.buscar();
        List<UsuarioDTO> usuarios = UsuarioBusiness.buscar();
        HttpSession sesion;
        switch(url){
            case "/login":
                sesion = request.getSession();
                if(sesion.getAttribute("datos") != null){
                    PermisoDTO datos = (PermisoDTO) sesion.getAttribute("datos");
                    if(datos.getIdRol().getNombreRol().equals("admin"))
                        response.sendRedirect("admin");

                    else if(datos.getIdRol().getNombreRol().equals("médico"))
                        response.sendRedirect("medico");

                    else if(datos.getIdRol().getNombreRol().equals("paciente"))
                        response.sendRedirect("paciente");
                }
                else{
                request.setAttribute("error", "none");
                request.setAttribute("title", "login");
                request.getRequestDispatcher("WEB-INF/usuarios/login.jsp").forward(request, response);
                }
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
                
            case "/inicio":
                sesion = request.getSession();
                if(sesion.getAttribute("datos") != null){
                    PermisoDTO datos = (PermisoDTO) sesion.getAttribute("datos");
                    if(datos.getIdRol().getNombreRol().equals("admin"))
                        response.sendRedirect("admin");

                    else if(datos.getIdRol().getNombreRol().equals("médico"))
                        response.sendRedirect("medico");

                    else if(datos.getIdRol().getNombreRol().equals("paciente"))
                        response.sendRedirect("paciente");
                    }
                else
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
                
            case "/usuarios":
                request.setAttribute("usuarios", usuarios);
                request.setAttribute("success", "none");
                request.getRequestDispatcher("WEB-INF/usuarios/listUsuario.jsp").forward(request, response);
                break;
                
            case "/crearUsuario":
                request.setAttribute("roles", roles);
                request.setAttribute("success", "none");
                request.getRequestDispatcher("WEB-INF/usuarios/createUsuario.jsp").forward(request, response);
                break;
                
            case "/editarUsuario":
                usuarioDTO = UsuarioBusiness.buscar(Integer.parseInt(request.getParameter("id")));
                usuarioDTO.setId(Integer.parseInt(request.getParameter("id")));
                usuarioDTO.setIdPermiso(PermisoBusiness.buscar(usuarioDTO.getId()));
                request.setAttribute("usuario", usuarioDTO);
                request.setAttribute("roles", roles);
                request.getRequestDispatcher("WEB-INF/usuarios/detailsUsuario.jsp").forward(request, response);
                break;
                
            case "/estatusUsuario":
                if(UsuarioBusiness.borrar(Integer.parseInt(request.getParameter("id"))) != null){
                    response.sendRedirect("usuarios");
                }
                else{
                    request.setAttribute("alert", "alert-danger");
                    request.setAttribute("success", "block");
                    request.setAttribute("mensaje", "Error al actualizar");
                    request.setAttribute("usuarios", usuarios);
                    request.getRequestDispatcher("WEB-INF/usuarios/listUsuario.jsp").forward(request, response);
                }
                break;
            
            case "/logout":
                sesion = request.getSession();
                sesion.invalidate();
                response.sendRedirect("inicio");
                break;
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email, password;
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        PermisoDTO permisoDTO = new PermisoDTO();
        UsuarioDTO infoSinProcesar = new UsuarioDTO();
        String confirmarPassword;
        List<RolDTO> roles = RolBusiness.buscar();
        int idUsuario;
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
                    request.setAttribute("title", "login");
                    request.getRequestDispatcher("WEB-INF/usuarios/verificar.jsp").forward(request, response); 
                }
                else{
                    request.setAttribute("title", "login");
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
                                sesion.setAttribute("idUsuarioActual", MedicoBussines.buscarId(dto.getId()).getId());
                                break;
                            case 3:
                                response.sendRedirect("paciente");
                                sesion.setAttribute("idUsuarioActual", PacienteBussines.buscarId(dto.getId()).getId());
                                break;
                            default:
                                response.sendRedirect("/");
                                break;
                        }
                    }
                    else{
                        request.setAttribute("error", "block");
                        request.setAttribute("email", email);
                        request.setAttribute("title", "login");
                        request.getRequestDispatcher("WEB-INF/usuarios/verificar.jsp").forward(request, response); 
                    }
                }
                else{
                    request.setAttribute("error", "block");
                    request.setAttribute("email", email);
                    request.setAttribute("title", "login");
                    request.getRequestDispatcher("WEB-INF/usuarios/verificar.jsp").forward(request, response); 
                }
                break;
                
            case "/crearUsuario":
                usuarioDTO.setEmail(request.getParameter("txtEmail"));
                usuarioDTO.setPassword(request.getParameter("txtPassword"));
                confirmarPassword = request.getParameter("txtPasswordConfirm");
                
                permisoDTO.setIdRol(new RolDTO(Integer.parseInt(request.getParameter("rol"))));
                permisoDTO.setUsuarios(Integer.parseInt(request.getParameter("pUsuarios")));
                permisoDTO.setMedicos(Integer.parseInt(request.getParameter("pMedicos")));
                permisoDTO.setPacientes(Integer.parseInt(request.getParameter("pPacientes")));
                permisoDTO.setCitas(Integer.parseInt(request.getParameter("pCitas")));
                permisoDTO.setRecetas(Integer.parseInt(request.getParameter("pRecetas")));
                permisoDTO.setMedicamentos(Integer.parseInt(request.getParameter("pMedicamentos")));
                permisoDTO.setVenta(Integer.parseInt(request.getParameter("pVenta")));
                permisoDTO.setCompra(Integer.parseInt(request.getParameter("pCompra")));
                permisoDTO.setProveedores(Integer.parseInt(request.getParameter("pProveedores")));
                permisoDTO.setSucursales(Integer.parseInt(request.getParameter("pSucursales")));
                permisoDTO.setAlmacen(Integer.parseInt(request.getParameter("pAlmacen")));
                usuarioDTO.setIdPermiso(permisoDTO);
                
                UsuarioDTO validar = usuarioDTO;
                infoSinProcesar = usuarioDTO;
                
                validar = UsuarioBusiness.verificar(validar.getEmail());
                
                if(usuarioDTO.getPassword().equals(confirmarPassword) && usuarioDTO.getEmail().length() > 5 ){
                    if(validar == null){
                        usuarioDTO = UsuarioBusiness.crear(usuarioDTO);
                        if(usuarioDTO != null){
                            permisoDTO.setIdUsuario(usuarioDTO.getId());
                            permisoDTO = PermisoBusiness.crear(permisoDTO);
                            if(permisoDTO != null){
                                request.setAttribute("alert", "alert-success");
                                request.setAttribute("success", "block");
                                request.setAttribute("mensaje", "Registro exitoso");
                                List<UsuarioDTO> usuarios = UsuarioBusiness.buscar();
                                request.setAttribute("usuarios", usuarios);
                                request.getRequestDispatcher("WEB-INF/usuarios/listUsuario.jsp").forward(request, response);
                            }
                            else{
                                request.setAttribute("usuario", infoSinProcesar);
                                request.setAttribute("roles", roles);
                                request.setAttribute("alert", "alert-danger");
                                request.setAttribute("success", "block");
                                request.setAttribute("mensaje", "Error al registrar");
                                request.getRequestDispatcher("WEB-INF/usuarios/createUsuario.jsp").forward(request, response);
                            }
                        }
                        else{
                            request.setAttribute("usuario", infoSinProcesar);
                            request.setAttribute("roles", roles);
                            request.setAttribute("alert", "alert-danger");
                            request.setAttribute("success", "block");
                            request.setAttribute("mensaje", "Error al registrar");
                            request.getRequestDispatcher("WEB-INF/usuarios/createUsuario.jsp").forward(request, response);
                        }
                    }
                    else{
                        request.setAttribute("usuario", infoSinProcesar);
                        request.setAttribute("roles", roles);
                        request.setAttribute("alert", "alert-danger");
                        request.setAttribute("success", "block");
                        request.setAttribute("mensaje", "Correo electrónico no valido");
                        request.getRequestDispatcher("WEB-INF/usuarios/createUsuario.jsp").forward(request, response);
                    }
                }
                else{
                    request.setAttribute("usuario", infoSinProcesar);
                    request.setAttribute("roles", roles);
                    request.setAttribute("alert", "alert-danger");
                    request.setAttribute("success", "block");
                    request.setAttribute("mensaje", "Las contraseñas no coinciden");
                    request.getRequestDispatcher("WEB-INF/usuarios/createUsuario.jsp").forward(request, response);
                }
                break;
                
            case "/editarUsuario":
                usuarioDTO.setEmail(request.getParameter("txtEmail"));
                permisoDTO.setIdRol(new RolDTO(Integer.parseInt(request.getParameter("rol"))));
                permisoDTO.setUsuarios(Integer.parseInt(request.getParameter("pUsuarios")));
                permisoDTO.setMedicos(Integer.parseInt(request.getParameter("pMedicos")));
                permisoDTO.setPacientes(Integer.parseInt(request.getParameter("pPacientes")));
                permisoDTO.setCitas(Integer.parseInt(request.getParameter("pCitas")));
                permisoDTO.setRecetas(Integer.parseInt(request.getParameter("pRecetas")));
                permisoDTO.setMedicamentos(Integer.parseInt(request.getParameter("pMedicamentos")));
                permisoDTO.setVenta(Integer.parseInt(request.getParameter("pVenta")));
                permisoDTO.setCompra(Integer.parseInt(request.getParameter("pCompra")));
                permisoDTO.setProveedores(Integer.parseInt(request.getParameter("pProveedores")));
                permisoDTO.setSucursales(Integer.parseInt(request.getParameter("pSucursales")));
                permisoDTO.setAlmacen(Integer.parseInt(request.getParameter("pAlmacen")));
                usuarioDTO.setIdPermiso(permisoDTO);
                
                infoSinProcesar = usuarioDTO;
               
                permisoDTO.setIdUsuario(Integer.parseInt(request.getParameter("idUsuario")));
                permisoDTO = PermisoBusiness.actualizar(permisoDTO);
                if(permisoDTO != null){
                    request.setAttribute("alert", "alert-success");
                    request.setAttribute("success", "block");
                    request.setAttribute("mensaje", "Actualización exitosa");
                    List<UsuarioDTO> usuarios = UsuarioBusiness.buscar();
                    request.setAttribute("usuarios", usuarios);
                    request.getRequestDispatcher("WEB-INF/usuarios/listUsuario.jsp").forward(request, response);
                }
                else{
                    request.setAttribute("usuario", infoSinProcesar);
                    request.setAttribute("roles", roles);
                    request.setAttribute("alert", "alert-danger");
                    request.setAttribute("success", "block");
                    request.setAttribute("mensaje", "Error al actualizar");
                    request.getRequestDispatcher("WEB-INF/usuarios/createUsuario.jsp").forward(request, response);
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
