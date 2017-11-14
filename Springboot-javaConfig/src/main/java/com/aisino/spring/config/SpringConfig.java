package com.aisino.spring.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.aisino.dao.UserDao;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @Configuration:相当于application.xml
 * @ComponentScan:相当于<context:componentScan></context>
 * @Bean:相当于<bean></bean>
 */
@Configuration
@ComponentScan(basePackages={"com.aisino.spring.config","com.aisino.service"})
@PropertySource(value={"classpath:db.properties"},ignoreResourceNotFound=true)
public class SpringConfig {

	@Bean
	public UserDao getUserDao(){
		return new UserDao();
	}
	@Value("${jdbc.username}")
	private String user;
	
	@Value("${jdbc.password}")
	private String password;
	
	@Value("${jdbc.driver}")
	private String driver;
	
	@Value("${jdbc.url}")
	private String url;
	
	@Bean(destroyMethod="close")
	public DataSource dataSource() throws PropertyVetoException{
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		dataSource.setUser(user);
		dataSource.setPassword(password);
		dataSource.setDriverClass(driver);
		dataSource.setJdbcUrl(url);
		return dataSource;
	}
	
}
