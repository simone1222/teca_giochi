<%@ page language="java" contentType="text/html; charset=UTF-8)"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Giochi</title>
</head>
<body>
<h1 style=height:40px align="center"><img style="height:500px;" src='https://www.exoprimal.com/assets/images/mv.jpg'/></h1>

<h3></h3>
	<h3><a href="<c:url value="/"/>">Logout</a></h3>
	<h2 align="center">Qui puoi scegliere i tuoi generi preferiti</h2>
	<div id="id_Genere" align="center" >
		
		<form:form method="post" modelAttribute="utente">
			<table border="0" cellpadding="5">
				<tr>

					<td style="color:red;" align="center"><form:hidden path="id" /><h2>${utente.username}</h2></td>
				</tr>
				<tr>
					<%-- 					<td>${genere.id}<form:hidden path="id_Genere" /></td> --%>
				<thead>
					<tr>
						<th >UTENTE</th>

					</tr>
				</thead>

				
					
				
			
			</table>
			<table border="0" cellpadding="5">
			
			<tr><thead>
					<tr>
						<th>SCEGLI UN GENERE</th>
					

						<td></td>
					<td>
					
					
					</tr></thead>
						
						
			
						<tr>
						
						
						<td>
						<h3>Generi:</h3>
						<ul> <!-- lista principale: definisce il menu nella sua interezza -->
						<li>
						
						
						<form:hidden path="nome" /> <!-- primo list-item, prima voce del menu -->
						
						
						<ul> <!-- Lista annidata: voci del sotto-menu -->
						<li><a href=""><input type="button" value="RUOLO"/></a></li>
						<li><a href="#"><input type="button" value="SIMULAZIONE"/></a></li>
						<li><a href="#"><input type="button" value="AZIONE"/></a></li>
						<li><a href="#"><input type="button" value="AVVENTURA"/></a></li>						
						<li><a href="#"><input type="button" value="ALTRO"/></a></li>
						
						</ul> <!-- Fine del sotto-menu -->
						</li> </td><!-- Chiudo il list-item -->
						<!--qui altri list-item -->
					</tr>
			
						</table>
			
			
		</form:form>
	</div>
</body>
</html>