package com.example.news.response;

import org.springframework.http.HttpStatus;


public class NewsBreakResponse {
	
	public Object meta,data;
	public int status;
	public boolean success;
	public String message;

	public NewsBreakResponse() {
		super();
		this.data=data;
		this.status=HttpStatus.OK.value();
		this.success=true;	}
	
	public Object getMeta() {
		return meta;
	}
	public void setMeta(Object meta) {
		this.meta = meta;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}



}
