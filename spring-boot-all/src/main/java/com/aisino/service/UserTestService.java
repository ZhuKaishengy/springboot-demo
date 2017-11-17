package com.aisino.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.dao.mybatis.UserTestMybatisMapper;
import com.aisino.domain.mybatis.UserTestMybatis;

@Service
public class UserTestService {

//	@Autowired
//	private UserTestDaoJpa daoJpa;
//	
//	public List<UserJPA> getById(String id){
////		return  daoJpa.findById(id);
//		return daoJpa.findAll();
//	}
	@Autowired
	private UserTestMybatisMapper mapper;
	
	public List<UserTestMybatis> list(){
		return mapper.selectByExample(null);
	}
}
