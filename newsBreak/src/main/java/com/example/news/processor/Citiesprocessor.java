package com.example.news.processor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.example.news.common.metaResponse;
import com.example.news.dao.CitiesDao;
import com.example.news.dto.citiesDetailDto;
import com.example.news.model.CitieDetail;

@Component
public class Citiesprocessor {
	@Autowired
	CitiesDao ctdao;
	@Autowired
	metaResponse metaresponse;
	//findAllpage
	public List <citiesDetailDto> getAllProcessorPage(int page){
		List<citiesDetailDto> cdto=new ArrayList<>();
		PageRequest preq=PageRequest.of(page -1, 10);
		Page<CitieDetail> cd=(Page<CitieDetail>)ctdao.findAll(preq); 
		metaresponse.meta1(cd);
		List<CitieDetail> cdl=cd.getContent();
		for (CitieDetail citieDetail : cdl) {
			citiesDetailDto dto=new citiesDetailDto(citieDetail);
			cdto.add(dto);
		}
		return cdto;
		
	}
	//findAll
	public List<citiesDetailDto> getAllProceesor() throws Exception{
		try {
			List<citiesDetailDto> cdto=new ArrayList<>();
			List<CitieDetail> cd=ctdao.findAll();
			for (CitieDetail citieDetail : cd) {
				citiesDetailDto dto=new citiesDetailDto(citieDetail);
				cdto.add(dto);
			}
			return cdto;
		} catch (Exception e) {
			
			throw new Exception(e.getMessage());
		}
	}
	
	
	//add
	public citiesDetailDto addProcessor(citiesDetailDto dto ) {

		citiesDetailDto cdto = new citiesDetailDto();
		CitieDetail ctd=cdto.isCitieDetails(dto);
		ctdao.save(ctd);
		return new citiesDetailDto(ctd);
		
//		return new citiesDetailDto (ctdao.save(ctd));

	}
	//find
	public citiesDetailDto getProcessor(int id) {
		CitieDetail statedetail=ctdao.findById(id);
		citiesDetailDto sddto=new citiesDetailDto(statedetail);
		return sddto;

	}
	public citiesDetailDto updateProcessor(citiesDetailDto cdto) throws Exception {
		citiesDetailDto dto=new citiesDetailDto();
		CitieDetail cd= dto.isCitieDetails(cdto);
		CitieDetail cdt=ctdao.findById(cdto.getId());
		if(cdt.equals(null)) {
			throw new Exception("In this id not present..");
		}
		ctdao.save(cd);
		return new citiesDetailDto(cd);
	}
	public citiesDetailDto deletedprocessor(int id) {
		CitieDetail cd=ctdao.findById(id);
		ctdao.delete(cd);
		return null;
	}	
}