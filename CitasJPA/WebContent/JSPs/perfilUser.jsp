<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Perfil User</title>
	<link rel="stylesheet" type="text/css" href="/CitasJPA/CSS/perfil.css">
</head>
<body>
	<c:set var="usuN" scope="request" value="${usuario}" />
	
	<header>
		<h1>Usuario</h1>		
		<hr color="#313b4a" width="98%">
		<h3 class="datos">Id: </h3><h3 class="datos2">${usuN.id}</h3>
		<h3 class="datos">Nombre: </h3><h3 class="datos2">${usuN.nombre}</h3>
		<h3 class="datos">Apellido: </h3><h3 class="datos2">${usuN.apellido}</h3>
	</header>
	
		
	
	<h2> Actividades de usuario </h2>
	
	<form action="/CitasJPA/RegistrarCompraController" method="post">
		<input type="text" name="usuario_id" value="${usuN.id}" style="display:none">
		<input type="submit" value="Registrar Compra">
	</form>
	
	<form action="/CitasJPA/ModificarCompraController" method="post">
		<input type="text" name="usuario_id" value="${usuN.id}" style="display:none">
		<input type="submit" value="Modificar Compra">
	</form>
	
	<form action="/CitasJPA/EliminarCompraController" method="post">
		<input type="text" name="usuario_id" value="${usuN.id}" style="display:none">
		<input type="text" name="page" value="b" style="display:none">
		<input type="submit" value="Eliminar Compra">
	</form>
	
	
	<form action="/CitasJPA/ListarCompraController" method="post">
		<input type="text" name="usuario_id" value="${usuN.id}" style="display:none">
		<input type="text" name="page" value="b" style="display:none">
		<input type="submit" value="Listar Todas las Compras">
	</form>
	
	<form action="/CitasJPA/CerrarSesion" method="post"> 
		<input type="submit" value="Cerrar Sesion">
	</form>
	
</body>
</html>