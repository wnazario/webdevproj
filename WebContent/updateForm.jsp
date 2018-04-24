<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
<%@ page import="model.Incident" %>
    
<% Incident incident = (Incident) request.getAttribute("incident"); %>    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Incidents: Update Record</title>
</head>
<body class="content">

<div class="box">
<h1>Incidents: Update Record</h1>

<form name=updateForm action=updateIncident method=get class="box">
   
   <label>
      ID:
   </label>
   <input type=text name=incidentID value="<%= incident.getincidentID() %>" />
   <br />
   <label>
      Cause of Failure:
   </label>
   <input type=text name=cause_of_failure value="<%= incident.getCause_of_failure()%>" />
   <br />
   <label>
      GPS Location:
   </label>
   <input type=text name=GPS_location value="<%= incident.getGPS_location() %>" />
   <br />
   <label>
      Reported by:
   </label>
   <input type=text name=reported_by value="<%=incident.getReported_by() %>" />
   <br />
   <label>
      Damage to Drone:
   </label>
   <input type=text name=damage_to_drone value="<%=incident.getDamage_to_drone() %>" />
   <br />
   <label>
      External Damage:
   </label>
   <input type=text name=external_dmg value="<%=incident.getExternal_dmg() %>" />
   <br />
   <label>
      Police Incidence Report:
   </label>
   <input type=text name=police_incidence_report value="<%=incident.getPolice_incidence_report() %>" />
   <br />
   <label>
      Emergency Contact:
   </label>
   <input type=text name=emergency_phone_contact value="<%=incident.getEmergency_phone_contact()%>" />
   <br />
   
   <input type=submit name=submit value="Update Record" />

</form>
</div>
</body>
</html>