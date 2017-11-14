package com.aisino.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cloud.CloudAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication(exclude=CloudAutoConfiguration.class)
@ComponentScan(basePackages={"com.aisino.controller"})
public class MainApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MainApplication.class, args);
	}
	
	//关闭banner
	/*public static void main(String[] args) throws Exception {
		SpringApplication application = new SpringApplication(MainApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}*/


}
