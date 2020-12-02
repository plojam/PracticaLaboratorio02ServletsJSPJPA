<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Buscar Producto</title>
	<link rel="stylesheet" type="text/css" href="/CitasJPA/CSS/estilos.css">
</head>
<body>

	<% 
		String emp_id = request.getParameter("empresa_id");
		String usu_id = request.getParameter("usuario_id");
	%>
	
	<c:set var="lista" scope="request" value="${productos}"/>
	<c:set var="proBus" scope="request" value="${producto}"/>

	<header>
        <img src="logo_ups.png" alt="Logo" width="700" height="100"/>
        <h2>Buscar Producto</h2>

        <nav id="list_1">
            <ul>
                <li><a href="login.html">Login</a></li>
                <li>Empresas</li>
                <li>Productos</li>
            </ul>
        </nav>
    </header>

    <div class="jump"></div>
    
    <form action="/CitasJPA/BuscarProductosController" method="post">
    	<label for="categoria">Categoria: </label>
    	<select name="categoria">
            <option value="1">Perfumeria</option> 
            <option value="2">Maquillaje</option>
            <option value="3">Moda</option>
        </select>
        
        <input type="text" name="bus" value="cat" style="display:none">
        <input type="text" name="page" value="b" style="display:none">
        <input type="text" value=<%= emp_id %> name="empresa_id" style="display:none">
		<input type="text" value=<%= usu_id %>  name="usuario_id" style="display:none">
        
        <input type="submit" value="Buscar por Categoria">
    </form>
    
    <form action="/CitasJPA/BuscarProductosController" method="post">
    	<label for="nombre">Nombre del Producto: </label>
    	<input type="text" name="nombre">
    	
    	<input type="text" name="bus" value="nom" style="display:none">
        <input type="text" name="page" value="b" style="display:none">
    	<input type="text" value=<%= emp_id %> name="empresa_id" style="display:none">
		<input type="text" value=<%= usu_id %>  name="usuario_id" style="display:none">
    	
    	<input type="submit" value="Buscar por Nombre">
    </form>
    
    <aside id="primer_metodo" style="dyssplay:none">
    	<table>
		<tr>
			<td><strong>Nombre</strong></td>
			<td><strong>Cantidad</strong></td>
			<td><strong>Categoria</strong></td>
		</tr>
		<c:forEach var="pro" items="${lista}">
			<tr>
				<td>${pro.nombre}</td>
				<td>${pro.cantidad}</td>
				<td>${pro.categoria}</td>
			</tr>
		</c:forEach>
		</table>
    </aside>
    
    <aside id="segundo_metodo" style="dyssplay:none">
    	<table>
		<tr>
			<td><strong>Nombre</strong></td>
			<td><strong>Cantidad</strong></td>
			<td><strong>Categoria</strong></td>
		</tr>
		<tr>
			<td>${proBus.nombre}</td>
			<td>${proBus.cantidad}</td>
			<td>${proBus.categoria}</td>
		</tr>
		</table>
    </aside>
    
    <form action="/CitasJPA/BuscarUsuarioAdmin" method="post">
    	<input type="text" name="emp_id" value=<%= emp_id %>  style="display:none">
		<input type="text" name="usu_id" value=<%= usu_id %>  style="display:none">
		<input type="submit" value="Regresar a Inicio">
    </form>
</body>

<footer>
	<fieldset>
        <legend>Institucion</legend>
        <span>
          Universidad: Universidad Politecnica Salesiana<br>
          Sede: Cuenca<br>
          Periodo: 57<br>
        </span>
    </fieldset>

    <fieldset>
        <legend>Contacto</legend>
        <span>
          Autores: Robbyn Taurino Reyes Duchitanga<br>
          Correo: <a href="mailto:rreyesd@est.ups.edu.ec">rreyesd@est.ups.edu.ec</a><br>
          Telefono: <a href="tel:+0969784090">0969784090</a><br>
        </span>
    </fieldset>
</footer>
</html>