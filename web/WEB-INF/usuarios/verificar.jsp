<%-- 
    Document   : verificar
    Created on : Aug 18, 2018, 4:58:43 PM
    Author     : Ricardo Camacho
--%>

<h1 class="site-heading text-center text-white d-none d-lg-block">
        <span class="site-heading-upper text-primary mb-3">Todos los servicios en un solo lugar</span>
        <span class="site-heading-lower">Farmacia</span>
    </h1>
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark py-lg-4" id="mainNav">
      <div class="container">
        <a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#">Farmacia</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav mx-auto">
            <li class="nav-item active px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="index.html">Conocenos
                <span class="sr-only">(current)</span>
              </a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="WEB-INF/promocion.html">Promociones</a>
            </li>
            <li class="nav-item px-lg-4">
              <a class="nav-link text-uppercase text-expanded" href="login">Login/ Registrarse</a>
            </li>
          </ul>
        </div>
      </div>
</nav>

<section class="page-section clearfix">
  <div class="container">
    <div class="intro">
      <img class="intro-img img-fluid mb-3 mb-lg-0 rounded" src="public/img/intro.jpg" alt="">
      <div class="intro-text left-0 text-center bg-faded p-5 rounded">
            <form action="validar" method="post" name="FormEntrar">
                <h2 class="section-heading mb-4"><a href="#">Iniciar sesion</a></h2>
                <br>
                <input type="hidden" class="" name="txtEmail" value="${email}">
                <input type="password" class="form-control" name="txtPassword" placeholder="contraseña" value="">
                <br>
                <div class="alert alert-danger" style="display: ${error};">
                  Datos no validos
                </div>
                <input type=Submit value="Ingresar" class="btn btn-primary">
                <br>
            </form>
      </div>
    </div>
  </div>
</section>

