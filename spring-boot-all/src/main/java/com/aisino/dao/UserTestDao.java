package com.aisino.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserTestDao {

	/**
	 * 配置好，spring-boot自动装配
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insertUser(String username,String password){
		int update = jdbcTemplate.update("insert into USER_TEST VALUES (?,?,?)", username,"2",password);
		return update;
	}
}
