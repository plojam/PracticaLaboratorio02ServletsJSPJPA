<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Perfil Administrador</title>
</head>
<body>
	<c:set var="usuA" scope="request" value="${usuario}" />
	<c:set var="empA" scope="request" value="${empresa}" />

	<h1>Administrador</h1>		
		
	<p>Id: ${usuA.id}</p>
	<p>Nombre: ${usuA.nombre}</p>
	<p>Apellido: ${usuA.apellido}</p>
	<p>Empresa: ${empA.nombre} </p>
	
	Administrar Productos
	
	<form action="/CitasJPA/JSPs/registrar_producto.jsp" method="post">
		<input type="text" name="empresa_id" value="${empA.id}" style="display:none">
		<input type="text" name="usuario_id" value="${usuA.id}" style="display:none">
		
		<input type="submit" value="Registrar Productos">
	</form>
	
	<form action="/CitasJPA/ListarProductosController" method="post">
		<input type="text" name="empresa_id" value="${empA.id}" style="display:none">
		<input type="text" name="usuario_id" value="${usuA.id}" style="display:none">
		<input type="text" name="page" value="m" style="display:none">
		
		<input type="submit" value="Modificar Productos">
	</form>
	
	<form action="/CitasJPA/JSPs/buscar_producto.jsp" method="post">
		<input type="text" name="empresa_id" value="${empA.id}" style="display:none">
		<input type="text" name="usuario_id" value="${usuA.id}" style="display:none">
		<input type="text" name="page" value="b" style="display:none">
		
		<input type="submit" value="Buscar Productos">
	</form>
	
	<form action="/CitasJPA/ListarUsuariosController" method="post">
		<input type="text" name="empresa_id" value="${empA.id}" style="display:none">
		<input type="text" name="usuario_id" value="${usuA.id}" style="display:none">
		<input type="text" name="page" value="cp" style="display:none">
		
		<input type="submit" value="Administrar Pedidos">
	</form>
	
	<form action="/CitasJPA/ListarUsuariosController" method="post">
		<input type="text" name="empresa_id" value="${empA.id}" style="display:none">
		<input type="text" name="usuario_id" value="${usuA.id}" style="display:none">
		<input type="text" name="page" value="lp" style="display:none">
		
		<input type="submit" value="Listar Pedidos">
	</form>
	
	<form action="/CitasJPA/CerrarSesion" method="post"> 
		<input type="submit" value="Cerrar Sesion">
	</form>
	
</body>
</html>