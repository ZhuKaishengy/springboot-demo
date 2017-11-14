package com.aisino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisino.domain.User;
import com.aisino.service.UserService;

@RestController
public class UserHandler {

	@Autowired
	private UserService service;
	
	@RequestMapping(value="/users/{username}")
	public List<User> getUsers(@PathVariable(value="username") String username){
		return service.getUsers(username);
	}
	
	@RequestMapping("/useradd")
	public String insertUser(){
		User user = new User("zks", "1001", "zks");
		String str = service.insertUser(user );
		return str;
	}
}
