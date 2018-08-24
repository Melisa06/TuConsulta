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
                        <span class="section-heading-lower">Generar receta</span>
                        <form action="nueva_receta" method="post" name="FormReceta">
                            <span class="section-heading-upper">Paciente: </span>
                            <select name="txtpaciente" class="form-control">
                                <c:forEach var="paciente" items="${pacientes}" >
                                    <option value="${paciente.id}"  >${paciente.nombre}</option>
                                </c:forEach> 

                            </select>

                            <h2 class="section-heading mb-4">
                                <span class="section-heading-upper">Fecha y hora: </span>
                                <input type="text" class="form-control" name="txtfecha" placeholder="10:00 am  25/sep/2018" value="${fecha}" >          

                                <div class="intro-button mx-auto">
                                    <a class="btn btn-primary " href="formRecepcionista.html">Agregar +</a>
                                </div>
                                <h2>Ingresar medicamentos</h2>
                                <table class="table"   class= "table table-striped table-dark">

                                    <tr>
                                        <th>
                                            <span class="section-heading-upper">N°</span>
                                        </th>
                                        <th>   
                                            <span class="section-heading-upper">Nombre </span>
                                        </th>
                                        <th> 
                                            <span class="section-heading-upper">Cantidad</span>
                                        </th>
                                        <th> 
                                            <span class="section-heading-upper">Dosis</span>
                                        </th>
                                        <th>  
                                            <span class="section-heading-upper">Opciones</span>
                                        </th>
                                    </tr>
                                    <tr>
                                        <th> 
                                            <span class="section-heading-upper">1</span>
                                        </th>
                                        <th>
                                            <span class="section-heading-upper">Diclofenaco</span>
                                        </th>
                                        <th>
                                            <span class="section-heading-upper">2</span>
                                        </th>
                                        <th>
                                            <span class="section-heading-upper">1 cada 8 horas</span>
                                        </th>
                                        <th>
                                            <div class="intro-button mx-auto">
                                                <a class="btn btn-primary " href="formRecepcionista.html">Eliminar</a>
                                            </div>
                                        </th>
                                    </tr>
                                </table>
                                
                                <h2 class="section-heading mb-2">
                                    <span class="section-heading-upper">Observaciones</span>
                                </h2>
                                <input type="text" class="form-control" name="txtObservaciones" placeholder="Observaciones" value="" size="190">
                                <br>

                                <input type="Submit" value="Generar Receta" class="btn btn-primary">
                                PDF
                                <input type="Submit" value="cancelar" class="btn btn-primary">



                                </form>
                                </div>
                                </div>
                                </div>
                                </div>
                                </div>
                                </section>
