<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Perfil User</title>
</head>
<body>
	<c:set var="usuN" scope="request" value="${usuario}" />
	
	<h1>Persona encontrada</h1>		
		
	<p>Id: ${usuN.id}</p>
	<p>Nombre: ${usuN.nombre}</p>
	<p>Apellid: ${usuN.apellido}</p>
	
	<h2> Main </h2>
	
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
	
	
	<form action="/CitasJPA/Elim" method="post">
		<input type="text" name="usuario_id" value="${usuN.id}" style="display:none">
		<input type="text" name="page" value="b" style="display:none">
		<input type="submit" value="Listar Compras">
	</form>
	
	
</body>
</html>