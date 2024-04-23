package com.example.news.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.news.model.CitieDetail;
import com.example.news.model.CountiesDetail;

@Repository
public interface CitiesDao extends  JpaRepository <CitieDetail, Integer> {

	
	CitieDetail findById(int id);
}
