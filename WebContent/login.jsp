<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gesti?n de ingresos y egresos</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue">
		<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/" class="navbar-brand">BBVA</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
					<h3>Inicio de sesi?n</h3>
				<form action="validar" method="post">
				<fieldset class="form-group">
					<label>Username</label><input type="text" value="" 
													class ="form-control" name="username" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>Password</label><input type="text" value="" 
													class ="form-control" name="pass" required="required">
				</fieldset>
				<button type="submit" class="btn btn-success">Entrar</button>
				<a href="<%=request.getContextPath()%>/new"" class="btn btn-success">Registrar</a>
				<a href="<%=request.getContextPath()%>/mostrar" class="btn btn-success">Mostrar</a>
			</form>
			<br>
			<p style="color:red;text-aling:center"><i>
				<%String res = (String)request.getAttribute("loginError");
				  String loginError ="";
				  if(res != null){
				  	loginError = res;
				  }
				 %>
				 <%=loginError%>
			</i></p>
			</div>
		</div>
	</div>
</body>
</html>