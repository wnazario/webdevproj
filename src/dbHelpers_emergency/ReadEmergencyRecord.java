/**
 * 
 */
package dbHelpers_emergency;

import java.sql.Connection;   
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Emergency;

public class ReadEmergencyRecord {
	
	private Connection connection;
	private ResultSet results;
	
	private Emergency emergency = new Emergency();
	private int id;
	
	public ReadEmergencyRecord(String dbName, String uname, String pwd, int id){
		
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
		String query = "select * from emergencyprevention where emergencyID = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, this.id);
			
			this.results = ps.executeQuery();
			
			this.results.next();
			
			emergency.setEmergencyID(this.results.getInt(1));
			emergency.setEmergency_contact(this.results.getString("emergencyContact"));
			emergency.setDrone_operator(this.results.getString("drone_operator"));
			emergency.setOperator_actions(this.results.getString("operator_actions"));
			emergency.setOperator_comments(this.results.getString("operator_comments"));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Emergency getEmergency(){
		return this.emergency;
	}
	
	

}
