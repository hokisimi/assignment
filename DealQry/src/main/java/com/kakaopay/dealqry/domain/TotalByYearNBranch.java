package com.kakaopay.dealqry.domain;

import java.math.BigDecimal;

public class TotalByYearNBranch {
	
	private int year;
	private String brName;
	private String brCode;
	private BigDecimal sumAmt;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getBrName() {
		return brName;
	}
	public void setBrName(String brName) {
		this.brName = brName;
	}
	public String getBrCode() {
		return brCode;
	}
	public void setBrCode(String brCode) {
		this.brCode = brCode;
	}
	public BigDecimal getSumAmt() {
		return sumAmt;
	}
	public void setSumAmt(BigDecimal sumAmt) {
		this.sumAmt = sumAmt;
	}
	
	
	
	
	
	

}
