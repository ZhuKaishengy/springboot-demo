package com.aisino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aisino.dao.UserMapper;
import com.aisino.domain.User;
import com.aisino.domain.UserExample;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public List<User> getUsers(String username){
		UserExample example;
		if(username == null){
			example = null;
		}else{
			example = new UserExample();
			example.createCriteria().andUsernameEqualTo(username);
		}
		return userMapper.selectByExample(example);
	}
	
	/**
	 * @Description: 测试spring-boot注解
	 * @author zhukaisheng
	 * @date 2017年11月14日
	 */
	@Transactional
	public String insertUser(User user){
		userMapper.insertSelective(user);
		int e = 1/0;
		return "success";
	}
}
