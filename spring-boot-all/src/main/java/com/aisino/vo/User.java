package com.aisino.vo;

import java.util.Date;

public class User {

	private String id;
	private String name;
	private int age;
	private Date createTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public User(String id, String name, int age, Date createTime) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.createTime = createTime;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
