package com.aisino.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aisino.vo.User;

@Controller
public class CommonController {

	@RequestMapping("/template")
	public String template(Map<String , Object> map){
		User user1 = new User("1001", "zks", 25, new Date());
		User user2 = new User("1002", "sjx", 22, new Date());
		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		map.put("users", users);
		return "template";
	}
}
