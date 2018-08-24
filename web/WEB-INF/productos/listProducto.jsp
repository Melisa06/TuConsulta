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

                                              <c:if test='${medicamentos.estatus == true}'>
                                            <input class="btn btn-warning btn-sm" type="submit" value="Eliminar" name="btnBorrar"
                                                   onClick="document.location = 'borrar_medicamento?n=${medicamentos.id}';"/>
                                               </c:if>
                                                <c:if test='${medicamentos.estatus == false}'>
                                                <input class="btn btn-warning btn-sm" type="submit" value="Eliminar" name="btnBorrar"
                                                   onClick="document.location = 'activar_medicamento?n=${medicamentos.id}';"/>
                                               </c:if>
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
<<<<<<< HEAD

<div class="row text-center">

      <div class="col-lg-3 col-md-6 mb-4">
        <div class="card">
          <c:forEach var="medicamentos" items="${medicamento}">
            <img src ="medicamento_imagenes/${medicamentos.id}.png" width="50" height="40">
                
          <div class="card-body">
            <h4 class="card-title"><td>${medicamentos.nombreMedicamento}</td></h4>
            <p class="card-text">Clave: ${medicamentos.id}</p>
            <p class="card-text">${medicamentos.descripcion}</p>
            <p class="card-text">${medicamentos.fechaActualizacion}</p>
             <p class="card-text">Disponibles: ${medicamentos.stock} pzas</p>
               <p class="card-text">Precio sugerido :$ ${medicamentos.precio}</p>
           
          </div>
          <div class="card-footer">
<c:if test='${medicamentos.estatus == true}'>
                                
                                <a href="#" class="btn btn-primary"  name="btnActivar"  onClick="document.location = 'borrar_medicamento?n=${medicamentos.id}';">Eliminar</a>
                            </c:if>
                             <c:if test='${medicamentos.estatus == false}'>
                               <a href="#" class="btn btn-primary"  name="btnActivar"  onClick="document.location = 'activar_medicamento?n=${medicamentos.id}';">Acivar</a>

                                 
                             </c:if>
                      
   <a href="#" class="btn btn-primary"  name="btnActualizar" onClick="document.location = 'editar_medicamento?n=${medicamentos.id}';">Actualizar</a>

                            
                        
                  
                    
                </c:forEach>

          
          
          </div>
        </div>
     </div>
</c:forEach>

   

</div>
=======
>>>>>>> 7d24ba15b77c251c10d3453b8257027ff0a2ec1a
