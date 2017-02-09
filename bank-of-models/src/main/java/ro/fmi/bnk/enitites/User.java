package ro.fmi.bnk.enitites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User {

	private Long id;
	private String firstName;
	private String lastName;
	private String address;
	
	
	public User() {
		super();
	}



	public User(Long id, String firstName, String lastName,String address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID",nullable = false)
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="FIRSTNAME")
	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	@Column(name="LASTNAME")
	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	@Column(name="ADDRESS")
	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
