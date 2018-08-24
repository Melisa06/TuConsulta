/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.negocio;
import java.util.logging.Level;
import java.util.logging.Logger;

import modelo.dao.RecetaDAO;
import modelo.dto.PacienteDTO;
import modelo.dto.RecetaDTO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author Morales
 */
public class RecetaBussines {
    
    static String ruta = "C:/Users/DLL/Documents/NetBeansProjects/TuConsulta/web/RecetasPDF/";
    
     public static RecetaDTO crear(int id_paciente,String fecha,String observaciones) {
    
            RecetaDTO u = new RecetaDTO();
            RecetaDAO dao = new RecetaDAO();
            
           
           u.setIdpaciente(new PacienteDTO(id_paciente));
            u.setFecha(fecha);
            u.setDiagnostico(observaciones);
            
            try {
            
                  u = dao.create(u);
                  
                 
                  CrearRecetaPDF(u);
                   System.out.print("pdf creado ");
                  
            } catch (Exception ex) {
                
                Logger.getLogger(RecetaBussines.class.getName()).log(Level.SEVERE, null, ex);
                
                u = null;
                
                System.out.print("Error: "+ex.getMessage());
            }
            
            
            return u;
    
    }
   
    
     public static RecetaDTO buscar(int id){
    
            RecetaDTO u = new RecetaDTO();
           RecetaDAO dao = new RecetaDAO();
            
            u.setId(id);
            
            
            try {
                u = dao.read(u);
            } catch (Exception ex) {
                
                  u = null;
                
                Logger.getLogger(RecetaBussines.class.getName()).log(Level.SEVERE, null, ex);
                
                if(ex.getMessage().equalsIgnoreCase("No encontrado")){
                    
                    System.out.print("Error: "+ex.getMessage());
                
                }else{
                    System.out.print("Error: "+ex.getMessage());
                }
                
             
            }
            
            return u;
    
    }
    
       public static void CrearRecetaPDF(RecetaDTO r ) throws Exception{
        
        Document document = new Document();
        
        Calendar cal = Calendar.getInstance();
        Date fecha = new Date( cal.getTimeInMillis());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        Font ftitulo=new Font(FontFamily.TIMES_ROMAN,40.0f,Font.BOLD,BaseColor.RED);
        Font fttable=new Font(FontFamily.TIMES_ROMAN,16.0f,Font.BOLD,BaseColor.BLACK);
        Font ftwhite=new Font(FontFamily.TIMES_ROMAN,16.0f,Font.BOLD,BaseColor.WHITE);
        
        Paragraph titulo = new Paragraph("Receta No#: "+r.getId(),ftitulo);
        titulo.setAlignment(Element.ALIGN_CENTER);
       // titulo.setFont(ftitulo);
        
         // Este codigo genera una tabla de 3 columnas
         PdfPTable table = new PdfPTable(3);   
         
            // addCell() agrega una celda a la tabla, el cambio de fila
            // ocurre automaticamente al llenar la fila
            table.addCell(new Paragraph("NO ",fttable));
            table.addCell(new Paragraph("MEDICINA ",fttable));
            table.addCell(new Paragraph("COMENTARIOS ",fttable));
             
            table.addCell("Celda 4");
            table.addCell("Celda 5");
            table.addCell("Celda 6");
             
            table.addCell("Celda 7");
            table.addCell("Celda 8");
            table.addCell("Celda 9");
             
            // Si desea crear una celda de mas de una columna
            // Cree un objecto Cell y cambie su propiedad span
             
            PdfPCell celdaFinal = new PdfPCell(new Paragraph("Final de la tabla"));
             
            // Indicamos cuantas columnas ocupa la celda
            celdaFinal.setColspan(3);
            table.addCell(celdaFinal);
             
 
        PdfWriter.getInstance(document, new FileOutputStream(ruta + "receta"+r.getId()+".pdf"));
        document.open();
        
        
        document.add(titulo);
        document.add(new Paragraph("-",ftwhite) );
        
        Paragraph p = new Paragraph("Fecha: "+formato.format(fecha));
        p.setAlignment(Element.ALIGN_RIGHT);
        
        document.add(p);
        document.add(new Paragraph("-",ftwhite) );
        document.add(new Paragraph("Paciente: "+r.getIdpaciente().getNombrePaciente(),fttable) );
        document.add(new Paragraph("-",ftwhite));
        document.add(table);
        
        document.add(new Paragraph("Diagnostico: ",fttable));
        document.add(new Paragraph(""+r.getDiagnostico()));
        
        document.close();
 
    }
}
