package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackages="com.aisino")
public class MyApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MyApplication.class, args);
	}

}
