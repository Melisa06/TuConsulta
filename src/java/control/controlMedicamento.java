
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import static com.sun.xml.bind.util.CalendarConv.formatter;
import java.awt.Image;
import static java.awt.JobAttributes.DestinationType.FILE;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.ImageIcon;
import modelo.dto.MedicamentoDTO;
import modelo.negocio.MedicamentoBussines;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import sun.misc.BASE64Decoder;

/**
 *
 * @author Jhazmin Alvarez
 */
@WebServlet(name = "controlMedicamento", urlPatterns = {"/medicamento", "/nuevo_medicamento", "/borrar_medicamento", "/editar_medicamento","/medicamentopaciente","/activar_medicamento"})
public class controlMedicamento extends HttpServlet {
 String ruta="C:/Users/hp/Documents/NetBeansProjects/medicamento/medicamento/web/medicamento_imagenes/";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = request.getServletPath();
       
        if (url.equals("/medicamento")) {

            List<MedicamentoDTO> dts = MedicamentoBussines.buscar();

            //enviar datos a jsp
            request.setAttribute("medicamento", dts);

            request.getRequestDispatcher("/WEB-INF/productos/listProducto.jsp").forward(request, response);

        } else if (url.equals("/nuevo_medicamento")) {

            request.setAttribute("titulo", "Nuevo medicamento");
            request.setAttribute("accion", "nuevo_medicamento");
             request.setAttribute("textoboton", "Guardar");
             request.setAttribute("oculto", "visibility:hidden");
            request.getRequestDispatcher("/WEB-INF/productos/createProducto.jsp").forward(request, response);
           
        }else if( (url.equalsIgnoreCase("/medicamentopaciente"))){
           List<MedicamentoDTO> dts = MedicamentoBussines.buscarP();

            //enviar datos a jsp
            request.setAttribute("medicamentop", dts);

            request.getRequestDispatcher("/WEB-INF/folder/medicamentosP.jsp").forward(request, response);
        }else if (url.equals("/borrar_medicamento")) {
            int m =Integer.parseInt(request.getParameter("n"));
            boolean status = false;
            MedicamentoDTO dto = MedicamentoBussines.eliminar(m,status);
            response.sendRedirect("medicamento");
        } else if (url.equals("/editar_medicamento")) {
            MedicamentoDTO dto = MedicamentoBussines.buscar(Integer.parseInt(request.getParameter("n")));
            request.setAttribute("accion", "editar_medicamento");
            request.setAttribute("dato", dto);
            request.setAttribute("nombreAnterior", dto.getNombreMedicamento());
            
            request.setAttribute("titulo", "Editar medicamento");
            
            System.out.println("_____________________-----_" + request.getParameter("n"));
            
            request.setAttribute("disponibilidad", "disabled");

            request.setAttribute("textoboton", "Actualizar");
            request.getRequestDispatcher("/WEB-INF/productos/createProducto.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombreM, descripcion, imagen, fechaActualizacion = "";
        boolean estatus;
        int stock;
        float precio;

        String url = request.getServletPath();

        if (url.equals("/nuevo_medicamento")) {

            nombreM = request.getParameter("txtnombre");
            descripcion = request.getParameter("txtdescripcion");
            stock = Integer.parseInt(request.getParameter("txtStock"));
            precio = Float.parseFloat(request.getParameter("txtprecio"));
            imagen = request.getParameter("imagen");
            estatus = true;
//             fechaActualizacion=request.getParameter("txtfecha");

            System.out.print("IMG : " + request.getParameter("img64"));

           
            if (nombreM.isEmpty() || descripcion.isEmpty()) {

                response.sendRedirect("nuevo_medicamento");

            } else {

                MedicamentoDTO dto = MedicamentoBussines.crear(nombreM, descripcion, stock, precio, estatus);
                  crearImg(request.getParameter("img64"),dto.getId()+"");
                response.sendRedirect("medicamento");
            }
        } else if (url.equals("/editar_medicamento")) {
            int id;
            id = Integer.parseInt(request.getParameter("txtid"));
            nombreM = request.getParameter("txtnombre");
            String nombreAnterior = request.getParameter("txtNombreAnterior");
            descripcion = request.getParameter("txtdescripcion");

            stock = Integer.parseInt(request.getParameter("txtStock"));
            precio = Float.parseFloat(request.getParameter("txtprecio"));
            imagen = request.getParameter("imagen");
            estatus = true;

            System.out.print("IMG : " + nombreAnterior);
           
            if (request.getParameter("img64").isEmpty() == false && request.getParameter("img64").equals("")== false)  {
                //borrarImg(...,nombreAnterior);
                crearImg(request.getParameter("img64"),""+id+"");
            }
            if (nombreM.isEmpty() || descripcion.isEmpty()) {

                response.sendRedirect("editar_medicamento");
            } else {

                MedicamentoDTO dto = MedicamentoBussines.update(id,nombreM , descripcion, stock, precio);

                if (dto != null) {
                    //Inserción exitosa
                    response.sendRedirect("medicamento");
                } else {
                    //Falla
                    response.sendRedirect("editar_medicamento?n=" + id);
                }

            }
        }else if (url.equals("/borrar_medicamento")) {
            int n =Integer.parseInt(request.getParameter("n"));
           
       if (n>0){
           MedicamentoDTO udto = new MedicamentoDTO();
           MedicamentoBussines ubuss = new MedicamentoBussines();
           MedicamentoDTO dto = MedicamentoBussines.eliminar(n,false);
           
           response.sendRedirect("medicamento");
           
           
           
           
       }else{
           response.sendRedirect("medicamento");
       }
            
        }else{
            
            response.sendRedirect("medicamento");
        }

    
    }
   public void crearImg(String img, String nombreImg) throws IOException {

        // tokenize the data
        String[] parts = img.split(",");
        String imageString = parts[1];

        // create a buffered image
        BufferedImage image = null;
        byte[] imageByte;

        BASE64Decoder decoder = new BASE64Decoder();
        imageByte = decoder.decodeBuffer(imageString);
        ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
        image = ImageIO.read(bis);
        bis.close();
     
       // String Filepath = "/medicamento_imagenes/";
       // String path = getServletContext().getRealPath(Filepath);
        // write the image to a file
         File outputfile = new File(ruta+ nombreImg + ".png");
        //getServletContext().getRealPath("/").replace("\\", "/")+
        // System.out.print("Imagenes_productos/image.png");
        ImageIO.write(image, "png", outputfile);

    }
}
