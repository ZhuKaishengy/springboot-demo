package com.aisino.db2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisino.db2.dao.JpTestMapper;
import com.aisino.db2.domain.JpTest;

@Service
public class JpTestService {

	@Autowired
	private JpTestMapper jpTestMapper;
	
	public List<JpTest> getTests(){
		return jpTestMapper.selectByExample(null);
	}
	
	public void addTest(){
		JpTest record = new JpTest("1001", "zks");
		jpTestMapper.insertSelective(record );
	}
}
