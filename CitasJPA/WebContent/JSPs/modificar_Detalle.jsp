<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% 
		String usu_id = request.getParameter("usuario_id");
	
		out.print(String.format("<p> VER cabecera ID : <strong>%s</strong></p>", usu_id));
	%>
	
	<c:set var="listadoD" scope="request" value="${listaDetalle}" />
	<c:set var="cab_id" scope="request" value="${cabecera_id}" />

	
		 <form action="/CitasJPA/ModificarDetalleController2" method="post">
		 
		 	<select name="det_id">
					<c:forEach items="${listaDetalle}" var="id">
       				<option>${id.id}</option>
					</c:forEach>
				</select>
		 
            	<label for="nombre">Ingrese Cantidad: </label>
            	<input type="text" name="cantidadP">
            	
				<input type="text" value=<%= usu_id %>  name="usuario_id" style="display:none">
				<input type="text" value="${cab_id}"  name="cab_id" style="display:none">
            
            <input type="submit" value="Modificar">
        </form>
        
        	
		 <form action="/CitasJPA/ModificarCompraController" method="post">
			
				<input type="text" value=<%= usu_id %>  name="usuario_id" style="display:none">
            
            <input type="submit" value="Regresar">
        </form>
	
	

</body>
</html>