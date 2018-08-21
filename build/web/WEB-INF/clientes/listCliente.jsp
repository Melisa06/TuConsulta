<%-- 
    Document   : lclientes
    Created on : Aug 20, 2018, 1:10:35 AM
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
        <div class="about-heading-content">
            <div class="bg-faded rounded p-5">
                <img class="img-fluid rounded about-heading-img mb-3 mb-lg-0" src="public/img/ad.jpg" alt="" width="1000" height="">
                <!-- Table -->
                <br>
                <br>
                <div class="intro-button mx-auto">
                    <a class="btn btn-primary " href="nuevoCliente">Agregar +</a>
                </div>
                <table class="table" class="table table-striped table-dark">
                    <tr>
                        <th>
                            <span class="section-heading-upper">Fecha de ingreso</span>
                        </th>
                        <th>
                            <span class="section-heading-upper">Nombre :</span>
                        </th>
                        <th>
                            <span class="section-heading-upper">Curp</span>
                        </th>
                        <th>
                            <span class="section-heading-upper">Domicilio</span>
                        </th>
                        <th>
                            <span class="section-heading-upper">Opciones</span>
                        </th>
                    </tr>
                    <tr>
                        <th>
                            <span class="section-heading-upper">6/ JUNIO / 2018</span>

                        </th>
                        <th>
                            <span class="section-heading-upper">Juan Perez Lopez</span>

                        </th>
                        <th>
                            <span class="section-heading-upper">PELJ670809HGTRPN02</span>

                        </th>
                        <th>
                            <span class="section-heading-upper">Calle 5 de mayo, Pueblito Corregidora, Santiago de Queretaro C.p 65688</span>
                        </th>
                        <th>
                            <div class="intro-button mx-auto">
                                <a class="btn btn-primary " href="detalleCliente">Abrir</a>
                                <a class="btn btn-primary " href="historialCliente">Ver historial</a>
                                <a class="btn btn-primary " href="borrarCliente">Eliminar</a>
                            </div>
                        </th>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</section>
