package com.kakaopay.dealqry.domain;

import java.math.BigDecimal;

public class TotalByYear {
	
	private int year;
	private String name; 
	private String acctNo;
	private BigDecimal sumAmt;
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	public BigDecimal getSumAmt() {
		return sumAmt;
	}
	public void setSumAmt(BigDecimal sumAmt) {
		
		this.sumAmt = sumAmt;
	}

	
	
	
	
	

}
