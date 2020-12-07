<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Modificar Compra</title>
	<link rel="stylesheet" type="text/css" href="/CitasJPA/CSS/perfil.css">
	
	
</head>
<body>

	<header>
		<h1>Persona encontrada</h1>		
		<hr color="#313b4a" width="98%">
		<h3 class="datos">Id: ${usuN.id}</h3>
		<h3 class="datos">Nombre: ${usuN.nombre}</h3>
		<h3 class="datos">Apellido: ${usuN.apellido}</h3>
	</header>

	<% 
		String usu_id = request.getParameter("usuario_id");
	%>

	<c:set var="listadoC" scope="request" value="${listaCabecera}" />

	<table>
		<tr>
			<td><strong>Código  </strong></td>
			<td><strong> Estado</strong></td>
		</tr>
		<c:forEach var="c" items="${listadoC}">
			<tr>
				<td>${c.id}</td>
				<td>${c.estado}</td>
				<td> <a href="/CitasJPA/ModificarDetalleController?id=${c.id}&usuario_id=<%= usu_id %>"   > Modificar</a> </td>
				
			</tr>
		</c:forEach>
	</table>
	
    <form action="/CitasJPA/BuscarUsuario" method="post">
    	<input type="text" value=<%= usu_id %>  name="usuario_id" style="display:none">
		<input type="submit" value="Regresar al menu">
    </form>


</body>
</html>