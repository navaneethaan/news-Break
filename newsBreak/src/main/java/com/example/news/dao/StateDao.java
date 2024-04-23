package com.example.news.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.news.dto.StateDetailDto;
import com.example.news.model.CountiesDetail;
import com.example.news.model.StatesDetails;
@Repository
public interface StateDao extends JpaRepository<StatesDetails, Integer> {

	StatesDetails findById(int id);

	
}
