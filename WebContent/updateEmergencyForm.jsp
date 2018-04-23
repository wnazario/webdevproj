<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
<%@ page import="model.Emergency" %>
    
<% Emergency emergency = (Emergency) request.getAttribute("emergency"); %>    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Emergency Prevention: Update Record</title>
</head>
<body>

<h1>Emergency Prevention: Update Record</h1>

<form name=updateForm action=updateEmergency method=get >
   
   <label>
      ID:
   </label>
   <input type=text name=emergencyID value="<%= emergency.getEmergencyID() %>" />
   <br />
   <label>
      Emergency Contact:
   </label>
   <input type=text name=emergencyContact value="<%= emergency.getEmergency_contact()%>" />
   <br />
   <label>
      Drone Operator:
   </label>
   <input type=text name=drone_operator value="<%= emergency.getDrone_operator() %>" />
   <br />
   <label>
      Operator Actions:
   </label>
   <input type=text name=operator_actions value="<%=emergency.getOperator_actions() %>" />
   <br />
   <label>
      Operator Comments:
   </label>
   <input type=text name=operator_comments value="<%=emergency.getOperator_comments() %>" />
   <br />
   
   <input type=submit name=submit value="Update Record" />

</form>

</body>
</html>