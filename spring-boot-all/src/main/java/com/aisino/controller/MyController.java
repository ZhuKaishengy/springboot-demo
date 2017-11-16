package com.aisino.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aisino.to.Msg;

@RestController
public class MyController {

	@RequestMapping("/hello")
	public Msg hello(){
		
		return Msg.success();
	}
}
