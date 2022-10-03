<%@ page language="java" contentType="text/html; charset=UTF-8)"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modifica Utente</title>
</head>
<body>
	<div align="center">
		<h2>Modifica</h2>
		<form:form action="save" method="post" modelAttribute="utente">
			<table border="0" cellpadding="5">
				<tr>
					<td>ID:</td>
					<td>${utente.id}<form:hidden path="id" /></td>
				</tr>
				<tr>
					<td>Nome:</td>
					<td><form:input path="nome" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>Username:</td>
					<td><form:input path="username" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:input type = "password" path="password" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Save">
					</td>
					
				</tr>
				
			</table>
			
		</form:form>
	</div>
</body>
</html>