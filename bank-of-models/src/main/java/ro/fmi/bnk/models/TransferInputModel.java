package ro.fmi.bnk.models;

import java.math.BigDecimal;

public class TransferInputModel {


	private BigDecimal amount;
	private String fromAccount;
	private String destAccount;
	private String transDescription;
	public TransferInputModel() {
		super();
		}
	public TransferInputModel(BigDecimal amount, String fromAccount, String destAccount, String transDescription) {
		super();
		this.amount = amount;
		this.fromAccount = fromAccount;
		this.destAccount = destAccount;
		this.transDescription = transDescription;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getDestAccount() {
		return destAccount;
	}

	public void setDestAccount(String destAccount) {
		this.destAccount = destAccount;
	}

	public String getTransDescription() {
		return transDescription;
	}

	public void setTransDescription(String transDescription) {
		this.transDescription = transDescription;
	}
	
}
