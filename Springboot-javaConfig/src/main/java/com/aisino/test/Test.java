package com.aisino.test;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.aisino.domain.User;
import com.aisino.service.UserService;
import com.aisino.spring.config.SpringConfig;

public class Test {
	
	private static final AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(SpringConfig.class);

	@org.junit.Test
	public void mapperTest1(){
		System.out.println(context);
	}
	
	@org.junit.Test
	public void mapperTest2(){
		UserService service = context.getBean(UserService.class);
		List<User> users = service.getUsers();
		for (User user : users) {
			System.out.println(user.getUsername()+"---"+user.getPassword());
		}
		context.destroy();
	}
	
	@org.junit.Test
	public void mapperTest3(){
		DataSource bean = context.getBean(DataSource.class);
		System.out.println(bean.getClass());
	}
}
