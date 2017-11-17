package com.aisino.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.aisino.db1.dao.UserTestMapper;
import com.aisino.db1.domain.UserTest;
import com.aisino.db2.dao.JpTestMapper;
import com.aisino.db2.domain.JpTest;

import app.Application;

@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MultiMapperTest {

	@Autowired
	private UserTestMapper userTestMapper;
	
	@Autowired
	private JpTestMapper jpTestMapper;
	
	
	@Test
	public void getUsers(){
		List<UserTest> list = userTestMapper.selectByExample(null);
		System.out.println(list);
	}
	
//	@Test
//	public void getJps(){
//		List<JpTest> list = jpTestMapper.selectByExample(null);
//		System.out.println(list);
//	}
	
//	@Test
//	public void testTransaction(){
//		List<UserTest> users = userTestMapper.selectByExample(null);
//		List<JpTest> list = jpTestMapper.selectByExample(null);
//		System.out.println(users);
//		System.out.println(list);
//	}
}
