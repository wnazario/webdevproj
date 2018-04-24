<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
<%
    String table = (String) request.getAttribute("table");

%>    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Emergency Prevention</title>
</head>
<body>
<body class="content">

<div class="box">
<h1>Emergency Prevention</h1>

<%= table %>

<br />

<br />
<a href="add2">Add Record</a>

</div>
</body>
</html>