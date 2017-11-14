package com.aisino.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommenController {

	@RequestMapping("/index")
	public String index(Map<String, Object> map){
		map.put("name", "朱开生");
		return "index";
	}
}
