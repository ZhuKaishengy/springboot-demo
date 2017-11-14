package com.aisino.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisino.service.UserService;

@RestController
public class UserHandler {

	@Autowired
	private UserService service;
	
	@RequestMapping("/user")
	public String postUser(){
		int insertUser = service.insertUser("test", "test");
		return String.valueOf(insertUser);
	}
}
