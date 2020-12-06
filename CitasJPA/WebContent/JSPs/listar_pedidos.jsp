<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.io.PrintWriter"%>
<%@page import="ec.edu.ups.dao.DAOFactory"%>
<%@page import="ec.edu.ups.modelo.Detalle"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Listar Pedidos</title>
	<link rel="stylesheet" type="text/css" href="/CitasJPA/CSS/estilos.css">
</head>
<body>
	<c:set var="lista_U" scope="request" value="${usuarios}"/>
	<c:set var="lista_C" scope="request" value="${cabeceras}"/>
	<c:set var="usu" scope="request" value="${usuario_id}"/>
	<c:set var="emp" scope="request" value="${empresa_id}"/>
	<c:set var="usuS" scope="request" value="${usuarioS_id}"/>

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
    
    <div id="usuarios">
    	<h1>Usuarios</h1>
    	
    	<table id="tabla_users">
			<tr>
				<td><strong>Nombre</strong></td>
				<td><strong>Apellido</strong></td>
				<td><strong>Pedidos</strong></td>
			</tr>
			
			<c:forEach var="us" items="${lista_U}">
				<tr>
					<td>${us.nombre}</td>
					<td>${us.apellido}</td>
					<td>
						<form action="/CitasJPA/ListarCabecerasController" method="post">
							<input type="text" value="${us.id}" name="usuarioS_id" style="display:none">
							<input type="text" value="lp" name="page" style="display:none">
							<input type="text" value="${usu}" name="usuario_id" style="display:none"> 
							<input type="text" value="${emp}" name="empresa_id" style="display:none">
							<input type="submit" value="Listar">
						</form> 
					</td>
				</tr>
			</c:forEach>
		</table>
    </div>
    
    <div id="pedidos">
    	<h1>Pedidos</h1>
    	
    	<table id="tabla_cabeceras">
			<tr>
				<td><strong>Numero</strong></td>
				<td><strong>Estado</strong></td>
				<td><strong>Detalle</strong></td>
			</tr>
			
			<c:forEach var="cab" items="${lista_C}">
				<tr>
					<td>${cab.id}</td>
					<td>${cab.estado}</td>
					<td>
						<form action="/CitasJPA/ListarDetallesController" method="post">
							<input type="text" value="${cab.id}" name="cab_id" style="display:none"> 
							<input type="text" name="usuarioS_id" value="${usuS}" style="display:none">
							<input type="text" name="usuario_id" value="${usu}" style="display:none">
							<input type="text" name="empresa_id" value="${emp}" style="display:none">
							<input type="submit" value="Ver Detalle">
						</form> 
					</td>
				</tr>
			</c:forEach>
		</table>
    </div>
    
    <div id="detalle">
    	<h1>Detalles</h1>
    	
    	<table id="tabla_detalles">
		<tr>
			<td><strong>Producto</strong></td>
			<td><strong>Cantidad</strong></td>
		</tr>
			<% 
				List<Detalle> lista_D = (List<Detalle>) request.getAttribute("detalles"); 
				String comp = String.valueOf(request.getAttribute("comprobar"));
				
				Detalle deta;
				
				int producto_id;
			%>
		
			<% 
			
			if(comp.equals("t")){
				
				for (int i = 0; i < lista_D.size(); i++){
					deta = lista_D.get(i);
					
	                out.println("<tr><td>" + deta.getProducto().getNombre() + "</td>");
	                out.println("<td>" + deta.getCantidad() + "</td></tr>");
       			}
			}else {
				System.out.println("Null del Administrar Pedidos");
			}
	                
	        %>
			
		</table>
    </div>
    
    <form action="/CitasJPA/BuscarUsuarioAdmin" method="post">
    	<input type="text" name="emp_id" value="${emp}" style="display:none">
		<input type="text" name="usu_id" value="${usu}" style="display:none">
		<input type="submit" value="Regresar a Inicio">
    </form>
    
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
</body>
</html>