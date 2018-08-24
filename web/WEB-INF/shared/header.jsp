<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="modelo.dto.PermisoDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TuConsulta</title>

        <link href="public/css/bootstrap.min.css" rel="stylesheet">

        <!-- Custom fonts for this template -->
        <link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i" rel="stylesheet">

        <link href="public/css/business-casual.min.css" rel="stylesheet">

        <link href="public/css/site.css" rel="stylesheet">
        
        <script src="public/js/jquery.min.js"></script>
    </head>
    <body>

        <%
            //1;"admin"
            //2;"médico"
            //3;"paciente"
            //4;"recepcionista"
            HttpSession sesion = request.getSession();
            int rol;
            int idUsuario;
            PermisoDTO datos;
            if (sesion.getAttribute("datos") != null) {
                datos = (PermisoDTO) sesion.getAttribute("datos");
                rol = datos.getIdRol().getId();
                idUsuario = datos.getIdUsuario();
                //System.out.println(rol);
            }
            else{
                datos = null;
                idUsuario = 0;
                rol = 0;
                //response.sendRedirect("inicio");
            }
        %>
        
        <c:if test = "${title == 'login'}">
            <% rol = 4; %>
        </c:if>
        
        <c:if test = "<%= rol == 0%>">
            <% response.sendRedirect("inicio"); %>
        </c:if>
        
        <c:if test = "<%= rol == 1%>">
            <nav class="navbar navbar-expand-lg navbar-dark py-lg-4" id="mainNav">
                <div class="container">
                    <a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#">Start Bootstrap</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarResponsive">
                        <ul class="navbar-nav mx-auto">
                            <li class="nav-item active px-lg-4">
                                <a class="nav-link text-uppercase text-expanded" href="inicio">Principal
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
                                <a class="nav-link text-uppercase text-expanded" href="clientes">Pacientes</a>
                            </li>
                            <li class="nav-item px-lg-4">
                                <a class="nav-link text-uppercase text-expanded" href="citas">Citas</a>
                            </li>
                            <li class="nav-item px-lg-4">
                                <a class="nav-link text-uppercase text-expanded" href="usuarios">Usuarios</a>
                            </li>
                            <li class="nav-item px-lg-4">
                                <a class="nav-link text-uppercase text-expanded" href="venta">Venta</a>
                            </li>
                            <li class="nav-item px-lg-4">
                                <a class="nav-link text-uppercase text-expanded" href="logout">Cerrar Sesión</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </c:if>

        <c:if test = "<%= rol == 2%>">
            <nav class="navbar navbar-expand-lg navbar-dark py-lg-4" id="mainNav">
                <div class="container">
                    <a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#">Start Bootstrap</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarResponsive">
                        <ul class="navbar-nav mx-auto">
                            <li class="nav-item active px-lg-4">
                                <a class="nav-link text-uppercase text-expanded" href="inicio">Perfil
                                    <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li class="nav-item px-lg-4">
                                <a class="nav-link text-uppercase text-expanded" href="citas">Citas </a>
                            </li>
                            <li class="nav-item px-lg-4">
                                <a class="nav-link text-uppercase text-expanded" href="medicamento">Productos</a>
                            </li>
                            <li class="nav-item px-lg-4">
                                <a class="nav-link text-uppercase text-expanded" href="clientes">Mis pacientes</a>
                            </li>
                            <li class="nav-item px-lg-4">
                                <a class="nav-link text-uppercase text-expanded" href="venta">Venta</a>
                            </li>
                            <li class="nav-item px-lg-4">
                                <a class="nav-link text-uppercase text-expanded" href="logout">Cerar Sesion</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </c:if>

        <c:if test = "<%= rol == 3%>">
            <nav class="navbar navbar-expand-lg navbar-dark py-lg-4" id="mainNav">
                <div class="container">
                    <a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#">Start Bootstrap</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarResponsive">
                        <ul class="navbar-nav mx-auto">
                            <li class="nav-item active px-lg-4">
                                <a class="nav-link text-uppercase text-expanded" href="inicio">Perfil
                                    <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li class="nav-item px-lg-4">
                                <a class="nav-link text-uppercase text-expanded" href="citas">Agendar Cita</a>
                            </li>
                            <li class="nav-item px-lg-4">
                                <a class="nav-link text-uppercase text-expanded" href="medicamento">Productos</a>
                            </li>
                            <li class="nav-item px-lg-4">
                                <a class="nav-link text-uppercase text-expanded" href="historial">Mi historial</a>
                            </li>
                            <li class="nav-item px-lg-4">
                                <a class="nav-link text-uppercase text-expanded" href="logout">Cerar Sesion</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </c:if>
        
