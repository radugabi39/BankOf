package ro.fmi.bnk.models;

import java.math.BigDecimal;

public class AccountModel {

	private String accountNo;
	private String currency;
	private BigDecimal balance;
	private String type;
	private Boolean overdraft;
	private String status;

	public AccountModel(String accountNo, String currency, BigDecimal balance, String type, Boolean overdraft,
			String status) {
		super();
		this.accountNo = accountNo;
		this.currency = currency;
		this.balance = balance;
		this.type = type;
		this.overdraft = overdraft;
		this.status = status;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(Boolean overdraft) {
		this.overdraft = overdraft;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
