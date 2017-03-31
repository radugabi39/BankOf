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

@Entity
@Table(name = "SCHEDULER")
public class Scheduler {
	
			private Long id;
			private Account toAccount;
			private Account fromAccount;
			private Customer customer;
			private Date nextPayment;
			private Boolean active;
			private Date creationDate;
			private Date modificationDate;
			private BigDecimal amount;
			
			public Scheduler() {
				super();
			}
			public Scheduler(Long id, Account toAccount, Account fromAccount,Customer customer, Date nextPayment, Boolean active,
					Date creationDate, Date modificationDate, BigDecimal amount) {
				super();
				this.id = id;
				this.toAccount = toAccount;
				this.fromAccount = fromAccount;
				this.nextPayment = nextPayment;
				this.setCustomer(customer);
				this.active = active;
				this.creationDate = creationDate;
				this.modificationDate = modificationDate;
				this.amount = amount;
			}
			@Id
			@GeneratedValue(strategy = GenerationType.IDENTITY)
			@Column(name = "ID")
			public Long getId() {
				return id;
			}

			public void setId(Long id) {
				this.id = id;
			}
			@ManyToOne(fetch = FetchType.LAZY)
			@JoinColumn(name = "DESTINATIONACCOUNT_ID")
			public Account getToAccount() {
				return toAccount;
			}

			public void setToAccount(Account toAccount) {
				this.toAccount = toAccount;
			}
			@ManyToOne(fetch = FetchType.LAZY)
			@JoinColumn(name = "ACCOUNT_ID")
			public Account getFromAccount() {
				return fromAccount;
			}

			public void setFromAccount(Account fromAccount) {
				this.fromAccount = fromAccount;
			}
			@Column(name = "NEXTPAYMENT")
			public Date getNextPayment() {
				return nextPayment;
			}

			public void setNextPayment(Date nextPayment) {
				this.nextPayment = nextPayment;
			}
			@Column(name = "ACTIVE")
			public Boolean getActive() {
				return active;
			}

			public void setActive(Boolean active) {
				this.active = active;
			}
			@Column(name = "CREATIONDATE")
			public Date getCreationDate() {
				return creationDate;
			}

			public void setCreationDate(Date creationDate) {
				this.creationDate = creationDate;
			}
			@Column(name = "MODIFICATIONDATE")
			public Date getModificationDate() {
				return modificationDate;
			}

			public void setModificationDate(Date modificationDate) {
				this.modificationDate = modificationDate;
			}
			@Column(name = "AMOUNT")
			public BigDecimal getAmount() {
				return amount;
			}

			public void setAmount(BigDecimal amount) {
				this.amount = amount;
			}
			@ManyToOne(fetch = FetchType.LAZY)
			@JoinColumn(name = "CUSTOMER_ID")
			public Customer getCustomer() {
				return customer;
			}
			public void setCustomer(Customer customer) {
				this.customer = customer;
			}
			
			
}
