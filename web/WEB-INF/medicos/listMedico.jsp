<%-- 
    Document   : listMedico
    Created on : Aug 20, 2018, 1:26:48 AM
    Author     : Ricardo Camacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<section class="page-section about-heading">
    <div class="container">
        <div class="about-heading-content">
            <div class="row">
                <div class="col-xl-9 col-lg-10 mx-auto">
                    <div class="bg-faded rounded p-5">
                        <img class="img-fluid rounded about-heading-img mb-3 mb-lg-0" src="img/ac.jpg" alt="" width="900" height="">
                        <!-- Table -->
                        
                        <div class="intro-button mx-auto">
                            <a class="btn btn-primary " href="nuevoMedico">Agregar +</a>
                        </div>
                        <br>
                        <br>
                        <table class="table" class="table table-striped table-dark">
                            
                            <thead>
                                <tr>
                                    <th>
                                        <span class="section-heading-upper">Nombre</span>
                                    </th>
                                    <th>
                                        <span class="section-heading-upper">Cedula Profesional</span>
                                    </th>
                                    <th>
                                        <span class="section-heading-upper">Opciones</span>
                                    </th>
                                </tr>
                            </thead>
                            
                            <tbody>
                                <c:forEach var="medico" items="${listaMedicos}">
                                    <tr>
                                        <td>
                                            <span class="section-heading-upper">${medico.nombre}  ${medico.paterno}</span>
                                        </td>
                                        <td>
                                            <span class="section-heading-upper">${medico.cedula}</span>
                                        </td>
                                        <td>
                                            <div class="intro-button mx-auto">
                                                <a class="btn btn-primary " href="detalleMedico">Abrir</a>
                                                <a class="btn btn-primary " href="detalleMedico">Editar</a>
                                            </div>
                                        </td>
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
