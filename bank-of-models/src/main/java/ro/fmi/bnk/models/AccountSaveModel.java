package ro.fmi.bnk.models;

import java.math.BigDecimal;

public class AccountSaveModel {

	
	public String accNo;
	public BigDecimal limit;
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
