package com.example.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.news.dto.StateDetailDto;

import com.example.news.response.NewsBreakResponse;
import com.example.news.response.ResponseTemplate;
//import com.example.news.response.apiresponsetemplate;
import com.example.news.service.StateService;
@RestController
public class Statecontroller {
	@Autowired
	StateService stservice;
	@Autowired
	ResponseTemplate  stateresponsetemplate;
	
	@GetMapping(value="/getAllStatePage")
	public ResponseEntity<NewsBreakResponse>getAllPage(@RequestParam int page){
	
		try {
			List<StateDetailDto> sdto=stservice.getAllServicePage(page);
			return stateresponsetemplate.ResponseSuccess(sdto, 200,true);
		} catch (Exception e) {
			return stateresponsetemplate.ResponseFailure(null, 400, false,e.getMessage());
		}
		
	}
	@GetMapping(value ="/getAllState")
	public ResponseEntity<NewsBreakResponse>getAll(){
		try {
			List<StateDetailDto> sdto=stservice.getAllService();
			return stateresponsetemplate.ResponseSuccess(sdto, 200, true);
		} catch (Exception e) {
			return stateresponsetemplate.ResponseFailure(null, 400, false,e.getMessage());
		}
	}
	@PostMapping(value= "/addedState" )
	public ResponseEntity<NewsBreakResponse> added(@RequestBody StateDetailDto sdto) {
		try {			
			StateDetailDto dto=stservice.addService(sdto);
			return stateresponsetemplate.ResponseSuccess(dto, 200, true);
		} catch (Exception e) {
			return	stateresponsetemplate.ResponseFailure(null, 404, false,e.getMessage());
		}
	}
	@GetMapping(value="/findState")
	public ResponseEntity<NewsBreakResponse>find(@RequestParam int id){

		try {
			StateDetailDto dto=stservice.findService(id);
			return stateresponsetemplate.ResponseSuccess(dto, 200, true);
		} catch (Exception e) {
			return stateresponsetemplate.ResponseFailure(null, 400, false,e.getMessage());
		}
	}
	@PostMapping(value="/updateState")
	public ResponseEntity<NewsBreakResponse>update(@RequestBody StateDetailDto sdto) {
		try {	
			StateDetailDto dto = stservice.updateService(sdto);
			return stateresponsetemplate.ResponseSuccess(dto, 200, true);
		} catch (Exception e) {
			return stateresponsetemplate.ResponseFailure(null, 400, false,e.getMessage());	
		}	
	}
	@GetMapping(value="/deletedState")
	public ResponseEntity<NewsBreakResponse>delete(@RequestParam int id){
		try {
			StateDetailDto dto=stservice.deleteService(id);

			return stateresponsetemplate.ResponseSuccess(dto, 200, true);
		} catch (Exception e) {
			return stateresponsetemplate.ResponseFailure(null, 400, false, e.getMessage());
		}
	}
}