<%-- 
    Document   : indexMedico
    Created on : Aug 19, 2018, 12:07:51 PM
    Author     : Ricardo Camacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="page-section about-heading">
      <div class="container">
        <!--img class="img-fluid rounded about-heading-img mb-3 mb-lg-0" src="img/medico.jpg"  width="1000" height="50"-->
        <div class="about-heading-content">
          <div class="row">
            <div class="col-xl-9 col-lg-10 mx-auto">
              <div class="bg-faded rounded p-5">
               <form action="" method="post" name="FormEntrar">
                <h2 class="section-heading mb-4">
                  <span class="section-heading-lower">Perfil</span>
                </h2>
       
   <h2 class="section-heading mb-4">
                  <span class="section-heading-upper">Nombre:</span>
                </h2>

          <input type="text" class="form-control" name="txtNombre" placeholder="Nombre" value="" >
        <input type="text" class="form-control" name="txtAp" placeholder="Apellido Paterno" value="" >
        <input type="text" class="form-control" name="txtAm" placeholder="Apellido Materno" value="" >
        <br>

     <h2 class="section-heading mb-4">
                  <span class="section-heading-upper">Cedula Professional:</span>
                </h2>

          <input type="text" class="form-control" name="txtCedula"  value="" >
        <br>
        
       
        <br>
       <h2 class="section-heading mb-4">
                  <span class="section-heading-upper">Domicilio:</span>
                </h2>

          <input type="text" class="form-control" name="txtDomi"  value="" >
        <br>
        <hr>
      
         <h2 class="section-heading mb-4">
                  <span class="section-heading-upper">Telefono:</span>
                </h2>

          <input type="text" class="form-control" name="txtTelefonoMedico"  value="" >
        <br>
         <h2 class="section-heading mb-4">
                  <span class="section-heading-upper">Correo :</span>
                </h2>

          <input type="text" class="form-control" name="txtCorreoMedico" value="" >
        <br>
         
  
        <br>
         <INPUT type="Submit" value="Actualizar Datos" class="btn btn-primary btn-xl">
        <INPUT type="button" value="Eliminar Cuenta" class="btn btn-primary btn-xl">
       


       
         
      </form>
              </div>
            </div>
          </div>
        </div>
      </div>
</section>

<script language="JavaScript">
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