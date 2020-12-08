<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.io.PrintWriter"%>
<%@page import="ec.edu.ups.modelo.Producto"%>
<%@page import="ec.edu.ups.modelo.Detalle"%>
<%@page import="ec.edu.ups.modelo.Cabecera"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Listar Pedidos</title>
	<link rel="stylesheet" type="text/css" href="/CitasJPA/CSS/generalAdministrador.css">
</head>
<body>
	<c:set var="lista_U" scope="request" value="${usuarios}"/>
	
	<% 
		int emp = (Integer) request.getAttribute("empresa_id");
		int usu = (Integer) request.getAttribute("usuario_id"); 
	%>

	<header>
        <img id="logo" src="/CitasJPA/img/logo_ups.png" alt="Logo" width="700" height="100"/>
        <h1>Menu de Inicio</h1>

        <nav id="list_1">
            <ul>
                <li><a href="login.html">Login</a></li>
                <li>Empresas</li>
            </ul>
        </nav>
    </header>

    <div class="jump"></div>
    
    <div id="usuarios">
    	<h1 class="tema">Usuarios</h1>
    	
    	<table class='table' id="tabla_users">
			<tr>
				<td class='titulo'><strong>Nombre</strong></td>
				<td class='titulo'><strong>Apellido</strong></td>
				<td class='titulo'><strong>Pedidos</strong></td>
			</tr>
			
			<c:forEach var="us" items="${lista_U}">
				<tr>
					<td>${us.nombre}</td>
					<td>${us.apellido}</td>
					<td>
						<form action="/CitasJPA/ListarCabecerasController" method="post">
							<input type="text" value="${us.id}" name="usuarioS_id" style="display:none">
							<input type="text" value="lp" name="page" style="display:none">
							<input type="text" value="<%= usu %>" name="usuario_id" style="display:none"> 
							<input type="text" value="<%= emp %>" name="empresa_id" style="display:none">
							<input type="submit" value="Listar">
						</form> 
					</td>
				</tr>
			</c:forEach>
		</table>
    </div>
    
    <div id="pedidos">
  		<% 
			List<Cabecera> lista_C = (List<Cabecera>) request.getAttribute("cabeceras");
			Cabecera cab;
			Detalle deta;
	  		
			if(lista_C != null){
				int usuS = (Integer) request.getAttribute("usuarioS_id");
				
	   			for(int i = 0; i < lista_C.size(); i++){
	   				cab = lista_C.get(i);
	   				
	   				out.println("<h3 class='tema'>Pedido " + (i+1) + "</h3>");
	   				
	   				out.println("<table class='table' id='tabla_cabeceras'>" +
	   				"<tr><td class='titulo'><strong>Numero</strong></td>" +
	   				"<td class='titulo'><strong>Estado</strong></td></tr>");
	   				
					if (cab.getEstado().equals("A")) {
						cab.setEstado("Aceptado");
						
					}else if(cab.getEstado().equals("R")){
						cab.setEstado("Rechazado");
					}
	   				
	   				out.println("<tr><td>" + cab.getId() + "</td>" + 
	   							"<td>" + cab.getEstado() + "</td></tr></table>");
						
	   				out.println("<table class='table' id='tabla_detalles'>" +
   							"<tr><td class='titulo'><strong>Codigo</strong></td>" +
   							"<td class='titulo'><strong>Producto</strong></td>" +
   							"<td class='titulo'><strong>Cantidad</strong></td>" + 
   							"<td class='titulo'><strong>Categoria</strong></td></tr>");
						
   					for (int j = 0; j < cab.getDetalles().size(); j++){
   						deta = cab.getDetalles().get(j);
   						
   						out.println("<tr><td>" + deta.getId() + "</td>");
   		                out.println("<td>" + deta.getProducto().getNombre() + "</td>");
   		                out.println("<td>" + deta.getCantidad() + "</td>");
   		             	out.println("<td>" + deta.getProducto().getCategoria().getNombre() + "</td></tr>");
   	       			}	
   					out.println("</table>");
   				}
   			}
		%>	
    </div>
    
    <form action="/CitasJPA/BuscarUsuarioAdmin" method="post">
    	<input type="text" name="emp_id" value="<%= emp %>" style="display:none">
		<input type="text" name="usu_id" value="<%= usu %>" style="display:none">
		<input class="btng" type="submit" value="Regresar a Inicio">
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