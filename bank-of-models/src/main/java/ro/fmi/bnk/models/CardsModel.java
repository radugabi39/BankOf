package ro.fmi.bnk.models;

import java.util.Date;

public class CardsModel {

	private String holderName;
	private Date expiryDate;
	private String accountLinked;
	private String cardNo;
	private String cvc;
	private String status;
	private String type;
	
	public CardsModel() {
		super();
	}

	public CardsModel(String holderName, Date expiryDate, String accountLinked, String cardNo, String cvc, String status, String type) {
		super();
		this.holderName = holderName;
		this.expiryDate = expiryDate;
		this.accountLinked = accountLinked;
		this.cardNo = cardNo;
		this.cvc = cvc;
		this.status = status;
		this.type = type;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getAccountLinked() {
		return accountLinked;
	}

	public void setAccountLinked(String accountLinked) {
		this.accountLinked = accountLinked;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getCvc() {
		return cvc;
	}

	public void setCvc(String cvc) {
		this.cvc = cvc;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

}
