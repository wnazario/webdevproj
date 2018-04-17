package model;

public class Incident {

	private int incidentID;
	private String cause_of_failure;
	private String GPS_location;
	private String reported_by;
	private String damage_to_drone;
	private String external_dmg;
	private String police_incidence_report;
	private String emergency_phone_contact;
	
	public Incident()
	{
		incidentID=000;
		cause_of_failure="none";
		GPS_location="1";
		reported_by="John Doe";
		damage_to_drone="none";
		external_dmg="none";
		police_incidence_report="none";
		emergency_phone_contact="000";
	}
	
	public Incident(int incidentID, String cause_of_failure, String GPS_location, String reported_by, 
			String dmg_to_drone, String external_dmg, String police_incidence_report, String emergency_phone_contact)
	{
		this.incidentID = incidentID;
		this.cause_of_failure = cause_of_failure;
		this.GPS_location = GPS_location;
		this.reported_by = reported_by;
		this.damage_to_drone = dmg_to_drone;
		this.external_dmg = external_dmg;
		this.police_incidence_report = police_incidence_report;
		this.emergency_phone_contact = emergency_phone_contact;
	}

	public int getincidentID() {
		return incidentID;
	}

	public void setincidentID(int incidentID) {
		this.incidentID = incidentID;
	}

	public String getCause_of_failure() {
		return cause_of_failure;
	}

	public void setCause_of_failure(String cause_of_failure) {
		this.cause_of_failure = cause_of_failure;
	}

	public String getGPS_location() {
		return GPS_location;
	}

	public void setGPS_location(String GPS_location) {
		this.GPS_location = GPS_location;
	}

	public String getReported_by() {
		return reported_by;
	}

	public void setReported_by(String reported_by) {
		this.reported_by = reported_by;
	}

	public String getDamage_to_drone() {
		return damage_to_drone;
	}

	public void setDamage_to_drone(String damage_to_drone) {
		this.damage_to_drone = damage_to_drone;
	}

	public String getExternal_dmg() {
		return external_dmg;
	}

	public void setExternal_dmg(String external_dmg) {
		this.external_dmg = external_dmg;
	}

	public String getPolice_incidence_report() {
		return police_incidence_report;
	}

	public void setPolice_incidence_report(String police_incidence_report) {
		this.police_incidence_report = police_incidence_report;
	}

	public String getEmergency_phone_contact() {
		return emergency_phone_contact;
	}

	public void setEmergency_phone_contact(String emergency_phone_contact) {
		this.emergency_phone_contact = emergency_phone_contact;
	}
	
	
}
