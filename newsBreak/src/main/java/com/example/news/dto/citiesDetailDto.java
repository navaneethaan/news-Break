package com.example.news.dto;

import com.example.news.model.CitieDetail;
import com.example.news.model.CountiesDetail;

public class citiesDetailDto {
	public int id;
	public String cityName;
	public int cityId;
	public int zipCode;

	public citiesDetailDto(CitieDetail citiedetail) {
		this.id=citiedetail.getId();
		this.cityName=citiedetail.getCityName();
		this.cityId=citiedetail.getCityId();
		this.zipCode=citiedetail.getZipCode();
	}
	public citiesDetailDto() {

	}
	public CitieDetail isCitieDetails(citiesDetailDto citydto) {
		CitieDetail citiedetail= new CitieDetail();
		citiedetail.setId(citydto.getId());
		citiedetail.setCityName(citydto.getCityName());
		citiedetail.setCityId(citydto.getCityId());
		citiedetail.setZipCode(citydto.getZipCode());
		return citiedetail;

	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

}
