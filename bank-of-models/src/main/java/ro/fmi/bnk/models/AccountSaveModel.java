package ro.fmi.bnk.models;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountSaveModel {

	@XmlElement(name = "accNo")
	public String accNo;
	@XmlElement(name = "limit")
	public BigDecimal limit;
	@XmlTransient
	public Boolean smsAlert;
	

	public AccountSaveModel() {
		super();
	}
	public AccountSaveModel(String accNo, BigDecimal limit, Boolean smsAlert) {
		super();
		this.accNo = accNo;
		this.limit = limit;
		this.smsAlert = smsAlert;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public BigDecimal getLimit() {
		return limit;
	}
	public void setLimit(BigDecimal limit) {
		this.limit = limit;
	}

	public Boolean getSmsAlert() {
		return smsAlert;
	}
	public void setSmsAlert(Boolean smsAlert) {
		this.smsAlert = smsAlert;
	}
}
