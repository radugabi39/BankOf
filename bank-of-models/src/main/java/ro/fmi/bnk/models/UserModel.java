package ro.fmi.bnk.models;

public class UserModel {

    private String firstName;
	private String lastName;
	private String phone;
	private String address;
	private String CNP;
	private String email;
	private String city;
	private String country;
	
	public UserModel() {
		super();
	}
	public UserModel(String firstName, String lastName, String phone, String address, String CNP, String email,
			String city, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
		this.CNP = CNP;
		this.email = email;
		this.city = city;
		this.country = country;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCNP() {
		return CNP;
	}
	public void setCNP(String CNP) {
		this.CNP = CNP;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
}
