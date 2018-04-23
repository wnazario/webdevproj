/**
 * 
 */
package dbHelpers_witness;

import java.sql.Connection;     
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Witness;


public class UpdateWitnessQuery {
	
	private Connection connection;
	
	public UpdateWitnessQuery(String dbName, String uname, String pwd){
		
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
	
	public void doUpdate(Witness witness){
		String query = "update incidentWitness set name=?, phone=?, email=?, address=?, witness_type=?, witnessReport=?, emergencyContact=? where witnessID=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setString(1, witness.getName());
			ps.setInt(2, witness.getPhone());
			ps.setString(3, witness.getEmail());
			ps.setString(4, witness.getAddress());
			ps.setString(5, witness.getWitness_type());
			ps.setString(6, witness.getWitness_report());
			ps.setString(7, witness.getEmergencyContact());

			ps.setInt(8, witness.getWitnessID());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
