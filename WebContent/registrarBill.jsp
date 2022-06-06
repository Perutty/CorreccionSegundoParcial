<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<header>
		<nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue"></nav>
	</header>
	<br>
	<h3 class="text-center">Registro Bill</h3>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<fieldset class="form-group">
				<label>Descripción: </label><input type="text"
					class ="form-control" name="observation" required="required">
				</fieldset>
				<fieldset class="form-group">
				<input type="radio" value="Ingreso" id="ingreso"><label for="ingreso">Ingreso</label><br>
				</fieldset>
				<fieldset class="form-group">
				<input type="radio" value="Gasto" id="gasto"><label for="gasto">Gasto</label><br>
				</fieldset>
				<fieldset class="form-group">
					<label>Valor: </label><input type="text"
					  class ="form-control" name="value" required="required">
				</fieldset>
				<a href="<%=request.getContextPath()%>/insert" class="btn btn-success">Registrar</a>
			</div>
		</div>
	</div>
</body>
</html>