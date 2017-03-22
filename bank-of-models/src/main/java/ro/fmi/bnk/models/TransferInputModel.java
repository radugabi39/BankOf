package ro.fmi.bnk.models;

import java.math.BigDecimal;

public class TransferInputModel {


	private BigDecimal amount;
	private String fromAccount;
	private String destAccount;
	private String transDescription;
	private String provider;
	private Integer dateToPay;
	public TransferInputModel() {
		super();
		}
	public TransferInputModel(BigDecimal amount, String fromAccount, String destAccount, String transDescription, String provider, Integer dateToPay) {
		super();
		this.amount = amount;
		this.fromAccount = fromAccount;
		this.destAccount = destAccount;
		this.transDescription = transDescription;	
		this.setProvider(provider);
		this.setDateToPay(dateToPay);
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
	public Integer getDateToPay() {
		return dateToPay;
	}
	public void setDateToPay(Integer dateToPay) {
		this.dateToPay = dateToPay;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
}
