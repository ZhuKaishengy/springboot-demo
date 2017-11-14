package com.aisino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.dao.UserDao;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public int insertUser(String username ,String password){
		return userDao.insertUser(username, password);
	}
	
}
