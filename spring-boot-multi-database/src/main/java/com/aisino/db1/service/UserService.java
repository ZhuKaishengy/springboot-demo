package com.aisino.db1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.db1.dao.UserTestMapper;
import com.aisino.db1.domain.UserTest;

@Service
public class UserService {

	@Autowired
	private UserTestMapper userTestMapper;
	
	
	public List<UserTest> getUsers(){
		return userTestMapper.selectByExample(null);
	}
	
	public void addUser(){
		UserTest record = new UserTest("zks", "1001", "zks");
		userTestMapper.insertSelective(record );
	}
}
