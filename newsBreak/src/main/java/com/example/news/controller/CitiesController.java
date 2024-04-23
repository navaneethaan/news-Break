package com.example.news.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.news.dto.citiesDetailDto;
import com.example.news.response.NewsBreakResponse;
import com.example.news.response.ResponseTemplate;
//import com.example.news.response.apiresponsetemplate;
import com.example.news.service.CitiesService;
@RestController
public class CitiesController {
	@Autowired
	CitiesService ctservice;
	@Autowired
	ResponseTemplate  countieresponsetemplate;

	@GetMapping(value="/getAllCitiesPage")
	public ResponseEntity<NewsBreakResponse>findAllPage(@RequestParam int page){
		try {
			List<citiesDetailDto> cdto=ctservice.findall(page);
			return countieresponsetemplate.ResponseSuccess(cdto, 200, true);
		} catch (Exception e) {
			return countieresponsetemplate.ResponseFailure(null, 400, false, e.getMessage()); 
		}

	}
	@GetMapping(value="/getAllCities")
	public ResponseEntity<NewsBreakResponse> findAll(){
		try {
			List<citiesDetailDto> cdto=ctservice.findall();
			return countieresponsetemplate.ResponseSuccess(cdto, 200, true);
		} catch (Exception e) {
			return countieresponsetemplate.ResponseFailure(null, 400, false,e.getMessage());
		}
	}
	@PostMapping(value= "/addedCities" )
	public ResponseEntity<NewsBreakResponse> added(@RequestBody citiesDetailDto sdto) {
		try {			
			citiesDetailDto dto=ctservice.addService(sdto);
			return countieresponsetemplate.ResponseSuccess(dto, 200, true);
		} catch (Exception e) {
			return	countieresponsetemplate.ResponseFailure(null, 404, false,e.getMessage());
		}
	}
	@GetMapping(value="/findCities")
	public ResponseEntity<NewsBreakResponse>find(@RequestParam int id){

		try {
			citiesDetailDto dto=ctservice.findService(id);
			return countieresponsetemplate.ResponseSuccess(dto, 200, true);
		} catch (Exception e) {
			return countieresponsetemplate.ResponseFailure(null, 400, false,e.getMessage());
		}
	}
	@PostMapping(value="/updateCities")
	public ResponseEntity<NewsBreakResponse>update(@RequestBody citiesDetailDto sdto) {
		try {	
			citiesDetailDto dto = ctservice.updateService(sdto);
			return countieresponsetemplate.ResponseSuccess(dto, 200, true);
		} catch (Exception e) {
			return countieresponsetemplate.ResponseFailure(null, 400, false,e.getMessage());	
		}	
	}
	@GetMapping(value="/deletedCities")
	public ResponseEntity<NewsBreakResponse>delete(@RequestParam int id){
		try {
			citiesDetailDto dto=ctservice.deleteService(id);

			return countieresponsetemplate.ResponseSuccess(dto, 200, true);
		} catch (Exception e) {
			return countieresponsetemplate.ResponseFailure(null, 400, false, e.getMessage());
		}
	}
}