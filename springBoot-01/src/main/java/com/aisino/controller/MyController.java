package com.aisino.controller;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: MyController 
 * @Description: 
 * 	注意：	1.@RestController相当于@responseBody 此controller都返回json；
 * 			2.@EnableAutoConfiguration标注此类自动装配配置文件
 * 			3.项目访问时的路径不需要项目名如：http://localhost:8080/hello
 * @author zhukaishengy
 * @date 2017年11月1日
 */
@RestController
//@EnableAutoConfiguration
public class MyController {

	@RequestMapping("/hello")
	public String hello(){
		return "helloworld";
	}
	
	/*public static void main(String[] args) {
		SpringApplication.run(MyController.class, args);
	}*/
	
	//controllerAdvice
	@RequestMapping("/ex")
	public String ex(){
		int i = 1/0;
		return "ex";
	}
	
	
}
