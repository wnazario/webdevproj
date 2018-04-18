package model;

public class EmergencyPrevention {
	private int emergencyPreventionID;
	private String emergencyContact;
	private String droneOperator;
	private String operatorActions;
	private String operatorComments;
	
	public EmergencyPrevention() {
		
	}
	
	public EmergencyPrevention(int emergencyPreventionID, String emergencyContact, String droneOperator, String operatorActions, String operatorComments) {
		this.emergencyPreventionID = emergencyPreventionID;
		this.emergencyContact = emergencyContact;
		this.droneOperator = droneOperator;
		this.operatorActions = operatorActions;
		this.operatorComments = operatorComments;
	}
	
	public int getEmergencyPreventionID() {
		return emergencyPreventionID;
	}
	public void setEmergencyPreventionID(int emergencyPreventionID) {
		this.emergencyPreventionID = emergencyPreventionID;
	}
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	public String getDroneOperator() {
		return droneOperator;
	}
	public void setDroneOperator(String droneOperator) {
		this.droneOperator = droneOperator;
	}
	public String getOperatorActions() {
		return operatorActions;
	}
	public void setOperatorActions(String operatorActions) {
		this.operatorActions = operatorActions;
	}
	public String getOperatorComments() {
		return operatorComments;
	}
	public void setOperatorComments(String operatorComments) {
		this.operatorComments = operatorComments;
	}
	
	
}