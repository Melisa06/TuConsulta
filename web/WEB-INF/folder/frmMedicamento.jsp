<%-- 
    Document   : frmMedicamento
    Created on : 18/07/2018, 07:15:42 PM
    Author     : Jhazmin Alvarez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar medcamento</title>
         <script>
      var loadFile = function(event) {
        var reader = new FileReader();
        reader.onload = function(){
          var output = document.getElementById('output');
           var img = document.getElementById('img64');
          
          output.src = reader.result;
          img.value = reader.result;
          
        };
        reader.readAsDataURL(event.target.files[0]);
      };
    </script>
    </head>
    <body>
        <h1> ${titulo} </h1>
        <form method="POST" action="${accion}" >
            
        <br>
        Nombre:
        <input type="text" name="txtnombre" value="${dato.nombreMedicamento}" ${disponibilidad1}>
        
        <input type="hidden" name="txtNombreAnterior" value="${dto.nombreAnterior}">
        
         <br>
        Descripcion:
        <input type="text" name="txtdescripcion" value="${dato.descripcion}" ${disponibilidad1} >
      
         <br>
        Stock:
        <input type="text" name="txtStock" value="${dato.stock}" ${disponibilidad1}>
         
         <br>
        Precio:
       <input type="text" name="txtprecio" value="${dato.precio}" ${disponibilidad1}>
       
       <br>  
        Imagen:
        <img src ="medicamentos_imagenes/${dato.id}.png" width="50" height="40" style="${oculto}">
<!--        <img src='medicamentos_imagenes/${dato.id}+".png"' ${disponibilidad1}>-->
        <br>
        <img id="output"/>                       
        <input type="file" name="imagen"  accept="image/*" onchange="loadFile(event)">           
        <input type="hidden" name="img64" id="img64"   />
       
        <br>
<!--        Status:-->
        <input type="hidden" name="txtstatus" value="true" readonly="readonly" />
        <br>
<!--        Fecha
        <input type="date" name="txtfecha" >-->
            <input type="submit" value="${textoboton}"> 
</form> 
    </body>
</html>
