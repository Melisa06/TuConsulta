<%-- 
    Document   : listMedico
    Created on : Aug 20, 2018, 1:26:48 AM
    Author     : Ricardo Camacho
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<section class="page-section about-heading">
    <div class="container">
        <div class="about-heading-content">
            <div class="row">
                <div class="col-xl-9 col-lg-10 mx-auto">
                    <div class="bg-faded rounded p-5">
                        <img class="img-fluid rounded about-heading-img mb-3 mb-lg-0" src="img/ac.jpg" alt="" width="900" height="">
                        <!-- Table -->
                        <thead>
                        <table class="table" class="table table-striped table-dark">
                            <br>
                            <br>
                            <div class="intro-button mx-auto">
                                <a class="btn btn-primary " href="agregarVenta">Agregar</a>
                            </div>
                            <tr>
                                <th>
                                    <span class="section-heading-upper">ID Venta</span>
                                </th>
                                <th>
                                    <span class="section-heading-upper">Fecha</span>
                                </th>
                                <th>
                                    <span class="section-heading-upper">Monto</span>
                                </th>
                                 <th>
                                    <span class="section-heading-upper">Estatus</span>
                                </th>

                                <th>
                                    <span class="section-heading-upper"></span>
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                <c:forEach var="usuario" items="${usuarios}"> 
                            <tr>
                                <td>${usuario.idVenta}</td>
                                <td>${usuario.fechaVEnta}</td>
                                <td>${usuario.montoTotal}</td>    
                                <td>${usuario.statusVenta}</td>
                                <td><a class="btn btn-primary " href="detalleMedico">Editar</a></td>                              
                            </tr>
                   </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
