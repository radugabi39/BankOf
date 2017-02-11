package ro.fmi.bnk.enitites;

import java.math.BigDecimal;
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
@Table(name = "EMPLOYEE")
public class Employee {

	private Long id;
	private String firstName;
	private String lastName;
	private SexEnum sex;
	private Date dob;
	private Date employmentDate;
	private BigDecimal salary;
	private Branch branch;
	private Department department;
	private Employee manager;
	private Title title;
	private User user;
	private Date creationDate;
	private Date modificationDate;
	private Boolean active;

	public Employee() {
		super();
	}

	public Employee(Long id, String firstName, String lastName, SexEnum sex, Date dob, Date employmentDate,
			BigDecimal salary, Branch branch, Department department, Employee manager, Title title, User user,
			Date creationDate, Date modificationDate, Boolean active) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.sex = sex;
		this.dob = dob;
		this.employmentDate = employmentDate;
		this.salary = salary;
		this.branch = branch;
		this.department = department;
		this.manager = manager;
		this.title = title;
		this.user = user;
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

	@Column(name = "FIRSTNAME", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LASTNAME", nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "SEX", nullable = false)
	public SexEnum getSex() {
		return sex;
	}

	public void setSex(SexEnum sex) {
		this.sex = sex;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DOB")
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "EMPLOYMENTDATE")
	public Date getEmploymentDate() {
		return employmentDate;
	}

	public void setEmploymentDate(Date employmentDate) {
		this.employmentDate = employmentDate;
	}

	@Column(name = "SALARY")
	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRANCH_ID")
	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPARTMENT_ID")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MANAGER_ID")
	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TITLE_ID")
	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
