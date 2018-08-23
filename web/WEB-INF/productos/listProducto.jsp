<%-- 
    Document   : listProducto
    Created on : Aug 20, 2018, 1:30:52 AM
    Author     : Ricardo Camacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="page-section about-heading">
    <div class="container">
        <img class="img-fluid rounded about-heading-img mb-3 mb-lg-0" src="public/img/about.jpg" alt="">
        <div class="about-heading-content">
            <div class="row">
                <div class="mx-auto">
                    <div class="bg-faded rounded p-5">
                        <h2>Productos</h2>
                        <a href="nuevo_medicamento">
                            <input type="submit" class="btn btn-success btn-sm" value="Nuevo medicamento" name="btnNuevo"
                                   onClick="document.location = 'nuevo_medicamento';"/>

                        </a>
                        <br><br>
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>NOMBRE</th>
                                    <th>DESCRIPCION</th>
                                    <th>FECHA</th>
                                    <th>PRECIO</th>
                                    <th>STOCK</th>
                                    <th>IMAGEN</th>
                                    <th>ESTATUS</th>
                                    <th>OPCIONES</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="medicamentos" items="${medicamento}">
                                    <tr>
                                        <td>${medicamentos.id}</td>
                                        <td>${medicamentos.nombreMedicamento}</td>
                                        <td>${medicamentos.descripcion}</td>
                                        <td>${medicamentos.fechaActualizacion}</td>
                                        <td>${medicamentos.precio}</td>
                                        <td>${medicamentos.stock}</td>
                                        <td><img src ="medicamentos_imagenes/${medicamentos.id}.png" width="50" height="40"></td>
                                        <td>${medicamentos.estatus}</td>
                                        <td>
                                            <input class="btn btn-warning btn-sm" type="submit" value="Eliminar" name="btnBorrar"
                                                   onClick="document.location = 'borrar_medicamento?n=${medicamentos.id}';"/>
                                            <input class="btn btn-success btn-sm" type="submit" value="Actualizar" name="btnActualizar"
                                                   onClick="document.location = 'editar_medicamento?n=${medicamentos.id}';"/>
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
