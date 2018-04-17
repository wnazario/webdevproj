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

public class ReadRecord {
	
	private Connection connection;
	private ResultSet results;
	
	private Incident incident = new Incident();
	private int id;
	
	public ReadRecord(String dbName, String uname, String pwd, int id){
		
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		this.id = id;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd);
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void doRead(){
		String query = "select * from incident where incidentID = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, this.id);
			
			this.results = ps.executeQuery();
			
			this.results.next();
			
			incident.setincidentID(this.results.getInt(1));
			incident.setCause_of_failure(this.results.getString("cause_of_failure"));
			incident.setGPS_location(this.results.getString("GPS_location"));
			incident.setReported_by(this.results.getString("reported_by"));
			incident.setDamage_to_drone(this.results.getString("damage_to_drone"));
			incident.setExternal_dmg(this.results.getString("external_dmg"));
			incident.setPolice_incidence_report(this.results.getString("police_incidence_report"));
			incident.setEmergency_phone_contact(this.results.getString("emergency_phone_contact"));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Incident getIncident(){
		return this.incident;
	}
	
	

}
