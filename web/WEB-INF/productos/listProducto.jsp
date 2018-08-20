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
                    <a class="nav-link text-uppercase text-expanded" href="productos">Productos</a>
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
                            <button class="btn btn-primary">Nuevo Producto</button>
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
          <img class="card-img-top" src="medicamentos_imagenes/paracetamol.jpg" alt="">
          <div class="card-body">
            <h4 class="card-title">Paracetamol</h4>
            <p class="card-text">Descripcion.</p>
            <p class="card-text">$ 100.00</p>
          </div>
          <div class="card-footer">


            <a class="btn btn-primary" href="" onclick='alert("Aun no esta disponible.")'>Comprar</a>

          </div>
        </div>
      </div>

      <div class="col-lg-3 col-md-6 mb-4">
        <div class="card">
          <img class="card-img-top" src="medicamentos_imagenes/naproxeno.jpg" alt=" ">
            <div class="card-body ">
              <h4 class="card-title ">Naproxeno</h4>
              <p class="card-text ">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo magni sapiente, tempore debitis beatae culpa natus architecto.</p>
            </div>
            <div class="card-footer ">
              <a href="# " class="btn btn-primary ">Comprar</a>
            </div>
          </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4 ">
          <div class="card ">
            <img class="card-img-top " src="http://placehold.it/500x325 " alt=" ">
            <div class="card-body ">
              <h4 class="card-title ">Card title</h4>
              <p class="card-text ">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sapiente esse necessitatibus neque.</p>
            </div>
            <div class="card-footer ">
              <a href="# " class="btn btn-primary ">Comprar</a>
            </div>
          </div>
        </div>

        <div class="col-lg-3 col-md-6 mb-4 ">
          <div class="card ">
            <img class="card-img-top " src="http://placehold.it/500x325 " alt=" ">
            <div class="card-body ">
              <h4 class="card-title ">Card title</h4>
              <p class="card-text ">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Explicabo magni sapiente, tempore debitis beatae culpa natus architecto.</p>
            </div>
            <div class="card-footer ">
              <a href="# " class="btn btn-primary ">Comprar</a>
            </div>
          </div>
        </div>

</div>
