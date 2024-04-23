package com.userdetails.dto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class UserDto {
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private int mobilenumber;
	private String place;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(int mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

}
