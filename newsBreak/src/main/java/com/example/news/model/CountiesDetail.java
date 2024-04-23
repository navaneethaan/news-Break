package com.example.news.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class CountiesDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public String countiesName;
	public int stateId;
	public int zipCode;


	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
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

}
