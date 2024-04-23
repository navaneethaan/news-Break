package com.example.news.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.news.model.CountiesDetail;

@Repository
public interface CountiesDao extends JpaRepository<CountiesDetail, Integer>  {

	CountiesDetail findById(int id);

	

}
