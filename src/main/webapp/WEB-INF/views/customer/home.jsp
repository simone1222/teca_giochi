<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title >Enter And Game</title></head>
<body style="background-color:#00008B;">

<h1 style=height:1px align="center" >
<img src='https://img.freepik.com/free-vector/games-time-neon-text-with-gamepad_1262-15457.jpg?w=1400'/></h1>
 <h1 style="color:red;"style="Arial;" align="center">ACCEDI</h1>
 
 
 <form:form action="home/index" method="post" modelAttribute="utente">
    <table bordercolor="black;" style="Arial;" align="center">
       <tr>
          <td style="color:#FFD700;"  style="Arial;" align="right">Username:</td>
          <td><form:input type='text' path='username'/></td>
       </tr>
       <tr>
          <td style="color:#FFD700;" style="Arial;" align="right">Password:</td>
          <td><form:input type='password' path='password'/></td>
       </tr>
       <tr>
          <td><input  name="submit" type="submit" value="Entra" /></td>
       </tr>
      
    </table>
    <h3 style="color:#FFD700;" align="right" >
			Se non sei registrato: &nbsp;&nbsp;&nbsp; <br>
			<a style="color:black;" href="new" >
			<input   type="button" value="CREA NUOVO UTENTE"/></a>
			
		</h3>
</form:form>
</body>
</html>