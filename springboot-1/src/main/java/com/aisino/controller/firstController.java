package com.aisino.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class firstController {

	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		return "hello zks";
	}
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
}
