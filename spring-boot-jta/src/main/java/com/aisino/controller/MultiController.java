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
	
	/**
	 * @Description: 这个一种不正规的写法，事务应该加在service层
	 * @author zhukaisheng
	 * @date 2017年11月15日
	 */
	@RequestMapping("/add")
	@Transactional
	public Msg add(){
		userService.addUser();
		System.out.println(1/0);
		jpTestService.addTest();
		return Msg.success();
	}
	
	/**
	 * @Description: 测试分布式访问
	 * @author zhukaisheng
	 * @date 2017年11月15日
	 */
	@RequestMapping("/assoiation")
	public Msg addNew(){
		userService.assoiation();
		return Msg.success();
	}
	
	/**
	 * @Description: 测试分布式事务，优先访问自己的数据源
	 * @author zhukaisheng
	 * @date 2017年11月15日
	 */
	@RequestMapping("/assoiation1")
	public Msg addNew1(){
		userService.assoiation1();
		return Msg.success();
	}
	/**
	 * @Description: 测试分布式事务，优先访问其他的数据源
	 * @author zhukaisheng
	 * @date 2017年11月15日
	 */
	@RequestMapping("/assoiation2")
	public Msg addNew2(){
		userService.assoiation2();
		return Msg.success();
	}
	
	
}
