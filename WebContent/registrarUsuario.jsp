<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aplicación Gestión de Usuario</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue">
			<div>
				<a href ="<%=request.getContextPath()%>/" class="navbar-brand">Gestión de Usuarios</a>
			</div>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${user != null}">
					<form action="update" method="post"></c:if>
				<c:if test="${user == null}">
					<form action="insert" method="post"></c:if>
					
				<fieldset class="form-group">
					<label>Nombre de usuario</label><input type="text" value="<c:out value='${usuario.username}'/>" 
													class ="form-control" name="username" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Email del usuario</label><input type="text" value="<c:out value='${usuario.email}'/>" 
													class ="form-control" name="email" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Password</label><input type="text" value="<c:out value='${usuario.pass}'/>" 
													class ="form-control" name="pass" required="required">
				</fieldset>
				<button type="submit" class="btn btn-success">Guardar</button>
			</div>
		</div>
	</div>
</body>
</html>