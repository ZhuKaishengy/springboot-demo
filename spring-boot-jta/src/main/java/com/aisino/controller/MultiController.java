package com.aisino.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aisino.db1.domain.UserTest;
import com.aisino.db1.service.UserService;
import com.aisino.db2.domain.JpTest;
import com.aisino.db2.service.JpTestService;
import com.aisino.readFile.ReadFile1;
import com.aisino.readFile.ReadFile2;
import com.aisino.to.Msg;

@RestController
public class MultiController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private JpTestService jpTestService;
	
	@Autowired
	private ReadFile1 readFile1;
	@Autowired
	private ReadFile2 readFile2;
	
//	@Value("${log4j.appender.CONSOLE}")
//	private String console;
	
//	@Value("${name}")
//	private String config;
	
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
	
	@RequestMapping("/log")
	public Msg testLog(@RequestParam(value="id",required=false) String id){
		if("1001".equals(id)){
			throw new RuntimeException();
		}
		return Msg.success().add("name", "zks").add("age",15);
	}
	
	@RequestMapping("/cache")
	public Msg testCache(){
		List<UserTest> users = userService.getUsers();
		return Msg.success().add("users", users);
	}
	
	@RequestMapping("/clearCache")
	public Msg clearCache(){
		userService.clearCache();
		
		return Msg.success();
	}
	
	/**
	 * @Description: 测试多线程,异步
	 * @author zhukaisheng
	 * @date 2017年11月15日
	 */
	@RequestMapping("/asychro")
	public Msg testAsychro(){
		System.out.println("part 1");
		userService.bigMethod();
		System.out.println("part 2");
		return Msg.success();
	}
	
	@RequestMapping("/read1")
	public Msg read1(){
		String url = readFile1.getUrl();
		String password = readFile1.getPassword();
		String username = readFile1.getUsername();
		System.out.println(username+"..."+password+"..."+url);
		return Msg.success().add("obj", readFile1);
	}
	
	@RequestMapping("/read2")
	public Msg read2(){
		String url = readFile2.getUrl();
		String password = readFile2.getPassword();
		String username = readFile2.getUsername();
		System.out.println(username+"..."+password+"..."+url);
		return Msg.success().add("obj", readFile2);
	}
	
//	@RequestMapping("/read3")
//	public Msg read3(){
//		return Msg.success().add("config", config);
//	}
}
