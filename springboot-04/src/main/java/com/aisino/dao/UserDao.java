package com.aisino.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aisino.domain.User;

public interface UserDao extends JpaRepository<User, String>{
//	@Query("select * from USER_TEST where userId = ?1")
//	public List<User> findById(String id);
}
