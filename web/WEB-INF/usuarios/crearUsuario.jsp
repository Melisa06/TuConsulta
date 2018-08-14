<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<form action="crearUsuario" method="POST">
    <input type="email" name="txtEmail" placeholder="correo electrónico">
    <br>
    <input type="password" name="txtPassword" placeholder="contraseña">
    <br>
    <input type="password" name="txtPasswordConfirm" placeholder="confirmar contraseña">
    <br>

    <h4>Tipo de usuario</h4>
    <select name="rol">
        <c:forEach var="rol" items="${roles}">
            <option value="${rol.id}">${rol.nombreRol}</option>
        </c:forEach>
    </select>

    <h4>Permisos</h4>
    Usuarios
    <select name="pUsuarios">
        <option value="3">Sin acceso</option><option value="2">Lectura</option><option value="1">Edición</option>
    </select>
    <br>
    Medicos
    <select name="pMedicos">
        <option value="3">Sin acceso</option><option value="2">Lectura</option><option value="1">Edición</option>
    </select>
    <br>
    Pacientes
    <select name="pPacientes">
        <option value="3">Sin acceso</option><option value="2">Lectura</option><option value="1">Edición</option>
    </select>
    <br>
    Citas
    <select name="pCitas">
        <option value="3">Sin acceso</option><option value="2">Lectura</option><option value="1">Edición</option>
    </select>
    <br>
    Recetas
    <select name="pRecetas">
        <option value="3">Sin acceso</option><option value="2">Lectura</option><option value="1">Edición</option>
    </select>
    <br>
    Medicamentos
    <select name="pMedicamentos">
        <option value="3">Sin acceso</option><option value="2">Lectura</option><option value="1">Edición</option>
    </select>
    <br>
    Venta
    <select name="pVenta">
        <option value="3">Sin acceso</option><option value="2">Lectura</option><option value="1">Edición</option>
    </select>
    <br>
    Proveedores
    <select name="pProveedores">
        <option value="3">Sin acceso</option><option value="2">Lectura</option><option value="1">Edición</option>
    </select>
    <br>
    Sucursales
    <select name="pSucursales">
        <option value="3">Sin acceso</option><option value="2">Lectura</option><option value="1">Edición</option>
    </select>
    <br>
    Almacen
    <select name="pAlmacen">
        <option value="3">Sin acceso</option><option value="2">Lectura</option><option value="1">Edición</option>
    </select>
    <br><br>
    <input type="submit" value="Registrar">

</form>
