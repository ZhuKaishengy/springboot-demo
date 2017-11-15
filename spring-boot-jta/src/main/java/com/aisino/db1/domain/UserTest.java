package com.aisino.db1.domain;

public class UserTest {
    private String username;

    private String userid;

    private String password;

    
    public UserTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserTest(String username, String userid, String password) {
		super();
		this.username = username;
		this.userid = userid;
		this.password = password;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

	@Override
	public String toString() {
		return "UserTest [username=" + username + ", userid=" + userid + ", password=" + password + "]";
	}
    
}