<%-- 
    Document   : listConsulta
    Created on : Aug 20, 2018, 3:13:02 AM
    Author     : Ricardo Camacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="page-section cta">
    <div class="container">
        <div class="about-heading-content">
            <div class="bg-faded rounded p-5">
                <br>
                <br>
                <div class="intro-button mx-auto">
                    <a class="btn btn-primary " href="nuevaCita">Agregar +</a>
                </div>
                <table class="table" class="table table-striped table-dark">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Fecha Cita</th>
                    <th>Hora Cita</th>
                    <th>Id Paciente</th>
                    <th>Id Medico</th>
                    <th>Estatus</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="citas" items="${citas}">
                    
                <tr>
                    <td>${citas.id}</td>
                    <td>${citas.fechacita}</td>
                    <td>${citas.hr_cita}</td>
                    <td>${citas.id_paciente.nombrePaciente}</td>
                    <td>${citas.id_medico.nombre}</td>
                    <td>${citas.estatus}</td>
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
