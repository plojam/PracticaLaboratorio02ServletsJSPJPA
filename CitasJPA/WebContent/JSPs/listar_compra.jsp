<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Listar Compra</title>
	<link rel="stylesheet" type="text/css" href="/Pedidos/CSS/perfil.css">
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
		
	//	out.print(String.format("<p> VER USUARIO ID : <strong>%s</strong></p>", usu_id));
	
	%>
	
	
	<c:set var="listadoSinD" scope="request" value="${listaCabeceraSinDelete2}" />


	<table>
		<tr>
			<td><strong>Código   </strong></td>
			<td><strong>    Estado </strong></td>
		</tr>
		<c:forEach var="SinD" items="${listadoSinD}">
			<tr>
				<td>${SinD.id}</td>
				<td>${SinD.estado}</td>
				<td> <a href="/CitasJPA/ListarCompraController2?id=${SinD.id}&usuario_id=<%= usu_id %>" >Ver Detalle	</a> </td>
			</tr>
		</c:forEach>
	</table>
	
    <form action="/CitasJPA/BuscarUsuario" method="post">
    	<input type="text" value=<%= usu_id %>  name="usuario_id" style="display:none">
		<input type="submit" value="Regresar al menu">
    </form>




</body>
</html>