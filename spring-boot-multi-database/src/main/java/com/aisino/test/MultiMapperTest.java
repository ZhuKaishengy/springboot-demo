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
import com.aisino.db2.dao.EmpMapper;
import com.aisino.db2.domain.Emp;

import app.Application;

@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MultiMapperTest {

	@Autowired
	private UserTestMapper userTestMapper;
	
	@Autowired
	private EmpMapper empMapper;
	
	
	@Test
	public void getUsers(){
		List<UserTest> list = userTestMapper.selectByExample(null);
		System.out.println(list);
	}
	
	@Test
	public void getEmps(){
		List<Emp> emps = empMapper.selectByExample(null);
		System.out.println(emps);
	}
	
	@Test
	public void testTransaction(){
		List<UserTest> list = userTestMapper.selectByExample(null);
		List<Emp> emps = empMapper.selectByExample(null);
		System.out.println(list);
		System.out.println(emps);
	}
}
