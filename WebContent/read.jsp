<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
<%
    String table = (String) request.getAttribute("table");

%>    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Incidents</title>
</head>
<body>

<h1>Incidents</h1>

<%= table %>
<br />
<a href="add">Add Record</a>


</body>
</html>