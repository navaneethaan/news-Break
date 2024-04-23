package com.example.news.dto;

import com.example.news.model.StatesDetails;

public class StateDetailDto {
	
	public int id;
	public String stateName;
	public int zipCode;
	public String profile;
	
	public StateDetailDto(StatesDetails statedetail) {
		this.id = statedetail.getId();
		this.stateName = statedetail.getStateName();
		this.zipCode = statedetail.getZipCode();
		this.profile = statedetail.getProfile();
	}

	public StateDetailDto() {
		
	}
	public StatesDetails isStateDetails(StateDetailDto statedetildto) {
		StatesDetails statedetails= new StatesDetails();
		statedetails.setId(statedetildto.getId());
		statedetails.setStateName(statedetildto.getStateName());
		statedetails.setZipCode(statedetildto.getZipCode());
		statedetails.setProfile(statedetildto.getProfile());
		return statedetails;
		
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	
	
}
