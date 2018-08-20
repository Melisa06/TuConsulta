<%-- 
    Document   : indexAdmin
    Created on : Aug 19, 2018, 12:08:48 PM
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
              <a class="nav-link text-uppercase text-expanded" href="IndexAdministrador.html">Principal
                <span class="sr-only">(current)</span>
              
              </a>
            </li>
             <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="productosAdm.html">Productos</a>
            </li>
              <li class="nav-item px-lg-4">
            <a class="nav-link text-uppercase text-expanded" href="medicos.html">Medicos</a>
            </li>
            <li class="nav-item px-lg-4">
                <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="recepcionistas.html">Recepcionistas</a>
            </li>
             <li class="nav-item px-lg-4">
                <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="clientes.html">Clientes</a>
            </li>
             <li class="nav-item px-lg-4">
                <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="consultas.html">Consultas</a>
            </li>
           
 <li class="nav-item px-lg-4">
                <li class="nav-item px-lg-4">
                
              <a class="nav-link text-uppercase text-expanded" href="javascript:;" onclick="aviso('../index.html'); return false;">Cerar Sesion</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
<section class="page-section cta">

      <div class="container">
        <div class="row">
          <div class="col-xl-9 mx-auto">
            <div class="cta-inner text-center rounded">
              <h2 class="section-heading mb-4">
                <!--span class="section-heading-upper">Our Promise</span-->
                 <img class="img-fluid rounded about-heading-img mb-3 mb-lg-0" src="img/a.jpg" alt="" width="1000" height="">
                <span class="section-heading-lower"> MISION</span>
              </h2>
              <p class="mb-0">Mejorar la calidad de vida de nuestros clientes, a través del mejor nivel de servicio y precios competitivos. Innovar continuamente orientando nuestro esfuerzo en ser la mejor alternativa en Farmacia, para así siempre superar las expectativas de nuestros Clientes. !</p>
<h2 class="section-heading mb-4">
                <!--span class="section-heading-upper">Our Promise</span-->
                <span class="section-heading-lower"> VISION</span>
              </h2>
              <p class="mb-0">Ser líderes Centroamericanos en el comercio especializado de Farmacia que es nuestro negocio principal, así como productos de cuidado personal y de consumo brindando la mejor experiencia de compra, conveniencia y seguridad.</p>
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