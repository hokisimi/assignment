package com.kakaopay.dealqry.dto;

import java.util.ArrayList;
import java.util.List;

public class TotalByYearNBranchDto {
	
	private int year;
	private List<TotalByYearNBranchSubDto> dataList;
	
	public TotalByYearNBranchDto(int year) {
		super();
		this.year = year;
		dataList =new ArrayList<TotalByYearNBranchSubDto>();
	}
	
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public List<TotalByYearNBranchSubDto> getDataList() {
		return dataList;
	}
	public void setDataList(List<TotalByYearNBranchSubDto> dataList) {
		this.dataList = dataList;
	}
	
}
