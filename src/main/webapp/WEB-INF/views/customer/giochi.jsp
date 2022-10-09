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
	<h3>
		<a href="<c:url value="/"/>">Logout</a>
	</h3>


	<div align="center">
		<h2>BENVENUTO</h2>

		<h3>Scegli un'azione per continuare</h3>




		<table border="1" cellpadding="5">
			<tr>
				<th>GIOCO</th>
				<th>DATA USCITA</th>
				<th AZIONI></th>
			</tr>
			<c:forEach items="${giochi}" var="gioco">
				<tr>
					<td>${gioco.nome}</td>
					<td>${gioco.dataUscita}</td>
					<td><a href="/CustomerManager/giochi/acquista?idGioco=${gioco.id}&genere=${genere}"/>ACQUISTA</td>
				</tr>
			</c:forEach>
		</table>

		<c:if test="${not empty error}">
   ${error}
</c:if>
		<c:if test="${not empty success}">
    ${success}
</c:if>
	</div>




</body>
</html>