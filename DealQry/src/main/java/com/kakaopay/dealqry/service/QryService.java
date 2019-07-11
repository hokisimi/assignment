package com.kakaopay.dealqry.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kakaopay.dealqry.domain.NoDealByYear;
import com.kakaopay.dealqry.domain.TotalByBranch;
import com.kakaopay.dealqry.domain.TotalByYear;
import com.kakaopay.dealqry.domain.TotalByYearNBranch;
import com.kakaopay.dealqry.dto.TotalByYearNBranchDto;
import com.kakaopay.dealqry.dto.TotalByYearNBranchSubDto;
import com.kakaopay.dealqry.mapper.QryMapper;

@Service
public class QryService {
	
	@Autowired
	QryMapper qryMapper;
	
	public List<TotalByYear> getTotalByYear(){
		return qryMapper.getTotalByYear();
	}
	
	public List<NoDealByYear> getNoDealByYear(){
		return qryMapper.getNoDealByYear();
	}
	
	public List<TotalByYearNBranchDto> getTotalByYearNBranch(){
		
		List<TotalByYearNBranchDto> datalist = new ArrayList<TotalByYearNBranchDto>();
		
		datalist.add(new TotalByYearNBranchDto(2018));
		datalist.add(new TotalByYearNBranchDto(2019));
		
		for(TotalByYearNBranch a:qryMapper.getTotalByYearNBranch())
		{
			if(a.getYear() == 2018)
			{
				
				TotalByYearNBranchSubDto totalByYearNBranchSubDto = new TotalByYearNBranchSubDto();
				totalByYearNBranchSubDto.setBrCode(a.getBrCode());
				totalByYearNBranchSubDto.setBrName(a.getBrName());
				totalByYearNBranchSubDto.setSumAmt(a.getSumAmt());
				
				datalist.get(0).getDataList().add(totalByYearNBranchSubDto);
			}
			else
			{
				TotalByYearNBranchSubDto totalByYearNBranchSubDto = new TotalByYearNBranchSubDto();
				totalByYearNBranchSubDto.setBrCode(a.getBrCode());
				totalByYearNBranchSubDto.setBrName(a.getBrName());
				totalByYearNBranchSubDto.setSumAmt(a.getSumAmt());
				
				datalist.get(1).getDataList().add(totalByYearNBranchSubDto);
			}
	
		}
		return datalist;
	}
	
	public Optional<TotalByBranch> getTotalByBranch(String brName){
		return qryMapper.getTotalByBranch(brName);
	}

}
