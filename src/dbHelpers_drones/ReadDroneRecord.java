/**
 * 
 */
package dbHelpers_drones;

import java.sql.Connection;   
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Drone;

public class ReadDroneRecord {
	
	private Connection connection;
	private ResultSet results;
	
	private Drone drone = new Drone();
	private int id;
	
	public ReadDroneRecord(String dbName, String uname, String pwd, int id){
		
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
		String query = "select * from drone_inventory where droneID = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, this.id);
			
			this.results = ps.executeQuery();
			
			this.results.next();
			
			drone.setDroneID(this.results.getInt(1));
			drone.setMake(this.results.getString("make"));
			drone.setModel(this.results.getString("model"));
			drone.setYear(this.results.getString("year"));
			drone.setLast_service(this.results.getString("last_service"));
			drone.setService_loc(this.results.getString("service_loc"));
			drone.setVIN(this.results.getString("VIN"));
			drone.setFaa_lic(this.results.getString("faa_lic"));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Drone getDrone(){
		return this.drone;
	}
	
	

}
