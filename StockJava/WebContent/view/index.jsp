<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	rel="stylesheet">

<meta charset="ISO-8859-1">
<title>Login :)</title>
</head>
<body>

	<form method="post" action="/StockJava/Login" class="formLogin">
		<div>
			username: <input name="nomeUsuario"><br><br> 
			password: <input name="senhaUsuario" type="password"><br><br> 
			<input type="submit" />
		</div>
	</form>

</body>
</html>