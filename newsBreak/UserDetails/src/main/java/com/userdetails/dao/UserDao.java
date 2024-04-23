package com.userdetails.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userdetails.model.UserModal;

@Repository
public interface UserDao extends JpaRepository< UserModal, Integer> {

}
