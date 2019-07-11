package com.kakaopay.dealqry.mapper;


import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.kakaopay.dealqry.domain.NoDealByYear;
import com.kakaopay.dealqry.domain.TotalByBranch;
import com.kakaopay.dealqry.domain.TotalByYear;
import com.kakaopay.dealqry.domain.TotalByYearNBranch;

@Mapper
public interface QryMapper {
	
	List<TotalByYear> 			getTotalByYear();
	List<NoDealByYear> 			getNoDealByYear();
	List<TotalByYearNBranch> 	getTotalByYearNBranch();
	Optional<TotalByBranch>		getTotalByBranch(String brName);
}
