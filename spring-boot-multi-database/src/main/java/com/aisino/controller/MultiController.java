package com.aisino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisino.db1.domain.UserTest;
import com.aisino.db1.service.UserService;
import com.aisino.db2.domain.JpTest;
import com.aisino.db2.service.JpTestService;
import com.aisino.to.Msg;

@RestController
public class MultiController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private JpTestService jpTestService;
	
	
	@RequestMapping("/index")
	public Msg index(){
		List<UserTest> users = userService.getUsers();
		List<JpTest> tests = jpTestService.getTests();
		return Msg.success().add("userList", users).add("testList", tests);
	}
	
	@RequestMapping("/add")
	@Transactional
	public Msg add(){
		userService.addUser();
		System.out.println(1/0);
		jpTestService.addTest();
		return Msg.success();
	}
	
	
}
