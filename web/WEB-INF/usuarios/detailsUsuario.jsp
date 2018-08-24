<%-- 
    Document   : detailsUsuario
    Created on : Aug 20, 2018, 8:01:50 PM
    Author     : Ricardo Camacho
--%>

<section class="page-section clearfix">
    <div class="container">
        <div class="intro-text left-0 text-center bg-faded p-5 rounded">
            <h2 class="section-heading mb-4">
                <span class="section-heading-upper">Actualizar Usuario</span>
            </h2>
            <form action="editarUsuario" method="POST">
                <table class="table table-borderless" style="width:100%;">
                    <tr>
                        <td width="40%"></td>
                        <td width="30%"></td>
                        <td width="30%"></td>
                    </tr>
                    <tr>
                        <td align="left">
                            <h5>Tipo de usuario</h5>
                            <br><br>
                            <select name="rol" class="form-control" value="${usuario.idPermiso.id}">
                                <c:forEach var="rol" items="${roles}">
                                    <option value="${rol.id}">${rol.nombreRol}</option>
                                </c:forEach>
                            </select>
                            <br>
                            <input type="hidden" name="idUsuario" value="${usuario.id}">
                            <input class="form-control" type="email" name="txtEmail" placeholder="correo electrónico" value="${usuario.email}" disabled>
                            <br>
                        </td>
                        <td align="left">
                            <h5>Permisos</h5>
                            <br>
                            Usuarios
                            <select name="pUsuarios" class="form-control" value="${usuario.idPermiso.usuarios}">
                                <option value="3" <c:if test = "${usuario.idPermiso.usuarios == 3}">selected</c:if> >Sin acceso</option>
                                <option value="2" <c:if test = "${usuario.idPermiso.usuarios == 2}">selected</c:if> >Lectura</option>
                                <option value="1" <c:if test = "${usuario.idPermiso.usuarios == 1}">selected</c:if> >Edición</option>
                            </select>
                            <br>
                            Medicos
                            <select name="pMedicos" class="form-control" value="${usuario.idPermiso.medicos}">
                                <option value="3" <c:if test = "${usuario.idPermiso.medicos == 3}">selected</c:if> >Sin acceso</option>
                                <option value="2" <c:if test = "${usuario.idPermiso.medicos == 2}">selected</c:if> >Lectura</option>
                                <option value="1" <c:if test = "${usuario.idPermiso.medicos == 1}">selected</c:if> >Edición</option>
                            </select>
                            <br>
                            Pacientes
                            <select name="pPacientes" class="form-control">
                                <option value="3" <c:if test = "${usuario.idPermiso.pacientes == 3}">selected</c:if> >Sin acceso</option>
                                <option value="2" <c:if test = "${usuario.idPermiso.pacientes == 2}">selected</c:if> >Lectura</option>
                                <option value="1" <c:if test = "${usuario.idPermiso.pacientes == 1}">selected</c:if> >Edición</option>
                            </select>
                            <br>
                            Citas
                            <select name="pCitas" class="form-control" value="${usuario.idPermiso.citas}">
                                <option value="3" <c:if test = "${usuario.idPermiso.citas == 3}">selected</c:if> >Sin acceso</option>
                                <option value="2" <c:if test = "${usuario.idPermiso.citas == 2}">selected</c:if> >Lectura</option>
                                <option value="1" <c:if test = "${usuario.idPermiso.citas == 1}">selected</c:if> >Edición</option>
                            </select>
                            <br>
                            Recetas
                            <select name="pRecetas" class="form-control" value="${usuario.idPermiso.recetas}">
                                <option value="3" <c:if test = "${usuario.idPermiso.recetas == 3}">selected</c:if> >Sin acceso</option>
                                <option value="2" <c:if test = "${usuario.idPermiso.recetas == 2}">selected</c:if> >Lectura</option>
                                <option value="1" <c:if test = "${usuario.idPermiso.recetas == 1}">selected</c:if> >Edición</option>
                            </select>
                        </td>
                        <td align="left">
                            <br><br>
                            Medicamentos
                            <select name="pMedicamentos" class="form-control" value="${usuario.idPermiso.medicamentos}">
                                <option value="3" <c:if test = "${usuario.idPermiso.medicamentos == 3}">selected</c:if> >Sin acceso</option>
                                <option value="2" <c:if test = "${usuario.idPermiso.medicamentos == 2}">selected</c:if> >Lectura</option>
                                <option value="1" <c:if test = "${usuario.idPermiso.medicamentos == 1}">selected</c:if> >Edición</option>
                            </select>
                            <br>
                            Venta
                            <select name="pVenta" class="form-control" value="${usuario.idPermiso.venta}">
                                <option value="3" <c:if test = "${usuario.idPermiso.venta == 3}">selected</c:if> >Sin acceso</option>
                                <option value="2" <c:if test = "${usuario.idPermiso.venta == 2}">selected</c:if> >Lectura</option>
                                <option value="1" <c:if test = "${usuario.idPermiso.venta == 1}">selected</c:if> >Edición</option>
                            </select>
                            <br>
                            Proveedores
                            <select name="pProveedores" class="form-control" value="${usuario.idPermiso.proveedores}">
                                <option value="3" <c:if test = "${usuario.idPermiso.proveedores == 3}">selected</c:if> >Sin acceso</option>
                                <option value="2" <c:if test = "${usuario.idPermiso.proveedores == 2}">selected</c:if> >Lectura</option>
                                <option value="1" <c:if test = "${usuario.idPermiso.proveedores == 1}">selected</c:if> >Edición</option>
                            </select>
                            <br>
                            Sucursales
                            <select name="pSucursales" class="form-control" value="${usuario.idPermiso.sucursales}">
                                <option value="3" <c:if test = "${usuario.idPermiso.sucursales == 3}">selected</c:if> >Sin acceso</option>
                                <option value="2" <c:if test = "${usuario.idPermiso.sucursales == 2}">selected</c:if> >Lectura</option>
                                <option value="1" <c:if test = "${usuario.idPermiso.sucursales == 1}">selected</c:if> >Edición</option>
                            </select>
                            <br>
                            Almacen
                            <select name="pAlmacen" class="form-control" value="${usuario.idPermiso.almacen}">
                                <option value="3" <c:if test = "${usuario.idPermiso.almacen == 3}">selected</c:if> >Sin acceso</option>
                                <option value="2" <c:if test = "${usuario.idPermiso.almacen == 2}">selected</c:if> >Lectura</option>
                                <option value="1" <c:if test = "${usuario.idPermiso.almacen == 1}">selected</c:if> >Edición</option>
                            </select>
                            <br>
                            Compra
                            <select name="pCompra" class="form-control" value="${usuario.idPermiso.compra}">
                                <option value="3" <c:if test = "${usuario.idPermiso.compra == 3}">selected</c:if> >Sin acceso</option>
                                <option value="2" <c:if test = "${usuario.idPermiso.compra == 2}">selected</c:if> >Lectura</option>
                                <option value="1" <c:if test = "${usuario.idPermiso.compra == 1}">selected</c:if> >Edición</option>
                            </select>
                        </td>
                    </tr>
                </table>
                    <button class="btn btn-info" type="submit">Actualizar</button>
                    <a href="usuarios" class="btn btn-info">Cancelar</a>
            </form>
        </div>
    </div>
</section>