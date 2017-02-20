package ro.fmi.bnk.models;

import java.math.BigDecimal;

public class InOutComeModel {

	private BigDecimal income;
	private BigDecimal outcome;
	
	public InOutComeModel(BigDecimal income, BigDecimal outcome) {
		super();
		this.income = income;
		this.outcome = outcome;
	}
	public BigDecimal getIncome() {
		return income;
	}
	public void setIncome(BigDecimal income) {
		this.income = income;
	}
	public BigDecimal getOutcome() {
		return outcome;
	}
	public void setOutcome(BigDecimal outcome) {
		this.outcome = outcome;
	}
	
	
}
