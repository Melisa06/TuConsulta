<%-- 
    Document   : indexCliente
    Created on : Aug 19, 2018, 12:04:55 PM
    Author     : Ricardo Camacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-dark py-lg-4" id="mainNav">
      <div class="container">
        <a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav mx-auto">
            <li class="nav-item active px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="IndexCliente.html">Perfil
                <span class="sr-only">(current)</span>
              
              </a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="formCita.html">Agendar Cita</a>
            </li>
             <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="productos.html">Productos</a>
            </li>
             <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="mihistorial.html">Mi historial</a>
            </li>
            <li class="nav-item px-lg-4">
             

                
              <a class="nav-link text-uppercase text-expanded" href="javascript:;" onclick="aviso('../index.html'); return false;">Cerar Sesion</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
<section class="page-section about-heading">
      <div class="container">
        <img class="img-fluid rounded about-heading-img mb-3 mb-lg-0" src="img/about.jpg" alt="">
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
                  <span class="section-heading-upper">Curp:</span>
                </h2>

          <input type="text" class="form-control" name="txtCurp" placeholder="Curp" value="" >
        <br>
        
       
        <br>
       <h2 class="section-heading mb-4">
                  <span class="section-heading-upper">Domicilio:</span>
                </h2>

          <input type="text" class="form-control" name="txtDomi" placeholder="Domicilio" value="" >
        <br>
        <hr>
        <h2 class="section-heading mb-4">
                  <span class="section-heading-lower">Datos Médicos</span>
                </h2>
         <h2 class="section-heading mb-4">
                  <span class="section-heading-upper">Peso:</span>
                </h2>

          <input type="text" class="form-control" name="txtPeso" placeholder="kg" value="" >
        <br>
         <h2 class="section-heading mb-4">
                  <span class="section-heading-upper">Estatura:</span>
                </h2>

          <input type="text" class="form-control" name="txtEstatura" placeholder="Estatura" value="" >
        <br>
         <h2 class="section-heading mb-4">
                  <span class="section-heading-upper">Alergias:</span>
                </h2>

          <input type="text" class="form-control" name="txtAlergia" placeholder="Indique alergias" value="" >
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