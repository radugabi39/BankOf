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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "COMPANY")
public class Company {

	private Long id;
	private String name;
	private ContactType contactType;
	private Customer customer;
	private Date creationDate;
	private Date modificationDate;
	private Boolean active;

	public Company() {
		super();
	}

	public Company(Long id, String name, ContactType contactType, Customer customer, Date creationDate,
			Date modificationDate, Boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.contactType = contactType;
		this.customer = customer;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.active = active;
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
	@JoinColumn(name = "CONTACTTYPE_ID")
	public ContactType getContactType() {
		return contactType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

}
