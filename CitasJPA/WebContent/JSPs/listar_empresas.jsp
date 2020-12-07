<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="ec.edu.ups.modelo.Empresa"%>
<%@page import="ec.edu.ups.modelo.Producto"%>
<%@page import="ec.edu.ups.modelo.Categoria"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Empresa</title>
	<link rel="stylesheet" type="text/css" href="/CitasJPA/CSS/empresas.css">
</head>
<body>

	<header>
        <a href="index.html"><img id="logo" src="/Pedidos/img/logo_ups.png" alt="Logo" width="700" height="100" /></a>
        <h1>Menu de Inicio</h1>

        <nav id="list_1">
            <ul>
                <li><a href="/CitasJPA/HTMLs/login.html">Login</a></li>
                <li>Empresas</li>
            </ul>
        </nav>
    </header>
	
	<% 
		List<Empresa> lista_E = (List<Empresa>) request.getAttribute("empresas"); 
		List<Producto> lista_P1 = (List<Producto>) request.getAttribute("productos_emp1");
		List<Producto> lista_P2 = (List<Producto>) request.getAttribute("productos_emp2");
		
		Empresa empresa_1 = lista_E.get(0);
		Empresa empresa_2 = lista_E.get(1);
	%>
	<div class="espacio"></div>
	<aside id="empresa_1">
		<aside class="ima"><img class="emp" src="/Pedidos/img/AvonLogoBlack.jpg" width="100" height="10" alt="Logo"/></aside>
		<br>
		<h2>Nombre: <%= empresa_1.getNombre() %></h2>
	
		<table class="table" id="prods_1"> 
			<%
				out.println("<tr><td class='titulo'><strong>Codigo</strong></td>" +
					"<td class='titulo'><strong>Nombre</strong></td>" +
					"<td class='titulo'><strong>Cantidad</strong></td>" + 
					"<td class='titulo'><strong>Categoria</strong></td></tr>");
			
				for(int i = 0; i < lista_P1.size(); i++){
						
					out.println("<tr><td>" + lista_P1.get(i).getId() + "</td>");
	                out.println("<td>" + lista_P1.get(i).getNombre() + "</td>");
	                out.println("<td>" + lista_P1.get(i).getCantidad() + "</td>");
	                out.println("<td>" + lista_P1.get(i).getCategoria().getNombre() + "</td></tr>");
				}
			%>
		</table>
	
	</aside>
	
	
	<aside id="empresa_2">
		<aside class="ima"><img class="emp" src="/Pedidos/img/Logo_Yanbal.png" alt="Logo"/></aside>
		<br>
		<h2>Nombre: <%= empresa_2.getNombre() %></h2>
		
		<table class="table" id="prods_2"> 
			<%
				out.println("<tr><td class='titulo'><strong>Codigo</strong></td>" +
					"<td class='titulo'><strong>Nombre</strong></td>" +
					"<td class='titulo'><strong>Cantidad</strong></td>" + 
					"<td class='titulo'><strong>Categoria</strong></td></tr>");
			
				for(int i = 0; i < lista_P2.size(); i++){
					
					out.println("<tr><td>" + lista_P2.get(i).getId() + "</td>");
	                out.println("<td>" + lista_P2.get(i).getNombre() + "</td>");
	                out.println("<td>" + lista_P2.get(i).getCantidad() + "</td>");
	                out.println("<td>" + lista_P2.get(i).getCategoria().getNombre() + "</td></tr>");
				}
			%>
		
		</table>
		
	</aside>
	
</body>
</html>