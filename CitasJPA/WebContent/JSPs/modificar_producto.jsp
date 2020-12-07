<%@page import="ec.edu.ups.dao.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="ec.edu.ups.modelo.Producto"%>
<%@page import="ec.edu.ups.modelo.Categoria"%>
<%@page import="ec.edu.ups.dao.ProductoDAO"%>
<%@page import="ec.edu.ups.dao.CategoriaDAO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Modificar Productos</title>
	<link rel="stylesheet" type="text/css" href="/CitasJPA/CSS/generalAdministrador.css">
</head>
<body>
	
	<c:set var="proInf" scope="request" value="${producto}"/>
	
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

    <div id="lista_Productos">
        <h1 class="tema">Modificar Productos</h1>
        
        <table class="table">
		<tr>
			<td class="titulo"><strong>Nombre</strong></td>
			<td class="titulo"><strong>Cantidad</strong></td>
			<td class="titulo"><strong>Categoria</strong></td>
			<td class="titulo"><strong>Modificar</strong></td>
		</tr>
		
		<% 
			List<Producto> lista_P = (List<Producto>) request.getAttribute("productos");
		
			Producto prod = null;
			
			for(int i = 0; i < lista_P.size(); i++) {
				prod = lista_P.get(i);
				
				out.println("<tr><td>" + prod.getNombre() + "</td>");
				out.println("<td>" + prod.getCantidad() + "</td>");
				out.println("<td>" + prod.getCategoria().getNombre() + "</td>");
				out.println("<td><form action='/CitasJPA/BuscarProductosController' method='post'>" +
						"<input type='text' value='m' name='page' style='display:none'>" + 
						"<input type='text' value='ide' name='bus' style='display:none'>" + 
						"<input type='text' value='" + prod.getId() + "' name='pro_id' style='display:none'>" + 
						"<input type='text' name='emp_id' value='" + emp  + "' style='display:none'>" +
						"<input type='text' name='usu_id' value='" + usu +"' style='display:none'>" +
						"<input type='submit' value='Modificar'></form> </td>");
				out.println("<td><form action='/CitasJPA/EliminarProductoController' method='post'>" +
						"<input type='text' value='" + prod.getId() + "' name='pro_id' style='display:none'>" + 
						"<input type='text' name='emp_id' value='" + emp  + "' style='display:none'>" +
						"<input type='text' name='usu_id' value='" + usu +"' style='display:none'>" +
						"<input type='submit' value='Eliminar'></form> </td></tr>");
			}		
			
		%>
		</table>
	</div>
	<br>
	<div id="formulario_producto">
		<form class="form" action="/CitasJPA/ModificarProductosController" method="post">
			<label for="nombre">Nombre: </label>
			<input type="text" name="nombre" value="${proInf.nombre}"/>
			
			<label for="cantidad">Cantidad: </label>
			<input type="text" name="cantidad" value="${proInf.cantidad}">
			
			<label for="categoria">Categoria: </label>
            <select name="categoria">
                <option value="1">Perfumeria</option> 
                <option value="2">Maquillaje</option>
                <option value="3">Moda</option>
            </select>

			<input type="text" name="emp_id" value=<%= emp %> style="display:none">
			<input type="text" name="usu_id" value=<%= usu %> style="display:none">
			<input type="text" value="${proInf.id}" name="producto_id" style="display:none">
			
    	<input class="btng" type="submit" value="Modificar Producto">
		</form>
    </div>
    
    <br>
    <div id="regresar">
	    <form action="/CitasJPA/BuscarUsuarioAdmin" method="post">
	    	<input type="text" name="emp_id" value=<%= emp %> style="display:none">
			<input type="text" name="usu_id" value=<%= usu %> style="display:none">
			<input class="btng" type="submit" value="Regresar a Inicio">
	    </form>
    </div>
</body>

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
</html>