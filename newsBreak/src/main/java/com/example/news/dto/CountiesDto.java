
package com.example.news.dto;

import com.example.news.model.CountiesDetail;

public class CountiesDto {
	public int id;
	public String countiesName;
	public int stateId;
	public int zipCode;

	public CountiesDto(CountiesDetail countiesdetail) {
		this.id=countiesdetail.getId();
		this.countiesName=countiesdetail.getCountiesName();
		this.stateId=countiesdetail.getStateId();
		this.zipCode=countiesdetail.getZipCode();
	}
	public CountiesDto() {

	}
	public CountiesDetail isCountiesDetail(CountiesDto countiesdto) {
		CountiesDetail ctydetail=new CountiesDetail();
		ctydetail.setId(countiesdto.getId());
		ctydetail.setCountiesName(countiesdto.getCountiesName());
		ctydetail.setStateId(countiesdto.getStateId());
		ctydetail.setZipCode(countiesdto.getZipCode());
		return ctydetail;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountiesName() {
		return countiesName;
	}
	public void setCountiesName(String countiesName) {
		this.countiesName = countiesName;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
}
