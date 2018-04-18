<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
  String msg = (String) request.getAttribute("msg");
%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Input Errors</title>
</head>
<body>
<h1>Input Errors</h1>

<p>Some of the data that you entered was incorrect.</p>
<p>
<%= msg %>
</p>
<p>
<a href="index.html">Try again.</a>
</p>
</body>
</html>