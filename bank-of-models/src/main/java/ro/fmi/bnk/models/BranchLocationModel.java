package ro.fmi.bnk.models;

public class BranchLocationModel {
		
	private String name;
	private Double longitude;
	private Double latitude;
	
	public BranchLocationModel(String name, Double longitude, Double latitude) {
		super();
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
}
