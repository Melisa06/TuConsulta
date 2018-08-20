<%-- 
    Document   : receta
    Created on : Aug 3, 2018, 5:46:33 PM
    Author     : Morales
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Farmacia</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/business-casual.min.css" rel="stylesheet">
<script language="JavaScript" class="page-section cta">
function aviso(url){
if (!confirm("Seguro que desea salir?.")) {
return false;
}
else {
document.location = url;
return true;
}
}
</script>
  </head>

  <body>

   

    <!-- Navigation -->
   
<section class="page-section about-heading">
      <div class="container">
        
        <div class="about-heading-content">
          <div class="row">
            <div class="col-xl-9 col-lg-10 mx-auto">
              <div class="bg-faded rounded p-5">
                
                    </h2>
<span class="section-heading-lower">Generar receta</span>
                </h2>
                
  <form action="nueva_receta" method="post" name="FormReceta">
                <h2 class="section-heading mb-4">
 <span class="section-heading-upper">Paciente: </span>
  <select name="txtpaciente" class="form-control">
      <c:forEach var="paciente" items="${pacientes}" >
          <option value="${paciente.id}"  >${paciente.nombre}</option>
      </c:forEach> 

        </select>
     
   <h2 class="section-heading mb-4">
 <span class="section-heading-upper">Fecha y hora: </span>
  <input type="text" class="form-control" name="txtfecha" placeholder="10:00 am  25/sep/2018" value="${fecha}" >          
       
         <table class="table"   class= "table table-striped table-dark">
            <div class="intro-button mx-auto">
              <a class="btn btn-primary " href="formRecepcionista.html">Agregar +</a>
              
               
            </div>
          <h2>Ingresar medicamentos</h2>
     <tr>
        
                  <span class="section-heading-upper">N°</span>
                </h2>
</th>
      
              <th>   
                  <span class="section-heading-upper">Nombre </span>
                </h2>
</th>
          <th> 


                  <span class="section-heading-upper">Cantidad</span>
                </h2>

          </th>
           <th> 

                  <span class="section-heading-upper">Dosis</span>
                </h2>

          </th>
          <th>  

                  <span class="section-heading-upper">Opciones</span>
                </h2>


          </th>
                   
                </tr>
                 <tr>

                    <th> 
                  <span class="section-heading-upper">1</span>
                </h2>
</th>
                    <th>
                  <span class="section-heading-upper">Diclofenaco</span>
                </h2>
              </th>
                 <th>
                  <span class="section-heading-upper">2</span>
                </h2>
              </th>
                 <th>
                  <span class="section-heading-upper">1 cada 8 horas</span>
                </h2>
              </th>
                    
                    
                    
                    <th>
                     <div class="intro-button mx-auto">
              <a class="btn btn-primary " href="formRecepcionista.html">Eliminar</a>
              
               
            </div>
          </th>
                </tr>
  </table>
   <h2 class="section-heading mb-2">
                  <span class="section-heading-upper">Observaciones</span>
                </h2>

          <input type="text" class="form-control" name="txtObservaciones" placeholder="Observaciones" value="" size="190">
       
        <br>

     
        
         <INPUT type="Submit" value="Generar Receta" class="btn btn-primary btn-xl">
         PDF
         <INPUT type="Submit" value="cancelar" class="btn btn-primary btn-xl">
       
          <%-- 
    
   <a class="btn btn-primary btn-xl" href="citas.html">Cancelar</a>
--%>  
           
       
         
      </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  
<br>

<br>
<br>

<br>
<br>

<br>
    <footer class="footer text-faded text-center py-5">
      <div class="container">
        <p class="m-0 small">Copyright &copy; Farmacia</p>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="jquery/jquery.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>

  </body>

</html>

