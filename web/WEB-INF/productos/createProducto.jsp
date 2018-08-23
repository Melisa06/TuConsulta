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
                        <form method="POST" action="${accion}" >
                            <br>
                            Nombre:
                            <input class="form-control" type="text" name="txtnombre" value="${dato.nombreMedicamento}" ${disponibilidad1}>

                            <input class="form-control" type="hidden" name="txtNombreAnterior" value="${dto.nombreAnterior}">

                            <br>
                            Descripcion:
                            <input class="form-control" type="text" name="txtdescripcion" value="${dato.descripcion}" ${disponibilidad1} >

                            <br>
                            Stock:
                            <input class="form-control" type="text" name="txtStock" value="${dato.stock}" ${disponibilidad1}>

                            <br>
                            Precio:
                            <input class="form-control" type="text" name="txtprecio" value="${dato.precio}" ${disponibilidad1}>

                            <br>  
                            Imagen:
                            <img src ="medicamentos_imagenes/${dato.id}.png" width="50" height="40" style="${oculto}">
                    <!--        <img src='medicamentos_imagenes/${dato.id}+".png"' ${disponibilidad1}>-->
                            <br>
                            <img id="output"/>                       
                            <input class="form-control" type="file" name="imagen"  accept="image/*" onchange="loadFile(event)">           
                            <input class="form-control" type="hidden" name="img64" id="img64"   />

                            <br>
                            <!--        Status:-->
                            <input class="form-control" type="hidden" name="txtstatus" value="true" readonly="readonly" />
                            <br>
                            <!--        Fecha
                                    <input type="date" name="txtfecha" >-->
                            <input class="form-control" type="submit" value="${textoboton}"> 
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>


