<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: blue"></nav>
	</header>
	<br />
	<div class="row">
		<div class="container">
			<h3 class="text-center">Listado de Bills</h3>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Fecha</th>
						<th>Descripción</th>
						<th>Tipo de movimiento</th>
						<th>Valor</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="bill" items="${listBills}">
						<tr>
							<td><c:out value="${bill.date_bill}" /></td>
							<td><c:out value="${bill.observation}" /></td>
							<td><c:out value="${bill.type}" /></td>
							<td><c:out value="${bill.value}" /></td>
							<td><a href="delete?id=<c:out value='${bill.id}'/>">Eliminar</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
		</div>
	</div>
	<a href="<%=request.getContextPath()%>/newBill" class="btn btn-success">Agregar
		</button>
</body>
</html>