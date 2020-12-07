<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Listar Compra</title>
	<link rel="stylesheet" type="text/css" href="/CitasJPA/CSS/generalUsuario.css">
</head>
<body>

	<header>
        <img id="logo" src="/CitasJPA/img/logo_ups.png" alt="Logo" width="700" height="100"/>
        <h1>Menu de Inicio</h1>
 
        <nav id="list_1">
            <ul>
                <li><a href="login.html">Login</a></li>
                <li><a href="/CitasJPA/ListarEmpresas">Empresas</a></li>
            </ul>
        </nav>
    </header> 

	<% 
		String usu_id = request.getParameter("usuario_id");
		
	//	out.print(String.format("<p> VER USUARIO ID : <strong>%s</strong></p>", usu_id));
	
	%>
	
	<div class="espacio"></div>
	
	<c:set var="listadoSinD" scope="request" value="${listaCabeceraSinDelete2}" />


	<table class="table">
		<tr>
			<td class="titulo"><strong>C�digo   </strong></td>
			<td class="titulo"><strong>    Estado </strong></td>
		</tr>
		<c:forEach var="SinD" items="${listadoSinD}">
			<tr>
				<td>${SinD.id}</td>
				<td>${SinD.estado}</td>
				<td> <a href="/CitasJPA/ListarCompraController2?id=${SinD.id}&usuario_id=<%= usu_id %>" >Ver Detalle	</a> </td>
			</tr>
		</c:forEach>
	</table>
	<br>
    <form action="/CitasJPA/BuscarUsuario" method="post">
    	<input type="text" value=<%= usu_id %>  name="usuario_id" style="display:none">
		<input class="btng" type="submit" value="Regresar al menu">
    </form>




</body>
</html>