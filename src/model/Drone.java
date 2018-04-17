package model;

public class Drone {
	private int droneID;
	private String make;
	private String model;
	private String year;
	private String last_service;
	private String service_loc;
	private String VIN;
	private String faa_lic;
	
	public Drone() {
		this.droneID = 0;
		this.make = "make";
		this.model = "model";
		this.year = "year";
		this.last_service = "last_service";
		this.service_loc = "service_loc";
		this.VIN = "VIN";
		this.faa_lic = "faa_lic";
	}
	
	public Drone(int droneID, String make, String model, String year, String last_service, String service_loc,String vIN, String faa_lic) {
		this.droneID = droneID;
		this.make = make;
		this.model = model;
		this.year = year;
		this.last_service = last_service;
		this.service_loc = service_loc;
		this.VIN = vIN;
		this.faa_lic = faa_lic;
	}

	public int getDroneID() {
		return droneID;
	}

	public void setDroneID(int droneID) {
		this.droneID = droneID;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLast_service() {
		return last_service;
	}

	public void setLast_service(String last_service) {
		this.last_service = last_service;
	}

	public String getService_loc() {
		return service_loc;
	}

	public void setService_loc(String service_loc) {
		this.service_loc = service_loc;
	}

	public String getVIN() {
		return VIN;
	}

	public void setVIN(String vIN) {
		VIN = vIN;
	}

	public String getFaa_lic() {
		return faa_lic;
	}

	public void setFaa_lic(String faa_lic) {
		this.faa_lic = faa_lic;
	}
	
}
