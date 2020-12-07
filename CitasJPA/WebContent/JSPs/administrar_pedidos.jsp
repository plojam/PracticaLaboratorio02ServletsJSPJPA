<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.io.PrintWriter"%>
<%@page import="ec.edu.ups.dao.DAOFactory"%>
<%@page import="ec.edu.ups.modelo.Producto"%>
<%@page import="ec.edu.ups.modelo.Detalle"%>
<%@page import="ec.edu.ups.modelo.Cabecera"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Controlar Pedidos</title>
	<link rel="stylesheet" type="text/css" href="/CitasJPA/CSS/generalAdministrador.css">
	<script src="/CitasJPA/JavaScript/funciones.js"></script>
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
						<input type="text" value="cp" name="page" style="display:none">
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
	  		
			if(lista_C != null){
				int usuS = (Integer) request.getAttribute("usuarioS_id");
				out.println("<h1>Pedido</h1>");
				
	   			for(int i = 0; i < lista_C.size(); i++){
	   				cab = lista_C.get(i);
	   				
	   				out.println("<table class='table' id='tabla_cabeceras'>" +
	   				"<tr><td class='titulo'><strong>Numero</strong></td>" + 
					"<td class='titulo'><strong>Estado</strong></td>" +
	   				"<td class='titulo'><strong>Detalle</strong></td>" + 
					"<td class='titulo'><strong>Aceptar</strong></td>" + 
	   				"<td class='titulo'><strong>Denegar</strong></td></tr>");
	   				
	   				out.println("<tr><td>" + cab.getId() + "</td>" + 
	   				"<td>" + cab.getEstado() + "</td>");
	   				
	   				/*out.println("<td><form action='/CitasJPA/ListarDetallesController' method='post'>" +
	   						"<input type='text' value='" + cab.getId() + "' name='cab_id' style='display:none'>" +
	   						"<input type='text' name='usuarioS_id' value='" + usuS +"' style='display:none'>" +
	   						"<input type='text' name='usuario_id' value='"+ usu + "' style='display:none'>" + 
	   						"<input type='text' name='empresa_id' value='" + emp + "' style='display:none'>" +
	   						"<input type='submit' value='Ver Detalle'></form></td>");
	   				*/
	   				out.println("<td><input type='button' value='Ver Detalle' onclick='mostrarTabla()'></td>");
	   				
	   				out.println("<td><form action='/CitasJPA/ControlarPedidosController' method='post'>" +
							"<input type='text' value='" + cab.getId() + "' name='cab_id' style='display:none'>" +
							"<input type='text' name='usuarioS_id' value='" + usuS + "' style='display:none'>" +
							"<input type='text' value='aceptado' name='estado' style='display:none'>" +
							"<input type='text' name='usuario_id' value='" + usu + "' style='display:none'>" +
							"<input type='text' name='empresa_id' value='" + emp + "' style='display:none'>" +
							"<input type='submit' value='Aceptar'></form></td>");
	   				
	   				out.println("<td><form action=''/CitasJPA/ControlarPedidosController' method='post'>" +
							"<input type='text' value='" + cab.getId() + "' name='cab_id' style='display:none'>" +
							"<input type='text' name='usuarioS_id' value='" + usuS + "' style='display:none'>" +
							"<input type='text' value='negado' name='estado' style='display:none'>" +
							"<input type='text' name='usuario_id' value='" + usu + "' style='display:none'>" +
							"<input type='text' name='empresa_id' value='" + emp + "' style='display:none'>" +
							"<input type='submit' value='Denegar'></form></td></tr></table>");
	   				
   					out.println("<div id='detalles'>");
   			    
   					out.println("<table class='table' id='tabla_detalles'><tr>" +
   							"<td class='titulo'><strong>Codigo</strong></td>" +
   							"<td class='titulo'><strong>Producto</strong></td>" +
   							"<td class='titulo'><strong>Cantidad</strong></td>" + 
   							"<td class='titulo'><strong>Categoria</strong></td></tr>");
   					
   					for (int j = 0; j < cab.getDetalles().size(); j++){
   						Detalle control = cab.getDetalles().get(j);
   						
   						out.println("<tr><td>" + control.getId() + "</td>");
   		                out.println("<td>" + control.getProducto().getNombre() + "</td>");
   		                out.println("<td>" + control.getCantidad() + "</td>");
   		             	out.println("<td>" + control.getProducto().getCategoria().getNombre() + "</td></tr>");
   	       			}
   					out.println("</table></div>");
   				}
   			}
		%>	
    </div>
    <!-- 
    <div id="detalles" style='display:none'>
		<%-- 
			List<Detalle> lista_D = (List<Detalle>) request.getAttribute("detalles");
		
			if(lista_D != null){
				
				out.println("<h1>Detalles</h1>");
		    
				for (int i = 0; i < lista_D.size(); i++){
					Detalle control = lista_D.get(i);
					
					out.println("<table id='tabla_detalles'><tr>" +
						"<td><strong>Producto</strong></td>" +
						"<td><strong>Cantidad</strong></td></tr>");
					
	                out.println("<tr><td>" + control.getProducto().getNombre() + "</td>");
	                out.println("<td>" + control.getCantidad() + "</td></tr></table>");
       			}
			}

        --%>
    </div>
    
     -->
    
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