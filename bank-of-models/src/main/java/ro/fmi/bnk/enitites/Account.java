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
@Table(name = "ACCOUNT")
public class Account {

	private Long id;
	private BigDecimal balance;
	private Integer interestRate;
	private Boolean overDraft;
	private AccountStatus accountStatus;
	private AccountType accountType;
	private String accountNo;
	private Customer customer;
	private Date creationDate;
	private Date modificationDate;
	private Boolean active;
	private Currency currency;
	//Savings 
	private BigDecimal limitAmount;
	private boolean smsAlert;
	public Account() {
		super();
	}
	public Account(Long id, BigDecimal balance, Integer interestRate, Boolean overDraft, AccountStatus accountStatus,
			AccountType accountType, String accountNo, Customer customer, Date creationDate, Date modificationDate,
			Boolean active,Currency currency,BigDecimal limitAmount,boolean smsAlert) {
		super();
		this.id = id;
		this.balance = balance;
		this.interestRate = interestRate;
		this.overDraft = overDraft;
		this.accountStatus = accountStatus;
		this.accountType = accountType;
		this.accountNo = accountNo;
		this.customer = customer;
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.active = active;
		this.currency = currency;
		this.limitAmount = limitAmount;
		this.setSmsAlert(smsAlert);
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

	@Column(name = "BALANCE")
	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	@Column(name = "INTERESTRATE")
	public Integer getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Integer interestRate) {
		this.interestRate = interestRate;
	}

	@Column(name = "OVERDRAFT")
	public Boolean getOverDraft() {
		return overDraft;
	}

	public void setOverDraft(Boolean overDraft) {
		this.overDraft = overDraft;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNTSTATUS_ID")
	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNTTYPE_ID")
	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	@Column(name = "ACCOUNTNO", nullable = false)
	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CUSTOMER_ID", nullable = false)
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CURRENCY_ID")
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	@Column(name = "LIMITAMOUNT")
	public BigDecimal getLimitAmount() {
		return limitAmount;
	}
	public void setLimitAmount(BigDecimal limitAmount) {
		this.limitAmount = limitAmount;
	}
	
	@Column(name = "SMSALERT")
	public boolean isSmsAlert() {
		return smsAlert;
	}
	public void setSmsAlert(boolean smsAlert) {
		this.smsAlert = smsAlert;
	}
}
