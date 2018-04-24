package model;

public class Witness {
	private int witnessID;
	private String name;
	private int phone;
	private String email;
	private String address;
	private String witness_type;
	private String witness_report;
	private String emergencyContact;
	
	public Witness() {
		this.witnessID = 0000;
		this.name = "name";
		this.phone = 0;
		this.email = "email";
		this.address = "address";
		this.witness_type = "witness_type";
		this.witness_report = "witness report";
		this.emergencyContact = "emergencyContact";
	}
	
	public Witness(int witnessID, String name, int phone, String email, String address, String witness_type, String witness_report,
			String emergencyContact) {
		this.witnessID = witnessID;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.witness_type = witness_type;
		this.witness_report = witness_report;
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

	public String getWitness_type() {
		return witness_type;
	}

	public void setWitness_type(String witness_type) {
		this.witness_type = witness_type;
	}
	
	public String getWitness_report() {
		return witness_report;
	}

	public void setWitness_report(String witness_report) {
		this.witness_report = witness_report;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	
}
