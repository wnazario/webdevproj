<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
</head>
<body class="content">
<img src="" width=200px height=200px/>
<form id="loginForm" action="Login" method="POST" class="box">
	<div class="centerDiv">
	<h1>Login</h1>
	<input type="text" name="username" placeholder="Username" required><br>
	<input type="password" name="password" placeholder ="Password" required><br>
	<input type="submit" value="Login"><br>
	${errorMessage}
	</div>
</form>
</body>
</html>