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


public class ReadEmergencyQuery {
	
	private Connection connection;
	private ResultSet results;
	
	public ReadEmergencyQuery(String dbName, String uname, String pwd){
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
		String query = "select * from emergencyprevention";
		
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
				Emergency emergency = new Emergency();
				emergency.setEmergencyID(this.results.getInt("emergencyID"));
				emergency.setEmergency_contact(this.results.getString("emergencyContact"));
				emergency.setDrone_operator(this.results.getString("drone_operator"));
				emergency.setOperator_actions(this.results.getString("operator_actions"));
				emergency.setOperator_comments(this.results.getString("operator_comments"));
				
				
				table +="<tr>";
				table +="<td>";
				table += emergency.getEmergency_contact();
				table +="</td>";
				table +="<td>";
				table += emergency.getDrone_operator();
				table +="</td>";
				table +="<td>";
				table += emergency.getOperator_actions();
				table +="</td>";
				table +="<td>";
				table += emergency.getOperator_comments();
				table +="</td>";
				table +="<td>";
				   table += "<a href=update3?emergencyID=" + emergency.getEmergencyID() + " >update</a> <a href=deleteEmergency?emergencyID=" + emergency.getEmergencyID() + " >delete</a>";
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
