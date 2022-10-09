<%@ page language="java" contentType="text/html; charset=UTF-8)"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Utente Manager</title>
</head>
<body>

	<h3></h3>
	<h3><a href="<c:url value="/"/>">Logout</a></h3>
	
	
	
	<div align="center">
		<h2>BENVENUTO</h2>
		<form method="post" action="search">
			<input type="text" name="keyword" /> &nbsp; <input type="submit"
				value="Search" />
				
													
				
				
				
		</form>
		<h3>
			Scegli un'azione per continuare
		</h3>
		
	
	
	
		<table border="1" cellpadding="5">
			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>E-mail</th>
				<th>Username</th>
				<th>Azioni</th>
				

			</tr>
			<c:forEach items="${utenti}" var="utente">
				<tr>
				
					<td>${utente.id}</td>
					<td>${utente.nome}</td>
					<td>${utente.email}</td>
					<td>${utente.username}</td>
					<td><a href="edit?id=${utente.id}">| Modifica Account |</a>
						&nbsp;&nbsp;&nbsp; <a href="delete?id=${utente.id}">| Elimina Account |</a>
					
					<c:if test="${sessionScope.idUsernameLogged == utente.id}">
&nbsp;&nbsp;&nbsp; <a href="viewsGame?id=${utente.id}">| Gioca |</a>&nbsp;&nbsp;&nbsp;
</c:if>
					
					&nbsp;&nbsp;&nbsp; <a href="listaGiochiUtente?id=${utente.id}">| Lista Giochi Utente |</a>&nbsp;&nbsp;&nbsp;
					<a href=https://www.youtube.com>| Musica |</a>
					</td>
					
				</tr>
			</c:forEach>
		</table>
	</div>
	
	
	
	
</body>
</html>