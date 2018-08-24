<%-- 
    Document   : createProducto
    Created on : Aug 20, 2018, 1:30:33 AM
    Author     : Ricardo Camacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-dark py-lg-4" id="mainNav">
    <div class="container">
        <a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#">Start Bootstrap</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav mx-auto">
                <li class="nav-item active px-lg-4">
                    <a class="nav-link text-uppercase text-expanded" href="/">Principal
                        <span class="sr-only">(current)</span>

                    </a>
                </li>
                <li class="nav-item px-lg-4">
                    <a class="nav-link text-uppercase text-expanded" href="productos">Productos</a>
                </li>
                <li class="nav-item px-lg-4">
                    <a class="nav-link text-uppercase text-expanded" href="medicos">Medicos</a>
                </li>
                <li class="nav-item px-lg-4">
                <li class="nav-item px-lg-4">
                    <a class="nav-link text-uppercase text-expanded" href="recepcionistas">Recepcionistas</a>
                </li>
                <li class="nav-item px-lg-4">
                <li class="nav-item px-lg-4">
                    <a class="nav-link text-uppercase text-expanded" href="clientes">Clientes</a>
                </li>
                <li class="nav-item px-lg-4">
                <li class="nav-item px-lg-4">
                    <a class="nav-link text-uppercase text-expanded" href="consultas">Consultas</a>
                </li>

                <li class="nav-item px-lg-4">
                <li class="nav-item px-lg-4">

                    <a class="nav-link text-uppercase text-expanded" href="javascript:;" onclick="aviso('../index.html'); return false;">Cerar Sesion</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
 <title>Agregar medicamento</title>
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
                            Id:
                            <input class="form-control" type="text" name="txtid" value="${dato.id}" disabled="">
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
                            <img src ="medicamento_imagenes/${dato.id}.png" width="50" height="40" style="${oculto}">
                    <!--        <img src='medicamento_imagenes/${dato.id}+".png"' ${disponibilidad1}>-->
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


