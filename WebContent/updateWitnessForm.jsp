<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
<%@ page import="model.Witness" %>
    
<% Witness witness = (Witness) request.getAttribute("witness"); %>    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Witness Report: Update Record</title>
</head>
<body>

<h1>Witness Report: Update Record</h1>

<form name=updateForm action=updateWitness method=get >
   
   <label>
      ID:
   </label>
   <input type=text name=witnessID value="<%= witness.getWitnessID() %>" />
   <br />
   <label>
      Name:
   </label>
   <input type=text name=name value="<%= witness.getName()%>" />
   <br />
   <label>
      Phone:
   </label>
   <input type=text name=phone value="<%= witness.getPhone() %>" />
   <br />
   <label>
      Email:
   </label>
   <input type=text name=email value="<%=witness.getEmail() %>" />
   <br />
   <label>
      Address:
   </label>
   <input type=text name=address value="<%=witness.getAddress() %>" />
   <br />
   <label>
      Type:
   </label>
   <input type=text name=type value="<%=witness.getWitness_type() %>" />
   <br />
   <label>
      Report:
   </label>
   <input type=text name=report value="<%=witness.getWitness_report() %>" />
   <br />
   <label>
      Emergency Contact:
   </label>
   <input type=text name=emergencyContact value="<%= witness.getEmergencyContact()%>" />
   <br />
   
   
   <input type=submit name=submit value="Update Record" />

</form>

</body>
</html>