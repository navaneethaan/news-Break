package com.example.news.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.example.news.common.metaResponse;
import com.example.news.dao.CountiesDao;
import com.example.news.dao.StateDao;
import com.example.news.dto.CountiesDto;
import com.example.news.dto.StateDetailDto;
import com.example.news.dto.citiesDetailDto;
import com.example.news.model.CitieDetail;
import com.example.news.model.CountiesDetail;
import com.example.news.model.StatesDetails;

@Component
public class CountiesProcessor {
	@Autowired
	CountiesDao ctdao;
	@Autowired
	metaResponse metaresponse;	
	//FindAllPage
	public List<CountiesDto> getAllProcessorPage(int page){
		List<CountiesDto> cdto= new ArrayList<>();
		PageRequest pg=PageRequest.of(page -1, 10);
		Page<CountiesDetail> cd=(Page<CountiesDetail>) ctdao.findAll(pg);
		metaresponse.meta1(cd);
		List<CountiesDetail>countiesList=cd.getContent();
		for (CountiesDetail countdetail :countiesList) {
			CountiesDto countDto = new CountiesDto(countdetail);
			cdto.add(countDto);
		}
		return cdto;
				
		
	}

	//findall
	public List<CountiesDto> getAllProcessor() throws Exception{
		try {
			List<CountiesDto> cdto=new ArrayList<>();
			List<CountiesDetail> cd=ctdao.findAll();
			for (CountiesDetail countiesDetail : cd) {
				CountiesDto dto=new CountiesDto(countiesDetail);
				cdto.add(dto);
			}
			return cdto;
		} catch (Exception e) {
			throw new Exception(e.getMessage()); 
		}
	}
public CountiesDto addProcessor(CountiesDto dto ) {
	
	CountiesDto sdto = new CountiesDto();
	CountiesDetail std=sdto.isCountiesDetail(dto);
	return new CountiesDto (ctdao.save(std));
}
public CountiesDto getProcessor(int id) {
	CountiesDetail statedetail=ctdao.findById(id);
	CountiesDto sddto=new CountiesDto(statedetail);
	
	return sddto;
	
}
public CountiesDto updateProcessor(CountiesDto sdto) throws Exception {
	CountiesDto dto=new CountiesDto();
	CountiesDetail sd= dto.isCountiesDetail(sdto);
	CountiesDetail sdt=ctdao.findById(sdto.getId());
	if(sdt.equals(null)) {
		throw new Exception("In this id not present..");
	}
	ctdao.save(sd);
	return new CountiesDto(sd);

}
public CountiesDto deletedprocessor(int id) {
	CountiesDetail sd=ctdao.findById(id);
	ctdao.delete(sd);
	return null;
}
}