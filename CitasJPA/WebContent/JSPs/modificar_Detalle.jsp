<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Modificar Detalle</title>
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
	
	//	out.print(String.format("<p> VER cabecera ID : <strong>%s</strong></p>", usu_id));
	%>
	
	<c:set var="listadoD" scope="request" value="${listaDetalle}" />
	<c:set var="cab_id" scope="request" value="${cabecera_id}" />
	<div class="espacio"></div>
     <table class="table">
        <tr>
            <td class="titulo"><strong>Codigo</strong></td>
            <td class="titulo"><strong>Producto</strong></td>
            <td class="titulo"><strong>Cantidad</strong></td>
            <td class="titulo"><strong>Categoria</strong></td>
        </tr>
        
        <c:forEach var="fac"  items="${listaDetalle}">
            <tr>
                <td>${fac.id}</td>
                <td>${fac.producto.getNombre()}</td>
                <td>${fac.cantidad}</td>
                <td>${fac.producto.categoria.getNombre()}</td>
            </tr>
        </c:forEach>
    </table>
	<br>
		 <form class="form" action="/CitasJPA/ModificarDetalleController2" method="post">
		 
		 	<select name="item3">
					<c:forEach items="${listaDetalle}" var="id">
       				<option>${id.producto.getNombre()}</option>
					</c:forEach>
				</select>
		 
            	<label for="nombre"> Cantidad: </label>
            	<input type="text" name="cantidadP">
            	
				<input type="text" value=<%= usu_id %>  name="usuario_id" style="display:none">
				<input type="text" value="${cab_id}"  name="cab_id" style="display:none">
            
            <input type="submit" value="Modificar">
        </form>
        
        <br>
		 <form action="/CitasJPA/ModificarCompraController" method="post">
			
				<input type="text" value=<%= usu_id %>  name="usuario_id" style="display:none">
            
            <input class="btng" type="submit" value="Regresar">
        </form>
	
	

</body>
</html>