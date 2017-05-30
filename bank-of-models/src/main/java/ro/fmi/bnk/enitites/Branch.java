package ro.fmi.bnk.enitites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Branch")
public class Branch {

	private Long id;
	private String name;
	private City city;
	private String address;
	private String email;
	private Employee manager;
	private Date creationDate;
	private Date modificationDate;
	private Boolean active;
	private Double longitude;
	private Double latitude;

	public Branch() {
		super();
	}

	public Branch(Long id, String name, City city, String address, String email, Employee manager, Date creationDate,
			Date modificationDate, Boolean active, Double longitude, Double latitude) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.address = address;
		this.email = email;
		this.manager = manager;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.active = active;
		this.longitude = longitude;
		this.latitude = latitude;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_ID")
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MANAGER_ID")
	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATIONDATE")
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFICATIONDATE")
	public Date getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Date modificationDate) {
		this.modificationDate = modificationDate;
	}

	@Column(name = "ACTIVE")
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	@Column(name = "LONGITUDE")
	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	@Column(name = "LATITUDE")
	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

}
