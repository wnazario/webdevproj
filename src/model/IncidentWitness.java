package model;

public class IncidentWitness {
	private int witnessID;
	private String name;
	private int phone;
	private String email;
	private String address;
	private int typeOfWitness;
	private String witnessReport;
	private String emergencyContact;
	
	public IncidentWitness() {
		
	}
	
	public IncidentWitness(int witnessID, String name, int phone, String email, String address, int typeOfWitness, String witnessReport, String emergencyContact) {
		this.witnessID = witnessID;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.typeOfWitness = typeOfWitness;
		this.witnessReport = witnessReport;
		this.emergencyContact = emergencyContact;
	}
	
	public int getWitnessID() {
		return witnessID;
	}
	public void setWitnessID(int witnessID) {
		this.witnessID = witnessID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTypeOfWitness() {
		return typeOfWitness;
	}
	public void setTypeOfWitness(int typeOfWitness) {
		this.typeOfWitness = typeOfWitness;
	}
	public String getWitnessReport() {
		return witnessReport;
	}
	public void setWitnessReport(String witnessReport) {
		this.witnessReport = witnessReport;
	}
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	
	
}