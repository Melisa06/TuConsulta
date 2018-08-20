<%-- 
    Document   : lclientes
    Created on : Aug 20, 2018, 1:10:35 AM
    Author     : Ricardo Camacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


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
