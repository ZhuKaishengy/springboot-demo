package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.aisino.dao.UserDao;

@EnableAutoConfiguration
@ComponentScan(basePackages={"com.aisino.controller","com.aisino.service"})
public class StartApplication {

	@Bean
	private UserDao userDao(){
		return new UserDao();
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(StartApplication.class, args);
	}

}
