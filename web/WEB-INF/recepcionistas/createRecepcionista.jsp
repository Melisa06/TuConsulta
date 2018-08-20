<%-- 
    Document   : createRecepcionista
    Created on : Aug 20, 2018, 1:42:47 AM
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

<section class="page-section clearfix">
    <div class="container">
        <div class="intro-text left-0 text-center bg-faded p-5 rounded">
            <h2 class="section-heading mb-4">
                <span class="section-heading-upper">Farmacia</span>
                <!--span class="section-heading-lower">Worth Drinking</span-->
            </h2>
            <form action="" method="post" name="FormEntrar">
                <h2 class="section-heading mb-4">
                    <span class="section-heading-lower"> Agregar Recepcionista</span>
                </h2>
                <h2 class="section-heading mb-4">
                    <span class="section-heading-upper">Nombre:</span>
                </h2>
                <input type="text" class="form-control" name="txtNombre" placeholder="Nombre" value="">
                <input type="text" class="form-control" name="txtAp" placeholder="Apellido Paterno" value="">
                <input type="text" class="form-control" name="txtAm" placeholder="Apellido Materno" value="">
                <br>
                <h2 class="section-heading mb-4">
                    <span class="section-heading-upper">Domicilio:</span>
                </h2>
                <input type="text" class="form-control" name="txtDomi" value="">
                <br>
                <hr>
                <h2 class="section-heading mb-4">
                    <span class="section-heading-upper">Telefono:</span>
                </h2>
                <input type="text" class="form-control" name="txtTelefonoMedico" value="">
                <br>
                <h2 class="section-heading mb-4">
                    <span class="section-heading-upper">Correo :</span>
                </h2>
                <input type="text" class="form-control" name="txtCorreoMedico" value="">
                <br>
                <br>
                <INPUT type="Submit" value="Aceptar" class="btn btn-primary btn-xl">
                <INPUT type="button" value="Cancelar" class="btn btn-primary btn-xl">
            </form>

        </div>
    </div>
</div>
</section>
