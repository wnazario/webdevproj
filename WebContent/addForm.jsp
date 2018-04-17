<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Add Incidence</title>
</head>
<body>

<h1>Add Incidence</h1>

<form name=addForm action=addIncident method=get >
   
   <label>
      Cause of Failure:
   </label>
   <input type=text name=cause_of_failure value="" />
   <br />
   <label>
      GPS Location:
   </label>
   <input type=text name=GPS_location value="" />
   <br />
   <label>
      Reported by:
   </label>
   <input type=text name=reported_by value="" />
   <br />
   <label>
      Damage to Drone:
   </label>
   <input type=text name=damage_to_drone value="" />
   <br />
   <label>
      External Damage:
   </label>
   <input type=text name=external_dmg value="" />
   <br />
   <label>
      Police Incidence Report:
   </label>
   <input type=text name=police_incidence_report value="" />
   <br />
   <label>
      Emergency Contact:
   </label>
   <input type=text name=emergency_phone_contact value="" />
   <br />
   	
   
   <input type=submit name=submit value="Add Record" />

</form>
</body>
</html>