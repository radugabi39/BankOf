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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TRANSACTION")
public class Transaction {

	private Long id;
	private BigDecimal amount;
	private String description;
	private TransactionType transactionType;
	private Employee employee;
	private Account account;
	private Account destinationAccount;
	private TransactionStatus transactionStatus;
	private Date creationDate;
	private Date modificationDate;
	private Boolean active;

	public Transaction() {
		super();
	}

	public Transaction(Long id, BigDecimal amount, String description, TransactionType transactionType,
			Employee employee, Account account, Account destinationAccount, TransactionStatus transactionStatus,
			Date creationDate, Date modificationDate, Boolean active) {
		super();
		this.id = id;
		this.amount = amount;
		this.description = description;
		this.transactionType = transactionType;
		this.employee = employee;
		this.account = account;
		this.destinationAccount = destinationAccount;
		this.transactionStatus = transactionStatus;
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
	@Column(name = "AMOUNT")
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRANSACTIONTYPE_ID")
	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE_ID")
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_ID")
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DESTINATIONACCOUNT_ID")
	public Account getDestinationAccount() {
		return destinationAccount;
	}

	public void setDestinationAccount(Account destinationAccount) {
		this.destinationAccount = destinationAccount;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRANSACTIONSTATUS_ID")
	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
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
