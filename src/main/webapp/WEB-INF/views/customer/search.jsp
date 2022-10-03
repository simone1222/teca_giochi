<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ricerca</title>
</head>
<body>
	<div align="center">
		<h2>Ricerca Utente</h2>
		<table border="1" cellpadding="5">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>E-mail</th>
				<th>username</th>
			</tr>
			<c:forEach items="${result}" var="utente">
				<tr>
					<td>${utente.id}</td>
					<td>${utente.nome}</td>
					<td>${utente.email}</td>
					<td>${utente.username}</td>
				</tr>
			</c:forEach>
		</table>
		<a href="<c:url value="/index"/>">Return list</a>
	</div>
	
</body>
</html>