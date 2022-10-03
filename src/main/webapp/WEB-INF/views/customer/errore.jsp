<%@ page language="java" contentType="text/html; charset=UTF-8)"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Errore</title>
</head>
<body>
<form name='f' action="home/errore" method='post'>

<h1>Username o password errata.</h1>

<h3><a href="<c:url value="/"/>">Indietro</a></h3>
</form>
</body>
</html>