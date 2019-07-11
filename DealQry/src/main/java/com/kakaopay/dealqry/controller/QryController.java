package com.kakaopay.dealqry.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kakaopay.dealqry.domain.NoDealByYear;
import com.kakaopay.dealqry.domain.TotalByBranch;
import com.kakaopay.dealqry.domain.TotalByYear;
import com.kakaopay.dealqry.dto.TotalByYearNBranchDto;
import com.kakaopay.dealqry.exception.DealNotFoundException;
import com.kakaopay.dealqry.service.QryService;

@RestController
public class QryController {
	
	@Autowired
	QryService qryService;
	
	@GetMapping("/totalbyyear")
	public List<TotalByYear> getTotalByYear() {

		List<TotalByYear> lists = qryService.getTotalByYear();
		
	    return lists;
	}
	
	@GetMapping("/nodealbyyear")
	public List<NoDealByYear> getNoDealByYear() {
		
		List<NoDealByYear> lists = qryService.getNoDealByYear();
		
	    return lists;
	}
	
	@GetMapping("/totalbyyearNbranch")
	public List<TotalByYearNBranchDto> getTotalByYearNBranch() {
		
		List<TotalByYearNBranchDto> datalist = qryService.getTotalByYearNBranch();
		
		return datalist;
	}
	
	@PostMapping("/totalbybranch")
	public TotalByBranch getTotalByBranch(String brName) {
		
		TotalByBranch data = qryService.getTotalByBranch(brName).orElseThrow(() -> new DealNotFoundException());
		
	    return data;
	}

}
