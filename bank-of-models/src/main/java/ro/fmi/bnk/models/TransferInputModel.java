package ro.fmi.bnk.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TransferInputModel {

	@XmlElement(name = "amount")
	private BigDecimal amount;
	@XmlElement(name = "fromAccount")
	private String fromAccount;
	@XmlElement(name = "destAccount")
	private String destAccount;
	@XmlElement(name = "transDescription")
	private String transDescription;
	@XmlTransient
	private String provider;
	@XmlTransient
	private Date dateToPay;
	public TransferInputModel() {
		super();
		}
	public TransferInputModel(BigDecimal amount, String fromAccount, String destAccount, String transDescription, String provider, Date dateToPay) {
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
	public Date getDateToPay() {
		return dateToPay;
	}
	public void setDateToPay(Date dateToPay) {
		this.dateToPay = dateToPay;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	
}
