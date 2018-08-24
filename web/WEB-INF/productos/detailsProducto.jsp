<%-- 
    Document   : detailsProducto
    Created on : Aug 20, 2018, 1:30:44 AM
    Author     : Ricardo Camacho
--%>

<%-- 
    Document   : createProducto
    Created on : Aug 20, 2018, 1:30:33 AM
    Author     : Ricardo Camacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 

<script>

      var loadFile = function(event) {
        var reader = new FileReader();
        reader.onload = function(){
          var output = document.getElementById('output');
           var img = document.getElementById('img64');
          
          output.src = reader.result;
          img.value = reader.result;
          
        };
        reader.readAsDataURL(event.target.files[0]);
      };

    </script>


<section class="page-section about-heading">
    <div class="container">
        <img class="img-fluid rounded about-heading-img mb-3 mb-lg-0" src="img/about.jpg" alt="">
        <div class="about-heading-content">
            <div class="row">
                <div class="col-xl-9 col-lg-10 mx-auto">
                    <div class="bg-faded rounded p-5">
                        <h2> ${titulo} </h2>
                        <form method="POST" action="medicamento" >
                        	<input type="hidden" name="txtid" value="${dato.id}" disabled>
                            <br>
                            Nombre:
                            <input class="form-control" type="text" name="txtnombre" value="${dato.nombreMedicamento}" ${disponibilidad1} disabled>

                            <input class="form-control" type="hidden" name="txtNombreAnterior" value="${dto.nombreAnterior}"disabled>

                            <br>
                            Descripcion:
                            <input class="form-control" type="text" name="txtdescripcion" value="${dato.descripcion}" ${disponibilidad1} disabled >

                            <br>
                            Stock:
                            <input class="form-control" type="text" name="txtStock" value="${dato.stock}" ${disponibilidad1} disabled>

                            <br>
                            Precio:
                            <input class="form-control" type="text" name="txtprecio" value="${dato.precio}" ${disponibilidad1} disabled>

                            <br>  
                            Imagen:
                            <img src ="medicamentos_imagenes/${dato.id}.png" width="50" height="40" style="${oculto}" >
                    <!--        <img src='medicamentos_imagenes/${dato.id}+".png"' ${disponibilidad1}>-->
                            <br>
                            
                            <br>
                            <!--        Status:-->
                            <input class="form-control" type="hidden" name="txtstatus" value="true" readonly="readonly" />
                            <br>
                            <!--        Fecha
                                    <input type="date" name="txtfecha" >-->
                            <input class="form-control" type="submit" value="Cerar"> 
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


