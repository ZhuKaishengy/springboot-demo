package com.aisino.readFile;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Description: 测试读取资源文件@ConfigurationProperties(prefix="jdbc")只能读默认配置文件
 * @author zhukaishengy
 * @date 2017年11月15日
 */
@Component
@ConfigurationProperties(prefix="jdbc")
public class ReadFile2 {
	private String username;
	private String password;
	private String url;
	private String driver;
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
