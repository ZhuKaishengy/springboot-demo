package com.aisino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aisino.domain.User;
import com.aisino.service.UserService;

@RestController
public class UserHandler {

	@Autowired
	private UserService service;
	
	@RequestMapping("/users")
	public List<User> getUsers(@RequestParam(value="userId" ,required=false) String userId){
		return service.getUsers(userId);
	}
}
