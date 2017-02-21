package ro.fmi.bnk.models;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionTableModel {

	private String fromAccount;
	private String toAccount;
	private Date date;
	private String description;
	private String transactionStatus;
	private String transactionType;
	private BigDecimal amount;

	public TransactionTableModel(String fromAccount, String toAccount, Date date, String description,
			String transactionStatus, String transactionType, BigDecimal amount) {
		super();
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.date = date;
		this.description = description;
		this.transactionStatus = transactionStatus;
		this.transactionType = transactionType;
		this.setAmount(amount);
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getToAccount() {
		return toAccount;
	}

	public void setToAccount(String toAccount) {
		this.toAccount = toAccount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
