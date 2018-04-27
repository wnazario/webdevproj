/**
 * 
 */
package dbHelpers;

import java.sql.Connection;   
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Incident;


public class ReadQuery {
	
	private Connection connection;
	private ResultSet results;
	
	public ReadQuery(String dbName, String uname, String pwd){
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		// set up the driver
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doRead(){
		String query = "select * from incident";
		
		try {
			PreparedStatement ps = this.connection.prepareStatement(query);
			this.results= ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getHTMLTable(){
		String table ="";
		table += "<table border=1>"
				+ "<tr bgcolor='#a3c1ad'>"
				+ "<td><b>Cause of Failure</b></td>"
				+ "<td><b>GPS Location</b></td>"
				+ "<td><b>Reported By</b></td>"
				+ "<td><b>Damage to Drone</b></td>"
				+ "<td><b>External Damage</b></td>"
				+ "<td><b>Police Incidence Report</b></td>"
				+ "<td><b>Emergency Phone Contact</b></td>"
				+ "<td><b>Actions</b></td>"
				+ "</tr>";
		
		try {
			while(this.results.next()){
				Incident incident = new Incident();
				incident.setincidentID(this.results.getInt("incidentID"));
				incident.setCause_of_failure(this.results.getString("cause_of_failure"));
				incident.setGPS_location(this.results.getString("GPS_location"));
				incident.setReported_by(this.results.getString("reported_by"));
				incident.setDamage_to_drone(this.results.getString("damage_to_drone"));
				incident.setExternal_dmg(this.results.getString("external_dmg"));
				incident.setPolice_incidence_report(this.results.getString("police_incidence_report"));
				incident.setEmergency_phone_contact(this.results.getString("emergency_phone_contact"));
				
				
				table +="<tr>";
				table +="<td>";
				table += incident.getCause_of_failure();
				table +="</td>";
				table +="<td>";
				table += incident.getGPS_location();
				table +="</td>";
				table +="<td>";
				table += incident.getReported_by();
				table +="</td>";
				table +="<td>";
				table += incident.getDamage_to_drone();
				table +="</td>";
				table +="<td>";
				table += incident.getExternal_dmg();
				table +="</td>";
				table +="<td>";
				table += incident.getPolice_incidence_report();
				table +="</td>";
				table +="<td>";
				table += incident.getEmergency_phone_contact();
				table +="</td>";
				table +="<td>";
				   table += "<a href=update?incidentID=" + incident.getincidentID() + " >update</a> <a href=delete?incidentID=" + incident.getincidentID() + " >delete</a>";
				table +="</td>";
				table +="</tr>";
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		table += "</table>";
		return table;
	}
	
	
	

}
