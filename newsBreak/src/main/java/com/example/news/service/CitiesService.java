package com.example.news.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.news.dto.citiesDetailDto;
import com.example.news.processor.Citiesprocessor;
import com.example.news.processor.StateProcessor;
@Service
public class CitiesService {
	@Autowired
	Citiesprocessor ctprocess;
	
	//findAllPage
	public List<citiesDetailDto>findall(int page){
		List<citiesDetailDto> cdto= ctprocess.getAllProcessorPage(page);
		return cdto;
	}
	//findAll
	public List<citiesDetailDto> findall() throws Exception{
		List<citiesDetailDto> cdto= ctprocess.getAllProceesor();
		return cdto;

	}	
	//save
	public citiesDetailDto addService(citiesDetailDto ctservice) {

		citiesDetailDto ctsdto= ctprocess.addProcessor(ctservice);
		return ctsdto;

	}
	//find
	public citiesDetailDto findService(int id) {

		citiesDetailDto citdto=ctprocess.getProcessor(id);
		return citdto;
	}
	//update
	public citiesDetailDto updateService(citiesDetailDto cdto) throws Exception {

		citiesDetailDto citdto=ctprocess.updateProcessor(cdto);
		return citdto;
	}
	//Delete
	public citiesDetailDto deleteService(int id) {
		citiesDetailDto citdto=ctprocess.deletedprocessor(id);
		return citdto;
	}
}
