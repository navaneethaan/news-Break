package com.example.news.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.news.dto.CountiesDto;
import com.example.news.response.NewsBreakResponse;
import com.example.news.response.ResponseTemplate;
import com.example.news.service.CountiesService;

@RestController
public class CountiesController {
	@Autowired
	CountiesService ctservice;
	@Autowired
	ResponseTemplate  countiesresponsetemplate;
	
	@GetMapping(value="/getAllCountiesPage")
	public ResponseEntity<NewsBreakResponse> findAllPage(int page){
		
		try {
			List<CountiesDto> cc=ctservice.findallServicePage(page);
			return countiesresponsetemplate.ResponseSuccess(cc, 200, true);
		} catch (Exception e) {
			return countiesresponsetemplate.ResponseFailure(null, 400, false, e.getMessage());
		}
	}
	
	@GetMapping(value="/getAllCounties")
	public ResponseEntity<NewsBreakResponse> findAll() throws Exception{
		
		try {
			List<CountiesDto> cc=ctservice.findallService();
			return countiesresponsetemplate.ResponseSuccess(cc, 200, true);
		} catch (Exception e) {
			return countiesresponsetemplate.ResponseFailure(null,400,false,e.getMessage());
		}
		
	}
	@PostMapping(value= "/addedCounties" )
	public ResponseEntity<NewsBreakResponse> added(@RequestBody CountiesDto sdto) {
		try {			
			CountiesDto dto=ctservice.addService(sdto);
			return countiesresponsetemplate.ResponseSuccess(dto, 200, true);
		} catch (Exception e) {
			return	countiesresponsetemplate.ResponseFailure(null, 400, false,e.getMessage());
		}
	}
	@GetMapping(value="/findCounties")
	public ResponseEntity<NewsBreakResponse>find(@RequestParam int id){

		try {
			CountiesDto dto=ctservice.findService(id);
			return countiesresponsetemplate.ResponseSuccess(dto, 200, true);
		} catch (Exception e) {
			return countiesresponsetemplate.ResponseFailure(null, 400, false,e.getMessage());
		}
	}
	@PostMapping(value="/updateCounties")
	public ResponseEntity<NewsBreakResponse>update(@RequestBody CountiesDto sdto) {
		try {	
			CountiesDto dto = ctservice.updateService(sdto);
			return countiesresponsetemplate.ResponseSuccess(dto, 200, true);
		} catch (Exception e) {
			return countiesresponsetemplate.ResponseFailure(null, 400, false,e.getMessage());	
		}	
	}
	@GetMapping(value="/deletedCounties")
	public ResponseEntity<NewsBreakResponse>delete(@RequestParam int id){
		try {
			CountiesDto dto=ctservice.deleteService(id);

			return countiesresponsetemplate.ResponseSuccess(dto, 200, true);
		} catch (Exception e) {
			return countiesresponsetemplate.ResponseFailure(null, 400, false, e.getMessage());
		}
	}
}
