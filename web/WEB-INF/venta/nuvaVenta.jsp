<%-- 
    Document   : createMedico
    Created on : Aug 20, 2018, 1:26:27 AM
    Author     : Ricardo Camacho
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="javax.naming.spi.DirStateFactory.Result"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="public/estiloVenta/style.css">
<link rel="stylesheet" href="public/estiloVenta/boton.css">
<link rel="stylesheet" href="public/estiloVenta/colors/green.css" id="colors">

<script type="text/javascript">
                function startTime(){
                today=new Date();
                meses = new Array ("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre");
                h=today.getHours();
                m=today.getMinutes();
                s=today.getSeconds();
                d=today.getDate();
                me=meses[today.getMonth()];
                a=today.getFullYear();
                m=checkTime(m);
                s=checkTime(s);
                document.getElementById('reloj').innerHTML=h+":"+m+":"+s;
                document.getElementById('fecha').innerHTML=d + " de " + me + " del " + a;
                t=setTimeout('startTime()',500);}
                function checkTime(i)
                {if (i<10) {i="0" + i;}return i;}
                window.onload=function(){startTime();}
        
  

              </script>
<section class="page-section clearfix">
    <div class="container">
        <div class="intro-text left-0 text-center bg-faded p-5 rounded">
            <h2 class="section-heading mb-4">
                <span class="section-heading-upper">TU CONSULTA</span>
                <!--span class="section-heading-lower">Worth Drinking</span-->
            </h2>
            <form action="" method="post" name="FormEntrar">
                <h2 class="section-heading mb-4">
                    <span class="section-heading-lower">PUNTO DE VENTA</span>
              
                </h2>
               
                    
                <div id="reloj" style="font-size:20px;"></div>
                <div style="font-size:20px;" id="fecha" ></div><br>                                           
                </div>
            </form>
        </div>
    </div>
    
<div class="container cart">

	<div class="sixteen columns">

		<!-- Cart -->
			<table class="cart-table bottom">

				<tr>
				<th>
					<form action="agregarVentaProducto" method="POST" class="apply-coupo">
                                            <select class="apply-coupo" id="medicamentosVt" name="medicamentosVt">
                                             <c:forEach var="med" items="${medicamentos}"> 
						
                                                    <option value="${med.id}">${med.nombreMedicamento} </option>
							
						
                                               </c:forEach>
						</select>
					<input name="idVentaVal" type="hidden" value="${idVenta}"/>	
					
                                    
					<div>
						
                                            <input class="search-field" type="text" placeholder="Cantidad" name="cantidad" value=""/>
					    
					</div>
                                            
                                            <div class="cart-btns">
                                                <input type="submit" value="Agregar" class="button color cart-btns proceed">
						
                                            </div>
                                            
                                            </form>
					
					

				</th>
				</tr>

			</table>
		<table class="cart-table responsive-table">

			<tr>
				<th>Item</th>
				<th>Descripcion</th>
				<th>Costo</th>
				<th>Cantidad</th>
				<th>Total</th>
				<th></th>
			</tr>
					
			<!-- Item #1 -->
			<tr>
				<td> 1 </td>
				<td class="cart-title"><a href="#">Aspirina</a></td>
				<td>$29.00</td>
				<td>
					<form action='#'>
						
						<input type='text' name="quantity" value='1' class="qty" />
						
					</form>
				</td>
				<td class="cart-total">$29.00</td>
				<td><a href="#" class="cart-remove"></a></td>
				
			</tr>

			<!-- Item #2 -->
			<tr>
				<td> 1 </td>
				<td class="cart-title"><a href="#">Aspirina</a></td>
				<td>$29.00</td>
				<td>
					<form action='#'>
						
						<input type='text' name="quantity" value='1' class="qty" />
						
					</form>
				</td>
				<td class="cart-total">$29.00</td>
				<td><a href="#" class="cart-remove"></a></td>
			</tr>

			</table>

			<!-- Apply Coupon Code / Buttons -->
	
	</div>


	<!-- Cart Totals -->
	<div class="eight columns cart-totals">
		<h3 class="headline">Total Compra</h3><span class="line"></span><div class="clearfix"></div>

		<table class="cart-table margin-top-5">

			<tr>
				<th>Subtotal</th>
				<td><strong>$38.00</strong></td>
			</tr>

			

			<tr>
				<th>Total</th>
				<td><strong>$178.00</strong></td>
			</tr>
			
		</table>

		<br>
		<div class="cart-btns">
						
						<a href="#" class="button gray cart-btns">Pagar</a>
		</div>
		<!-- <a href="#" class="calculate-shipping"><i class="fa fa-arrow-circle-down"></i> Calculate Shipping</a> -->
	</div>

</div>
</div>

</section>
