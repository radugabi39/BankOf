package ro.fmi.bnk.models;

public class CountryCityMapping {

	private String country;
	private String city;
	
	public CountryCityMapping(String country, String city) {
		super();
		this.country = country;
		this.city = city;
	}
	public CountryCityMapping() {
		super();
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
