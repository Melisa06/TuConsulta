<%-- 
    Document   : listProducto
    Created on : Aug 20, 2018, 1:30:52 AM
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
                    <a class="nav-link text-uppercase text-expanded" href="/">Principal
                        <span class="sr-only">(current)</span>

                    </a>
                </li>
                <li class="nav-item px-lg-4">
                    <a class="nav-link text-uppercase text-expanded" href="medicamento">Productos</a>
                </li>
                <li class="nav-item px-lg-4">
                    <a class="nav-link text-uppercase text-expanded" href="medicos">Medicos</a>
                </li>
                <li class="nav-item px-lg-4">
                <li class="nav-item px-lg-4">
                    <a class="nav-link text-uppercase text-expanded" href="recepcionistas">Recepcionistas</a>
                </li>
                <li class="nav-item px-lg-4">
                <li class="nav-item px-lg-4">
                    <a class="nav-link text-uppercase text-expanded" href="clientes">Clientes</a>
                </li>
                <li class="nav-item px-lg-4">
                <li class="nav-item px-lg-4">
                    <a class="nav-link text-uppercase text-expanded" href="consultas">Consultas</a>
                </li>

                <li class="nav-item px-lg-4">
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
                        <h2>Productos</h2>
                        <a href="nuevo_medicamento">
                            <input type="submit" value="Nuevo medicamento" name="btnNuevo"
               onClick="document.location = 'nuevo_medicamento';"/>
                           
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<div class="row text-center">

      <div class="col-lg-3 col-md-6 mb-4">
        <div class="card">
          <c:forEach var="medicamentos" items="${medicamento}">
            <img src ="medicamento_imagenes/${medicamentos.id}.png" width="50" height="40">
                
          <div class="card-body">
            <h4 class="card-title"><td>${medicamentos.nombreMedicamento}</td></h4>
            <p class="card-text">Clave: ${medicamentos.id}</p>
            <p class="card-text">${medicamentos.descripcion}</p>
            <p class="card-text">${medicamentos.fechaActualizacion}</p>
             <p class="card-text">Disponibles: ${medicamentos.stock} pzas</p>
               <p class="card-text">Precio sugerido :$ ${medicamentos.precio}</p>
           
          </div>
          <div class="card-footer">


           
            <a class="btn btn-primary" href="" onclick='alert("Aun no esta disponible.")'>Ver</a>
          
          </div>
        </div>
     </div>
</c:forEach>

   

</div>
