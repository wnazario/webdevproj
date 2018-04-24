package model;

public class Emergency {
	private int emergencyID;
	private String emergency_contact;
	private String drone_operator;
	private String operator_actions;
	private String operator_comments;
	
	public Emergency() {
		this.emergencyID = 0;
		this.emergency_contact = "emergency contact";
		this.drone_operator = "drone operator";
		this.operator_actions = "operator actions";
		this.operator_comments = "operator comments";
	}
	
	public Emergency(int emergencyID, String emergency_contact, String drone_operator, String operator_actions, String operator_comments) {
		this.emergencyID = emergencyID;
		this.emergency_contact = emergency_contact;
		this.drone_operator = drone_operator;
		this.operator_actions = operator_actions;
		this.operator_comments = operator_comments;
	}

	public int getEmergencyID() {
		return emergencyID;
	}

	public void setEmergencyID(int emergencyID) {
		this.emergencyID = emergencyID;
	}

	public String getEmergency_contact() {
		return emergency_contact;
	}

	public void setEmergency_contact(String emergency_contact) {
		this.emergency_contact = emergency_contact;
	}

	public String getDrone_operator() {
		return drone_operator;
	}

	public void setDrone_operator(String drone_operator) {
		this.drone_operator = drone_operator;
	}

	public String getOperator_actions() {
		return operator_actions;
	}

	public void setOperator_actions(String operator_actions) {
		this.operator_actions = operator_actions;
	}

	public String getOperator_comments() {
		return operator_comments;
	}

	public void setOperator_comments(String operator_comments) {
		this.operator_comments = operator_comments;
	}

	
}
