/**
 * 
 */
package dbHelpers_witness;

import java.sql.Connection;      
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Witness;


public class ReadWitnessQuery {
	
	private Connection connection;
	private ResultSet results;
	
	public ReadWitnessQuery(String dbName, String uname, String pwd){
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
		String query = "select * from incidentWitness";
		
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
				+ "<td><b>Name</b></td>"
				+ "<td><b>Phone</b></td>"
				+ "<td><b>E-mail</b></td>"
				+ "<td><b>Witness Type</b></td>"
				+ "<td><b>Witness Report</b></td>"
				+ "<td><b>Emergency Contact</b></td>"
				+ "<td><b>Actions</b></td>"
				+ "</tr>";
		
		try {
			while(this.results.next()){
				Witness witness = new Witness();
				witness.setWitnessID(this.results.getInt("witnessID"));
				witness.setName(this.results.getString("name"));
				witness.setPhone(this.results.getInt("phone"));
				witness.setEmail(this.results.getString("email"));
				witness.setWitness_type(this.results.getString("witness_type"));
				witness.setWitness_report(this.results.getString("witnessReport"));
				witness.setEmergencyContact(this.results.getString("emergencyContact"));
				
				table +="<tr>";
				table +="<td>";
				table += witness.getName();
				table +="</td>";
				table +="<td>";
				table += witness.getPhone();
				table +="</td>";
				table +="<td>";
				table += witness.getEmail();
				table +="</td>";
				table +="<td>";
				table += witness.getWitness_type();
				table +="</td>";
				table +="<td>";
				table += witness.getWitness_report();
				table +="</td>";
				table +="<td>";
				table += witness.getEmergencyContact();
				table +="</td>";
				table +="<td>";
				   table += "<a href=update4?witnessID=" + witness.getWitnessID() + " >update</a> <a href=deleteWitness?witnessID=" + witness.getWitnessID() + " >delete</a>";
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
