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


public class ReadDroneQuery {
	
	private Connection connection;
	private ResultSet results;
	
	public ReadDroneQuery(String dbName, String uname, String pwd){
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
		String query = "select * from drone_inventory";
		
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
		table += "<table border=1>";
		
		try {
			while(this.results.next()){
				Drone drone = new Drone();
				drone.setDroneID(this.results.getInt("droneID"));
				drone.setMake(this.results.getString("make"));
				drone.setModel(this.results.getString("model"));
				drone.setYear(this.results.getString("year"));
				drone.setLast_service(this.results.getString("last_service"));
				drone.setService_loc(this.results.getString("service_loc"));
				drone.setVIN(this.results.getString("VIN"));
				drone.setFaa_lic(this.results.getString("faa_lic"));
				
				
				table +="<tr>";
				table +="<td>";
				table += drone.getMake();
				table +="</td>";
				table +="<td>";
				table += drone.getModel();
				table +="</td>";
				table +="<td>";
				table += drone.getYear();
				table +="</td>";
				table +="<td>";
				table += drone.getLast_service();
				table +="</td>";
				table +="<td>";
				table += drone.getService_loc();
				table +="</td>";
				table +="<td>";
				table += drone.getVIN();
				table +="</td>";
				table +="<td>";
				table += drone.getFaa_lic();
				table +="</td>";
				table +="<td>";
				   table += "<a href=update2?droneID=" + drone.getDroneID() + " >update</a>";
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
