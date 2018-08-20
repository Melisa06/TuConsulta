<%-- 
    Document   : ncliente
    Created on : Aug 20, 2018, 1:17:19 AM
    Author     : Ricardo Camacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<section class="page-section about-heading">
    <div class="container">
        <img class="img-fluid rounded about-heading-img mb-3 mb-lg-0" src="public/img/about.jpg" alt="">
        <div class="about-heading-content">
            <div class="row">
                <div class="col-xl-9 col-lg-10 mx-auto">
                    <div class="bg-faded rounded p-5">
                        <form action="" method="post" name="FormEntrar">
                            <h2 class="section-heading mb-4">
                                <span class="section-heading-lower">Perfil</span>
                            </h2>
                            <h2 class="section-heading mb-4">
                                <span class="section-heading-upper">Nombre:</span>
                            </h2>
                            <input type="text" class="form-control" name="txtNombre" placeholder="Nombre" value="" >
                            <input type="text" class="form-control" name="txtAp" placeholder="Apellido Paterno" value="" >
                            <input type="text" class="form-control" name="txtAm" placeholder="Apellido Materno" value="" >
                            <br>
                            <h2 class="section-heading mb-4">
                                <span class="section-heading-upper">Curp:</span>
                            </h2>
                            <input type="text" class="form-control" name="txtCurp" placeholder="Curp" value="" >
                            <br>
                            <br>
                            <h2 class="section-heading mb-4">
                                <span class="section-heading-upper">Domicilio:</span>
                            </h2>

                            <input type="text" class="form-control" name="txtDomi" placeholder="Domicilio" value="" >
                            <br>
                            <hr>
                            <h2 class="section-heading mb-4">
                                <span class="section-heading-lower">Datos Médicos</span>
                            </h2>
                            <h2 class="section-heading mb-4">
                                <span class="section-heading-upper">Peso:</span>
                            </h2>

                            <input type="text" class="form-control" name="txtPeso" placeholder="kg" value="" >
                            <br>
                            <h2 class="section-heading mb-4">
                                <span class="section-heading-upper">Estatura:</span>
                            </h2>

                            <input type="text" class="form-control" name="txtEstatura" placeholder="Estatura" value="" >
                            <br>
                            <h2 class="section-heading mb-4">
                                <span class="section-heading-upper">Alergias:</span>
                            </h2>

                            <input type="text" class="form-control" name="txtAlergia" placeholder="Indique alergias" value="" >
                            <br>
                            <INPUT type="Submit" value="Actualizar Datos" class="btn btn-primary btn-xl">
                            <INPUT type="button" value="Eliminar Cuenta" class="btn btn-primary btn-xl">
                            
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>