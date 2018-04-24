<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Add Witness Information</title>
</head>
<body class="content">
<div  class="box">
<h1>Add Witness Information</h1>

<form name=addForm action=ValidateWitness method=get class="box">
   
   <label>
      Name:
   </label>
   <input type=text name=name value="" />
   <br />
   <label>
      Phone:
   </label>
   <input type=text name=phone value="" />
   <br />
   <label>
      Email:
   </label>
   <input type=text name=email value="" />
   <br />
   <label>
      Address:
   </label>
   <input type=text name=address value="" />
   <br />
   <label>
      Type:
   </label>
   <input type=text name=type value="" />
   <br />
   <label>
      Report:
   </label>
   <input type=text name=report value="" />
   <br />
   <label>
      Emergency Contact:
   </label>
   <input type=text name=emergency_contact value="" />
   	
   <input type=submit name=submit value="Add Record" />

</form>
</div>
</body>
</html>