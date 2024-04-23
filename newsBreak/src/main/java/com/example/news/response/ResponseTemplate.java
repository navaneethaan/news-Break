package com.example.news.response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.example.news.common.metaResponse;
@ControllerAdvice
public class ResponseTemplate {
	@Autowired
	metaResponse metaData;
	public ResponseEntity<NewsBreakResponse> ResponseSuccess(Object user,int status,Boolean success) {
		NewsBreakResponse resp =new NewsBreakResponse();
		resp.setData(user);
		resp.setStatus(status);
		resp.setSuccess(success);
		resp.setSuccess(success);
		for (var meta : metaData.metaDataList) {
			resp.setMeta(meta);
		}
		metaData.metaDataList.clear();
	   
		return new ResponseEntity<>(resp,HttpStatus.OK);
		
	}
	
	public ResponseEntity<NewsBreakResponse> ResponseFailure(Object user,int status,Boolean success, String Message) {
		NewsBreakResponse res =new NewsBreakResponse();
		res.setData(user);
		res.setStatus(status);
		res.setSuccess(success);
		return new ResponseEntity<>(res,HttpStatus.OK);
		
	}

}
