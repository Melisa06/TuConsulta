<%-- 
    Document   : formulario
    Created on : Jul 16, 2018, 7:22:54 PM
    Author     : Morales
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        
      
        
       
        
        <form method="POST">
            <Label> Paciente: </label>
            <input type="text" name="txtpaciente" />
            <input type="hidden" name="paciente"  />
                        <br>

            
            <Label> FECHA Y HORa </label>
            <input type="fecha" name="txtfecha"/>
            <br>
            
           <Label> paciente </label>
            <input type="text" name="txt"/>
            
            
            <input type="button" value="Cancelar" />
        </form>
    
            </body>
</html>
