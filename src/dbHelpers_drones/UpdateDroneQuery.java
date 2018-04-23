/**
 * 
 */
package dbHelpers_drones;

import java.sql.Connection;    
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Drone;

public class UpdateDroneQuery {
	
	private Connection connection;
	
	public UpdateDroneQuery(String dbName, String uname, String pwd){
		
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
	
	public void doUpdate(Drone drone){
		String query = "update drone_inventory set make=?, model=?, year=?, last_service=?, service_loc=?, VIN=?, faa_lic=? where droneID=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, drone.getMake());
			ps.setString(2, drone.getModel());
			ps.setString(3, drone.getYear());
			ps.setString(4, drone.getLast_service());
			ps.setString(5, drone.getService_loc());
			ps.setString(6, drone.getVIN());
			ps.setString(7, drone.getFaa_lic());
			ps.setInt(8, drone.getDroneID());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
