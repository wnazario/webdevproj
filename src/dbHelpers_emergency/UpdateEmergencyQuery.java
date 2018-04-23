/**
 * 
 */
package dbHelpers_emergency;

import java.sql.Connection;    
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Emergency;


public class UpdateEmergencyQuery {
	
	private Connection connection;
	
	public UpdateEmergencyQuery(String dbName, String uname, String pwd){
		
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
	
	public void doUpdate(Emergency emergency){
		String query = "update emergencyprevention set emergencyContact=?, drone_operator=?, operator_actions=?, operator_comments=? where emergencyID=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, emergency.getEmergency_contact());
			ps.setString(2, emergency.getDrone_operator());
			ps.setString(3, emergency.getOperator_actions());
			ps.setString(4, emergency.getOperator_comments());

			ps.setInt(5, emergency.getEmergencyID());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
