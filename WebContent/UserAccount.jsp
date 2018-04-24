<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Home</title>
</head>
<body class="content">
<div class="box">
<h1>Welcome, ${user.username}!</h1>
<p>You have successfully logged in, congratulations.<br>
Click <a href="Login?logout=true">here</a> to log back out.
</p>
</div>

</body>
</html>