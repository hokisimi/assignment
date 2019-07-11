package com.kakaopay.dealqry.dto;

import java.math.BigDecimal;

public class TotalByYearNBranchSubDto {
	
	private String brName;
	private String brCode;
	private BigDecimal sumAmt;
	
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
