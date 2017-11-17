package com.aisino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisino.dao.UserTestDao;
import com.aisino.domain.UserJPA;
import com.aisino.service.UserTestService;
import com.aisino.to.Msg;

@RestController
public class MyController {

	@RequestMapping("/hello")
	public Msg hello(){
		
		return Msg.success();
	}
	
	@RequestMapping("/ex")
	public Msg testExceptionHandler(){
		System.out.println(1/0);
		return Msg.success();
	}
	
	/**
	 * 一个简易的例子，不写service层了，直接注入dao
	 */
	@Autowired
	private UserTestDao userTestDao;
	
	@RequestMapping("/insertUser")
	public Msg insertUser(){
		userTestDao.insertUser("zks", "zks");
		return Msg.success();
	}
	
	@Autowired
	private UserTestService userTestService;
	
	@RequestMapping("/findUserById")
	public Msg findUserById(){
		List<UserJPA> list = userTestService.getById("1");
		return Msg.success().add("users", list);
	}

}
