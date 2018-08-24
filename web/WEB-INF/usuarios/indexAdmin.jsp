<%-- 
    Document   : indexAdmin
    Created on : Aug 19, 2018, 12:08:48 PM
    Author     : Ricardo Camacho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<section class="page-section cta">
    <div class="container">
        <div class="row">
            <div class="col-xl-9 mx-auto">
                <div class="cta-inner text-center rounded">
                    <h2 class="section-heading mb-4">
                        <!--span class="section-heading-upper">Our Promise</span-->
                        <img class="img-fluid rounded about-heading-img mb-3 mb-lg-0" src="img/a.jpg" alt="" width="1000" height="">
                        <span class="section-heading-lower"> MISION</span>
                    </h2>
                    <p class="mb-0">Mejorar la calidad de vida de nuestros clientes, a través del mejor nivel de servicio y precios competitivos. Innovar continuamente orientando nuestro esfuerzo en ser la mejor alternativa en Farmacia, para así siempre superar las expectativas de nuestros Clientes. !</p>
                    <h2 class="section-heading mb-4">
                        <!--span class="section-heading-upper">Our Promise</span-->
                        <span class="section-heading-lower"> VISION</span>
                    </h2>
                    <p class="mb-0">Ser líderes Centroamericanos en el comercio especializado de Farmacia que es nuestro negocio principal, así como productos de cuidado personal y de consumo brindando la mejor experiencia de compra, conveniencia y seguridad.</p>
                </div>
            </div>
        </div>
    </div>
</section>


<script language="JavaScript">
    function aviso(url) {
        if (!confirm("Seguro que desea salir?.")) {
            return false;
        } else {
            document.location = url;
            return true;
        }
    }
</script>