package ro.fmi.bnk.models;

import java.math.BigDecimal;
import java.util.Date;



public class SchedulerModel {
	private Long id;
	private String toAccount;
	private String fromAccount;
	private Date nextPayment;
	private Boolean active;
	private BigDecimal amount;

	public SchedulerModel(Long id, String toAccount, String fromAccount, Date nextPayment, Boolean active,
			BigDecimal amount) {
		super();
		this.id = id;
		this.toAccount = toAccount;
		this.fromAccount = fromAccount;
		this.nextPayment = nextPayment;
		this.active = active;
		this.amount = amount;
	}

	public SchedulerModel() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public Date getNextPayment() {
		return nextPayment;
	}

	public void setNextPayment(Date nextPayment) {
		this.nextPayment = nextPayment;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
