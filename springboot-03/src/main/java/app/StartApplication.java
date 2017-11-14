package app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages={"com.aisino.controller","com.aisino.service"})
@MapperScan(basePackages={"com.aisino.dao"})
public class StartApplication {
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(StartApplication.class, args);
	}

}
