package com.kakaopay.dealqry;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.kakaopay.dealqry.controller.QryController;
import com.kakaopay.dealqry.domain.NoDealByYear;
import com.kakaopay.dealqry.domain.TotalByBranch;
import com.kakaopay.dealqry.domain.TotalByYear;
import com.kakaopay.dealqry.dto.TotalByYearNBranchDto;
import com.kakaopay.dealqry.dto.TotalByYearNBranchSubDto;
import com.kakaopay.dealqry.service.QryService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class QryControllerTest {
	
	private MockMvc mockMvc;
	
	@InjectMocks
    private QryController qryController;
	
	@Mock
	private QryService qryService;
	
	@Before
    public void setUp() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(qryController)
                .build();
    }
	
	@Test 
	public void totalbyyear() throws Exception{
		
		List<TotalByYear> list = new ArrayList<TotalByYear>();
		TotalByYear result = new TotalByYear();
		result.setYear(2019);
		result.setName("Song");
		result.setSumAmt(new BigDecimal(2000));
		result.setAcctNo("11111111");
		list.add(result);

		given(this.qryService.getTotalByYear()).willReturn(list);
			
		mockMvc.perform(get("/totalbyyear"))
         .andExpect(status().isOk())
         .andExpect(content().json("[{\"year\":2019,\"name\":\"Song\",\"acctNo\":\"11111111\",\"sumAmt\":2000}]"))
         .andDo(print());
	}
	
	@Test 
	public void nodealbyyear() throws Exception{
		
		List<NoDealByYear> list = new ArrayList<NoDealByYear>();
		NoDealByYear result = new NoDealByYear();
		result.setAcctNo("11111111");
		list.add(result);

		given(this.qryService.getNoDealByYear()).willReturn(list);
			
		mockMvc.perform(get("/nodealbyyear"))
         .andExpect(status().isOk())
         .andExpect(content().json("[{'year':0, 'name':null, 'acctNo':'11111111'}]"))
         .andDo(print());
	}
	
	@Test 
	public void totalbyyearNbranch() throws Exception{
		
		List<TotalByYearNBranchDto> list = new ArrayList<TotalByYearNBranchDto>();
		TotalByYearNBranchDto result = new TotalByYearNBranchDto(2019);
		TotalByYearNBranchSubDto subResult = new TotalByYearNBranchSubDto(); 
		
		subResult.setBrCode("A");
		subResult.setBrName("Kakao");
		subResult.setSumAmt(new BigDecimal(2000));
		
		result.getDataList().add(subResult);
		list.add(result);

		given(this.qryService.getTotalByYearNBranch()).willReturn(list);
			
		mockMvc.perform(get("/totalbyyearNbranch"))
         .andExpect(status().isOk())
         .andExpect(content().json("[{\"year\":2019,\"dataList\":[{\"brName\":\"Kakao\",\"brCode\":\"A\",\"sumAmt\":2000}]}]"))
         .andDo(print());
	}
	
	@Test 
	public void totalByBranch() throws Exception{
		
		TotalByBranch data = new TotalByBranch();
		
		data.setBrCode("B");
		data.setBrName("Kakao");
		data.setSumAmt(new BigDecimal(3000));
		
		Optional<TotalByBranch> optData =  Optional.of(data);
		
		given(this.qryService.getTotalByBranch(any(String.class))).willReturn(optData);
			
		mockMvc.perform(post("/totalbybranch").param("brName", "판교점").contentType(MediaType.APPLICATION_JSON))
         .andExpect(status().isOk())
         .andExpect(content().json("{\"brName\":\"Kakao\",\"brCode\":\"B\",\"sumAmt\":3000}"))
         .andDo(print());
	}

}
