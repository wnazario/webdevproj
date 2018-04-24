<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Add Emergency Prevention</title>
</head>
<body class="content">
<div  class="box">

<h1>Add Emergency Information</h1>

<form name=addForm action=addEmergency method=get class="box">
   
   <label>
      Emergency Contact:
   </label>
   <input type=text name=emergency_contact value="" />
   <br />
   <label>
      Drone Operator:
   </label>
   <input type=text name=drone_operator value="" />
   <br />
   <label>
      Operator Actions:
   </label>
   <input type=text name=operator_actions value="" />
   <br />
   <label>
      Operator Comments:
   </label>
   <input type=text name=operator_comments value="" />
   <br />
   	
   	
   <input type=submit name=submit value="Add Record" />

</form>

</div>
</body>
</html>