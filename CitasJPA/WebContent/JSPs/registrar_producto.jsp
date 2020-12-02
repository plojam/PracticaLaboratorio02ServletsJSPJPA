<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Registrar Producto</title>
	<link rel="stylesheet" type="text/css" href="/CitasJPA/CSS/estilos.css">
</head>
<body>
	<% 
		String emp_id = request.getParameter("empresa_id");
		String usu_id = request.getParameter("usuario_id");
	%>

	<header>
        <img src="logo_ups.png" alt="Logo" width="700" height="100"/>
        <h2>Menu de Inicio</h2>

        <nav id="list_1">
            <ul>
                <li><a href="login.html">Login</a></li>
                <li>Empresas</li>
                <li>Productos</li>
            </ul>
        </nav>
    </header>

    <div class="jump"></div>

	<div id=opcion1>
        <h1>Agregar Productos</h1>

        <form action="/CitasJPA/RegistrarProductosController" method="post">
            <label for="nombre">Nombre del Producto: </label>
            <input type="text" name="nombre">

            <label for="cantidad">Cantidad en Stock: </label>
            <input type="text" name="cantidad">

            <label for="categoria">Categoria: </label>
            <select name="categoria">
                <option value="1">Perfumeria</option> 
                <option value="2">Maquillaje</option>
                <option value="3">Moda</option>
            </select>

			<input type="text" value=<%= emp_id %> name="empresa_id" style="display:none">
			<input type="text" value=<%= usu_id %>  name="usuario_id" style="display:none">

            <input type="submit" value="Registrar Producto">
        </form>
    </div>
    
    <br>
    
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