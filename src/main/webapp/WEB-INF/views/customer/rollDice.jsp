<%@ page language="java" contentType="text/html; charset=UTF-8)"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isELIgnored="false"%>
    
    
<!DOCTYPE  html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tira i dadi</title>
</head>
<style type="text/css">
div.dice{
float:left;
width:32px;
background: #F5F5F5;
border: #999 1px solid;
padding: 10px;
font-size: 24px;
text-align:center;
margin: 5px;
}

</style>


<body>
<script>

function rollDice(){

    var die1 = document.getElementById("die1");
    var die2 = document.getElementById("die2");
    var status = document.getElementById("status");
    var d1 = Math.floor(Math.random() * 6 + 1);
    var d2 = Math.floor(Math.random() * 6 + 1);
    var diceTotal = d1 + d2;
    die1.innerHTML = d1;
    die2.innerHTML = d2;
    status.innerHTML ="You rolled " + diceTotal + ".";
    if(d1 == d2){

        status.innerHTML += "DOUBLES! Your get a free turn! !";
    }
}
</script>
<div align="center">
		<h2>Gioca</h2>
		
			<form:form action="rollDice" method="post" modelAttribute="utente"> 
			<table>
				<tr>
					
				<td>${utente.id}<form:hidden path="id" /></td>
				</tr>
			<tr>	
			<td><div id="die1" class="dice">0</div>
			<div id="die2" class="dice">0</div>
			
			<div> </div>
			<button onclick="rollDice()">Roll Dice</button>
			<h2 id="status" style ="clear:left;"></h2></td> 
			</tr>	
			</table>
		</form:form> 
	</div>



</body>
</html>