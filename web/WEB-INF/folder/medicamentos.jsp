<%-- 
    Document   : medicamentos
    Created on : 16/07/2018, 07:22:27 PM
    Author     : Jhazmin Alvarez
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Medicamento</title>
    </head>
    <body>
          <input type="submit" value="Nuevo medicamento" name="btnNuevo"
               onClick="document.location = 'nuevo_medicamento';"/>
       

        <h1>Medicina</h1>
         <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>NOMBRE</th>
                    <th>DESCRIPCION</th>
                    <th>FECHA</th>
                    <th>PRECIO</th>
                    <th>STOCK</th>
                    <th>IMAGEN</th>
                    <th>ESTATUS</th>
                    <th>OPCIONES</th>
                </tr>
            </thead>
            <tbody>
                
            <c:forEach var="medicamentos" items="${medicamento}">
                   
                    <tr>
                        <td>${medicamentos.id}</td>
                        <td>${medicamentos.nombreMedicamento}</td>
                        <td>${medicamentos.descripcion}</td>
                        <td>${medicamentos.fechaActualizacion}</td>
                        <td>${medicamentos.precio}</td>
                        <td>${medicamentos.stock}</td>
                        <td><img src ="medicamento_imagenes/${medicamentos.id}.png" width="50" height="40"></td>
                        <td>${medicamentos.estatus}</td>
                        <td>
                        
                               <input type="submit" value="Eliminar" name="btnBorrar"
                                       onClick="document.location = 'borrar_medicamento?n=${medicamentos.id}';"/>
                              <input type="submit" value="Actualizar" name="btnActualizar"
                                       onClick="document.location = 'editar_medicamento?n=${medicamentos.id}';"/>
                          
                            
                        
                        
                        </td>
                       
                    </tr>
                    
                </c:forEach>
                
               
            </tbody>
        </table>

    </body>
</html>
