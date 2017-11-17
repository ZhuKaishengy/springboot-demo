package com.aisino.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aisino.domain.UserJPA;

public interface UserTestDaoJpa extends JpaRepository<UserJPA, String>{
//	@Query("select * from USER_TEST where USERID = ?0")
//	public UserJPA findById(String id);
}
