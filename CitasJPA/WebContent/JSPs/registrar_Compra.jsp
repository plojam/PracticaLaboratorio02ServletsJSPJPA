<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Registrar Compra</title>
	<link rel="stylesheet" type="text/css" href="/CitasJPA/CSS/generalUsuario.css">

	<script src='/Pedidos/JavaSs/funciones.js'></script>

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


	<c:set var="listadoP" scope="request" value="${listaProductos2}" />
	<c:set var="listadoC" scope="request" value="${listaCategoria}" />
	
	<c:set var="aa" scope="request" value="${cabecera_id}" />
	
	<!--h1>Registro </h1-->
	
	<div id=opcion1>
        <h1 class="tema">Agregar Compra</h1>
        
        
        <form class="form" action="/CitasJPA/TEST" method="post">
            
            <label for="producto">Categoria: </label>
            
				<select name="item2">
					<option value="- Seleccione categoria -" selected> - Seleccione categoria -</option>
					<c:forEach items="${listadoC}" var="id">
       				<option> ${id.nombre}</option>
					</c:forEach>
				</select>
				<input type="text" value=<%= usu_id %>  name="usuario_id" style="display:none">
            	<input type="text" value="${aa}"  name="ver_id" style="display:none">
            	
            <input type="submit" value="Filtrar">
        </form>
    </div>
    <br>
     <table class="table" id="recto">
        <tr>
            <td class="titulo"><strong>Codigo</strong></td>
            <td class="titulo"><strong>Producto</strong></td>
            <td class="titulo"><strong>Cantidad</strong></td>
            <td class="titulo"><strong>Categoria</strong></td>
        </tr>
        
        <c:forEach var="fac"  items="${listaProductos2}">
            <tr>
                <td>${fac.id}</td>
                <td>${fac.nombre}</td>
                <td>${fac.cantidad}</td>
                <td>${fac.categoria.getNombre()}</td>
            </tr>
        </c:forEach>
    </table>

	<br>

        <form class="form" action="/CitasJPA/TEST" method="post">
            	<label for="categoria">Categoria: </label>
				<select name="item">
					<c:forEach items="${listaProductos2}" var="id">
       				<option> ${id.nombre}</option>
					</c:forEach>
				</select>
				<label for="cantidad">Cantidad: </label>
				<input type="text" name="cantidad" >
				<input type="text" value=<%= usu_id %>  name="usuario_id" style="display:none">
            	<input type="text" value="${aa}"  name="ver_id" style="display:none">
            	
            <input type="submit" value=" Agregar ">
        </form>
        
    
    <%
       String number1 = (String) request.getAttribute("number1");

       if (number1 != null ) {
    	   out.print(String.format("<p> CARRITO : <strong>%s</strong></p>", number1));
    	   
       }
%>

    <form action="/CitasJPA/BuscarUsuario" method="post">
    	<input type="text" value=<%= usu_id %>  name="usuario_id" style="display:none">
		<input class="btng" type="submit" value="Finalizar Compra">
    </form>

</body>
</html>

