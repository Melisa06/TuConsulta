<%-- 
    Document   : createMedico
    Created on : Aug 20, 2018, 1:26:27 AM
    Author     : Ricardo Camacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<section class="page-section clearfix">
    <div class="container">
        <div class="intro-text left-0 text-center bg-faded p-5 rounded">
            <h2 class="section-heading mb-4">
                <span class="section-heading-upper">Farmacia</span>
                <!--span class="section-heading-lower">Worth Drinking</span-->
            </h2>
            <form action="" method="post" name="FormEntrar">
                <h2 class="section-heading mb-4">
                    <span class="section-heading-lower">Agregar Medico</span>
                </h2>
                <h2 class="section-heading mb-4">
                    <span class="section-heading-upper">Nombre:</span>
                </h2>
                <input type="text" class="form-control" name="txtnombre" placeholder="Nombre" value="">
                <input type="text" class="form-control" name="txtpaterno" placeholder="Paterno" value="">
                <input type="text" class="form-control" name="txtmaterno" placeholder="Materno" value="">
                <br>
                <h2 class="section-heading mb-4">
                    <span class="section-heading-upper">Cedula Professional:</span>
                </h2>
                <input type="text" class="form-control" name="txtCedula" value="">
                <br>
                
                <input type="Submit" value="Aceptar" class="btn btn-primary">
                <input type="button" value="Cancelar" class="btn btn-primary">
            </form>
        </div>
    </div>
</section>
