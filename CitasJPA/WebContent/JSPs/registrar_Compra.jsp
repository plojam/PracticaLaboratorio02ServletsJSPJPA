<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Registrar Compra</title>
	<link rel="stylesheet" type="text/css" href="/Pedidos/CSS/perfil.css">

	<script src='/Pedidos/JavaSs/funciones.js'></script>

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

<div> llega JSP correcto</div>

	<c:set var="listadoP" scope="request" value="${listaProductos2}" />
	<c:set var="listadoC" scope="request" value="${listaCategoria}" />
	
	<c:set var="aa" scope="request" value="${cabecera_id}" />
	
	<h1>Registro </h1>
	
	<div id=opcion1>
        <h1>Agregar Compra</h1>
        
        
        <form action="/CitasJPA/TEST" method="post">
            
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
    
     <table>
        <tr>
            <td><strong>Codigo</strong></td>
            <td><strong>Producto</strong></td>
            <td><strong>Cantidad</strong></td>
            <td><strong>Categoria</strong></td>
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


        <form action="/CitasJPA/TEST" method="post">
            
				<select name="item">
					<c:forEach items="${listaProductos2}" var="id">
       				<option> ${id.nombre}</option>
					</c:forEach>
				</select>
				
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
		<input type="submit" value="Finalizar Compra">
    </form>

</body>
</html>



