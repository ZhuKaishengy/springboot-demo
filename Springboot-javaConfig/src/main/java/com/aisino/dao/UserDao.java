package com.aisino.dao;

import java.util.ArrayList;
import java.util.List;

import com.aisino.domain.User;

public class UserDao {
/*
	@Autowired
	private User user;
	*/
	public List<User> getUsers(){
		ArrayList<User> users = new ArrayList<User>();
		users.add(new User("zks", "123"));
		users.add(new User("sjx", "456"));
		return users;
	}
}
