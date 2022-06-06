<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aplicación Gestión de Usuarios</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue">
		<ul class="navbar-nav">
				<li><a href ="<%=request.getContextPath()%>/" class="navbar-brand">Inicio de Sesión</a></li>
	    </ul>
		</nav>
	</header>
	<br/>
	
	<div class="row">
		<div class="container">
			
			<h3 class="text-center">Listado de Usuarios</h3>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Username</th>
						<th>Password</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${listUsuarios}">
						<tr>
							<td>
								<c:out value="${user.username}"/>
							</td>
							<td>
								<c:out value="${user.pass}"/>
							</td>
							<td>
							<a href="delete?id=<c:out value='${user.id}'/>">Eliminar</a>
							</td>							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>