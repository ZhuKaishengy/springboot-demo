package com.aisino.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.dao.UserTestDaoJpa;
import com.aisino.domain.UserJPA;

@Service
public class UserTestService {

	@Autowired
	private UserTestDaoJpa daoJpa;
	
	public UserJPA getById(String id){
		return  daoJpa.findById(id);
	}
	
}
