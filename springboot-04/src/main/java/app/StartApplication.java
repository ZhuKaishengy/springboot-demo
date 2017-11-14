package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@ComponentScan(basePackages={"com.aisino.controller","com.aisino.service"})
@EnableJpaRepositories(basePackages={"com.aisino.dao"})
@EntityScan(basePackages="com.aisino.domain")
public class StartApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StartApplication.class, args);
	}

}
