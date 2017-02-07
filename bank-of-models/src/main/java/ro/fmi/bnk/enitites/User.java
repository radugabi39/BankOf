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
	
	
	
	public User() {
		super();
	}



	public User(Long id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID",nullable = false)
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	@Column(name="FIRSTNAME",nullable =false)
	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	@Column(name="LASTNAME",nullable =false)
	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	
}
