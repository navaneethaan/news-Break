package com.example.news.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.news.controller.CountiesController;

import com.example.news.dto.CountiesDto;
import com.example.news.processor.CountiesProcessor;
import com.example.news.processor.StateProcessor;
@Service
public class CountiesService {

	@Autowired
	CountiesProcessor ctprocess;

	//FindAllPage
	public List<CountiesDto> findallServicePage(int page){
		List<CountiesDto> cdto=ctprocess.getAllProcessorPage(page);
		return cdto;
	}	
	
	//Findall
	public List<CountiesDto> findallService() throws Exception {
		List<CountiesDto> cdto=ctprocess.getAllProcessor();
		return cdto;
	}
	
	//save
	public CountiesDto addService(CountiesDto stservice) {
		
		CountiesDto stsdto= ctprocess.addProcessor(stservice);
		return stsdto;
		
	}
	//find
	public CountiesDto findService(int id) {
		
		CountiesDto stdto=ctprocess.getProcessor(id);
		return stdto;
	}
	//update
	public CountiesDto updateService(CountiesDto sdto) throws Exception {
		
		CountiesDto stdto=ctprocess.updateProcessor(sdto);
		return stdto;
	}
	public CountiesDto deleteService(int id) {
		CountiesDto stdto=ctprocess.deletedprocessor(id);
		return stdto;
		
		
	}

}
