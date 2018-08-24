<%-- 
    Document   : createConsulta
    Created on : Aug 20, 2018, 3:13:10 AM
    Author     : Ricardo Camacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<section class="page-section about-heading">
    <div class="container">

        <div class="about-heading-content">
            <div class="row">
                <div class="col-xl-9 col-lg-10 mx-auto">
                    <div class="bg-faded rounded p-5">
                        <!--<img class="img-fluid rounded about-heading-img mb-2 mb-lg-0" src="public/img/cita.jpg" alt="" width="500" height="50">-->
                        <form action="" method="post" name="nuevaConsulta">
                            <h2>
                                <span class="section-heading-lower">Agendar cita</span>
                            </h2>
                            <br>
                            <c:if test = "<%= rol == 3%>">
                                <input type="hidden" name="datosPac" value="<%=idUsuario%>">
                            </c:if>
                             <c:if test = "<%= rol == 2%>">
                                <input type="hidden" name="datosMed" value="<%=idUsuario%>">
                            </c:if>
                                
                            <c:if test = "<%= rol == 1 || rol == 3%>">
                                <span class="section-heading-upper">Médico:</span>
                                <select name="datosMed" class="form-control" style="visibility:${styleOcultarDoc}">
                                    <c:forEach var="datosMed" items="${datosMed}">
                                        <option value="${datosMed.id}">${datosMed.nombre}</option>
                                    </c:forEach>
                                </select>
                            </c:if>
                            <br>
                            <c:if test = "<%= rol == 1 || rol == 2%>">
                                <span class="section-heading-upper">Paciente:</span>
                                <select name="datosPac" class="form-control" style="visibility:${visible}">
                                    <c:forEach var="datosPac" items="${datosPac}">
                                        <option value="${datosPac.id}">${datosPac.nombre_pac}</option>
                                    </c:forEach>
                                </select>
                            </c:if>
                                
                            
                            <br>
                            <span class="section-heading-upper">Fecha:</span>
                            <input type="date" class="form-control" name="txtFecha" placeholder="" value="" min="{Fecha actual">
                            <br>
                            <span class="section-heading-upper">Hora:</span>
                            <input type="time" class="form-control" name="txtHora" placeholder="" value="">
                            <br>
                            <input type="Submit" value="Validar disponibilidad" class="btn btn-primary">
                            <input type="button" value="Cancelar" class="btn btn-primary">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

