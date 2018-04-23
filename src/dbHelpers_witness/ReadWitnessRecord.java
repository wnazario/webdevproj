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

public class ReadWitnessRecord {
	
	private Connection connection;
	private ResultSet results;
	
	private Witness witness = new Witness();
	private int id;
	
	public ReadWitnessRecord(String dbName, String uname, String pwd, int id){
		
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
		String query = "select * from incidentWitness where witnessID = ?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, this.id);
			
			this.results = ps.executeQuery();
			
			this.results.next();
			
			witness.setWitnessID(this.results.getInt(1));
			witness.setName(this.results.getString("name"));
			witness.setPhone(this.results.getInt("phone"));
			witness.setEmail(this.results.getString("email"));
			witness.setAddress(this.results.getString("address"));
			witness.setWitness_type(this.results.getString("witness_type"));
			witness.setWitness_report(this.results.getString("witnessReport"));
			witness.setEmergencyContact(this.results.getString("emergencyContact"));
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Witness getWitness(){
		return this.witness;
	}
	
	

}
