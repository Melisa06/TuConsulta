<%-- 
    Document   : listUsuario
    Created on : Aug 20, 2018, 8:01:33 PM
    Author     : Ricardo Camacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<br>
<section class="page-section about-heading">
    <div class="container">
        <div class="about-heading-content">
            <div class="row">
                <div class="mx-auto">
                    <div class="bg-faded rounded p-5">
                        <img class="img-fluid rounded about-heading-img mb-3 mb-lg-0" src="img/ac.jpg" alt="" width="900" height="">
                        <h4 align="center">
                            <span class="section-heading-upper">Usuarios</span>
                        </h4>
                        <br>
                        <div class="alert ${alert}" style="display: ${success};">
                            ${mensaje}
                        </div>
                        <div class="intro-button mx-auto">
                            <a class="btn btn-success btn-sm" href="crearUsuario">Agregar</a>
                        </div>
                        <br>
                        <table class="table table-bordered" class="table table-striped table-dark">
                            <thead>
                                <tr>
                                    <th>
                                        <span class="section-heading-upper">Correo electrónico</span>
                                    </th>
                                    <th>
                                        <span class="section-heading-upper">Ultima fecha de ingreso</span>
                                    </th>
                                    <th>
                                        <span class="section-heading-upper">Rol</span>
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
                                        <th>
                                            <span class="section-heading-upper">${usuario.email}</span>
                                        </th>
                                        <th>
                                            <span class="section-heading-upper">${usuario.fechaIngreso}</span>
                                        </th>
                                        <th>
                                            <span class="section-heading-upper">${usuario.idPermiso.idRol.nombreRol}</span>
                                        </th>
                                        <th>
                                            <c:if test = "${usuario.estatus == true}">
                                                <span class="section-heading-upper">Activo</span>
                                            </c:if>
                                            <c:if test = "${usuario.estatus == false}">
                                                <span class="section-heading-upper">Inactivo</span>
                                            </c:if>
                                        </th>
                                        <th>
                                            <div class="intro-button mx-auto">
                                                <button class="btn btn-primary btn-sm" onclick="document.location = 'editarUsuario?id=${usuario.id}';">Editar</button>
                                                
                                                <c:if test = "${usuario.estatus == true}">
                                                    <button class="btn btn-warning btn-sm" onclick="document.location = 'estatusUsuario?id=${usuario.id}';">Bloquear</button>
                                                </c:if>
                                                <c:if test = "${usuario.estatus == false}">
                                                    <button class="btn btn-success btn-sm" onclick="document.location = 'estatusUsuario?id=${usuario.id}';">Activar</button>
                                                </c:if>
                                            </div>
                                        </th>
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