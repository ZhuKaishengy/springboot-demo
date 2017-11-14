package com.aisino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.dao.UserDao;
import com.aisino.domain.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public List<User> getUsers(){
		return userDao.getUsers();
	}
}
