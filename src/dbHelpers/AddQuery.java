/**
 * 
 */
package dbHelpers;

import java.sql.Connection;  
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Incident;


public class AddQuery {
	
	public Connection connection;
	
	public AddQuery(String dbName, String uname, String pwd){
		String url = "jdbc:mysql://localhost:3306/" + dbName;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			this.connection = DriverManager.getConnection(url, uname, pwd); 
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void doAdd(Incident incident){
		String query = "insert into incident (cause_of_failure, GPS_location, reported_by, damage_to_drone, external_dmg, police_incidence_report, emergency_phone_contact) values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, incident.getCause_of_failure());
			ps.setString(2, incident.getGPS_location());
			ps.setString(3, incident.getReported_by());
			ps.setString(4, incident.getDamage_to_drone());
			ps.setString(5, incident.getExternal_dmg());
			ps.setString(6, incident.getPolice_incidence_report());
			ps.setString(7, incident.getEmergency_phone_contact());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
