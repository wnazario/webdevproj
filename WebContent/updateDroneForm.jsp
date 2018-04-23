<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
    
<%@ page import="model.Drone" %>
    
<% Drone drone = (Drone) request.getAttribute("drone"); %>    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Drones: Update Record</title>
</head>
<body>

<h1>Drones: Update Record</h1>

<form name=updateForm action=updateDrone method=get >
   
   <label>
      ID:
   </label>
   <input type=text name=droneID value="<%= drone.getDroneID() %>" />
   <br />
   <label>
      Make:
   </label>
   <input type=text name=make value="<%= drone.getMake()%>" />
   <br />
   <label>
      Model:
   </label>
   <input type=text name=model value="<%= drone.getModel() %>" />
   <br />
   <label>
      Year:
   </label>
   <input type=text name=year value="<%=drone.getYear() %>" />
   <br />
   <label>
      Last Service:
   </label>
   <input type=text name=last_service value="<%=drone.getLast_service() %>" />
   <br />
   <label>
      Service Location:
   </label>
   <input type=text name=service_loc value="<%=drone.getService_loc() %>" />
   <br />
   <label>
      VIN:
   </label>
   <input type=text name=VIN value="<%=drone.getVIN() %>" />
   <br />
   <label>
      FAA License:
   </label>
   <input type=text name=faa_lic value="<%=drone.getFaa_lic()%>" />
   <br />
   
   <input type=submit name=submit value="Update Record" />

</form>

</body>
</html>