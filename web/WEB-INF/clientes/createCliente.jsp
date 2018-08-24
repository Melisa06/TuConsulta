<%-- 
    Document   : ncliente
    Created on : Aug 20, 2018, 1:17:19 AM
    Author     : Ricardo Camacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<<<<<<< HEAD
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
=======
>>>>>>> 7d24ba15b77c251c10d3453b8257027ff0a2ec1a

<section class="page-section about-heading">
    <div class="container">
        <img class="img-fluid rounded about-heading-img mb-3 mb-lg-0" src="public/img/about.jpg" alt="">
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
                            <input type="text" class="form-control" name="txtNombre" placeholder="Nombre" value="${paciente.NombrePaciente}" >
                            <input type="text" class="form-control" name="txtAp" placeholder="Apellido Paterno" value="${paciente.ApellidoPaterno}" >
                            <input type="text" class="form-control" name="txtAm" placeholder="Apellido Materno" value="${paciente.ApellidoMaterno}" >
                            <br>
                            <h2 class="section-heading mb-4">
                                <span class="section-heading-upper">Fecha de nacimiento:</span>
                            </h2>
                            <input type="Date" class="form-control" name="txtFecha" placeholder="FEcha" value="${paciente.FechNac}" >
                            <br>
                            <br>
                            <hr>
                            <h2 class="section-heading mb-4">
                                <span class="section-heading-lower">Datos Médicos</span>
                            </h2>
                            <h2 class="section-heading mb-4">
                                <span class="section-heading-upper">Peso:</span>
                            </h2>

                            <input type="text" class="form-control" name="txtPeso" placeholder="kg" value="${paciente.Peso}" >
                            <br>
                            <h2 class="section-heading mb-4">
                                <span class="section-heading-upper">Estatura:</span>
                            </h2>

                            <input type="text" class="form-control" name="txtEstatura" placeholder="Estatura" value="${paciente.Estatura}" >
                            <br>
                            <h2 class="section-heading mb-4">
                                <span class="section-heading-upper">Alergias:</span>
                            </h2>

                            <input type="text" class="form-control" name="txtAlergia" placeholder="Indique alergias" value="${paciente.Alergias}">
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