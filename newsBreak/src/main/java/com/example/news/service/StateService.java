package com.example.news.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.news.dto.StateDetailDto;
import com.example.news.processor.StateProcessor;
@Service
public class StateService {

	@Autowired
	StateProcessor stprocess;
	public List<StateDetailDto> getAllServicePage(int page){
		List<StateDetailDto> stsdto=stprocess.getallprocessorPage(page);
		return  stsdto;
	}
	
	public List<StateDetailDto> getAllService() throws Exception {
		
		List<StateDetailDto> stsdto= stprocess.getAllprocessor();
		return stsdto;
		
	}
	
	//save
	public StateDetailDto addService(StateDetailDto stservice) {
		
		StateDetailDto stsdto= stprocess.addProcessor(stservice);
		return stsdto;
		
	}
	//find
	public StateDetailDto findService(int id) {
		
		StateDetailDto stdto=stprocess.getProcessor(id);
		return stdto;
	}
	//update
	public StateDetailDto updateService(StateDetailDto sdto) throws Exception {
		
		StateDetailDto stdto=stprocess.updateProcessor(sdto);
		return stdto;
	}
	public StateDetailDto deleteService(int id) {
		StateDetailDto stdto=stprocess.deletedprocessor(id);
		return stdto;
		
		
	}

	
}
