package com.aisino.db1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aisino.db1.dao.UserTestMapper;
import com.aisino.db1.domain.UserTest;
import com.aisino.db2.dao.JpTestMapper;
import com.aisino.db2.domain.JpTest;


@Service
public class UserService {

	@Autowired
	private UserTestMapper userTestMapper;
	
	@Autowired
	private JpTestMapper jpTestMapper;
	
	@Autowired
	private CacheManager cacheManager;
	
	@Async
	public void bigMethod(){
		System.out.println("part 3");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("part 4");
	}
	
	public void clearCache(){
		cacheManager.getCache("baseQueryCache").clear();
	}
	
	@Cacheable("baseQueryCache")
	public List<UserTest> getUsers(){
		return userTestMapper.selectByExample(null);
	}
	
	public void addUser(){
		UserTest record = new UserTest("zks", "1001", "zks");
		userTestMapper.insertSelective(record );
	}
	/**
	 * @Description: 测试在userservice中访问 jpTestMapper，跨数据源，结论：可以访问到
	 * @author zhukaisheng
	 * @date 2017年11月15日
	 */
	public void assoiation(){
		UserTest record = new UserTest("zks", "1001", "zks");
		userTestMapper.insertSelective(record );
		JpTest test = new JpTest("1001", "zks");
		jpTestMapper.insertSelective(test );
		
	}
	/**
	 * @Description: 测试在userservice中访问 jpTestMapper，跨数据源，加入事务，有限访问本数据源，结论：可以回滚
	 * @author zhukaisheng
	 * @date 2017年11月15日
	 */
	@Transactional
	public void assoiation1(){
		UserTest record = new UserTest("zks", "1001", "zks");
		userTestMapper.insertSelective(record);
		System.out.println(1/0);
		JpTest test = new JpTest("1001", "zks");
		jpTestMapper.insertSelective(test );
		
	}
	/**
	 * @Description: 测试在userservice中访问 jpTestMapper，跨数据源，加入事务，优先访问其他的数据源，结论：不可以回滚
	 * @author zhukaisheng
	 * @date 2017年11月15日
	 */
	@Transactional
	public void assoiation2(){
		JpTest test = new JpTest("1001", "zks");
		jpTestMapper.insertSelective(test );
		System.out.println("数据库插入完毕");
		System.out.println(1/0);
		UserTest record = new UserTest("zks", "1001", "zks");
		userTestMapper.insertSelective(record );
		
	}
}
