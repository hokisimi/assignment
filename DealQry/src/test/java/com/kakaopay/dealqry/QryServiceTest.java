package com.kakaopay.dealqry;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.kakaopay.dealqry.domain.NoDealByYear;
import com.kakaopay.dealqry.domain.TotalByBranch;
import com.kakaopay.dealqry.domain.TotalByYear;
import com.kakaopay.dealqry.domain.TotalByYearNBranch;
import com.kakaopay.dealqry.dto.TotalByYearNBranchDto;
import com.kakaopay.dealqry.mapper.QryMapper;
import com.kakaopay.dealqry.service.QryService;

import static org.mockito.Matchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.atLeast;

@RunWith(MockitoJUnitRunner.class)
public class QryServiceTest {
	
	@InjectMocks
    private QryService qryService;
    
    @Mock
    private QryMapper qryMapper;

	@Test
	public void getTotalByYear() {
		
		List<TotalByYear> list = new ArrayList<TotalByYear>();
		TotalByYear result = new TotalByYear();
		result.setYear(2019);
		result.setName("Song");
		result.setSumAmt(new BigDecimal(2000));
		result.setAcctNo("11111111");
		list.add(result);

	    given(qryMapper.getTotalByYear()).willReturn(list);

	    //when
	    List<TotalByYear> results = qryService.getTotalByYear();

	    //then 
	    Mockito.verify(qryMapper, atLeast(1)).getTotalByYear();
	    
	    Assert.assertThat(list.get(0).getAcctNo(), is(results.get(0).getAcctNo()));

	}
	
	@Test
	public void getNoDealByYear() {
		
		List<NoDealByYear> list = new ArrayList<NoDealByYear>();
		NoDealByYear result = new NoDealByYear();
		result.setAcctNo("11111111");
		list.add(result);

	    given(qryMapper.getNoDealByYear()).willReturn(list);

	    //when
	    List<NoDealByYear> results = qryService.getNoDealByYear();

	    //then 
	    Mockito.verify(qryMapper, atLeast(1)).getNoDealByYear();
	    
	    Assert.assertThat(list.get(0).getAcctNo(), is(results.get(0).getAcctNo()));

	}
	
	@Test
	public void getTotalByYearNBranch() {
		
		List<TotalByYearNBranch> list = new ArrayList<TotalByYearNBranch>();
		
		TotalByYearNBranch data = new TotalByYearNBranch();
		data.setYear(2018);
		data.setBrCode("A");
		data.setSumAmt(new BigDecimal(400));
		data.setBrName("분당점");
		list.add(data);
		
	    given(qryMapper.getTotalByYearNBranch()).willReturn(list);

	    //when
	    List<TotalByYearNBranchDto> results = qryService.getTotalByYearNBranch();

	    //then 
	    Mockito.verify(qryMapper, atLeast(1)).getTotalByYearNBranch();
	    
	    Assert.assertThat(list.get(0).getYear(), is(results.get(0).getYear()));

	}
	
	@Test
	public void getTotalByBranch() {
		
		TotalByBranch data = new TotalByBranch();
		
		data.setBrCode("B");
		data.setBrName("판교점");
		data.setSumAmt(new BigDecimal(3000));
		
		Optional<TotalByBranch> optData =  Optional.of(data);

	    given(qryMapper.getTotalByBranch(any(String.class))).willReturn(optData);

	    //when
	    Optional<TotalByBranch> result = qryService.getTotalByBranch("판교점");

	    //then 
	    Mockito.verify(qryMapper, atLeast(1)).getTotalByBranch(any(String.class));
	    
	    Assert.assertThat(optData.get().getBrCode(), is(result.get().getBrCode()));

	}
}
