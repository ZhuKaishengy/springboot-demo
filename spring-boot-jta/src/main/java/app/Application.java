package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAsync
//@EnableScheduling
@EnableCaching
@EnableTransactionManagement
@EnableAutoConfiguration
//@ComponentScan(value={"com.aisino.controller","com.aisino.db1.service","com.aisino.db1.domain","com.aisino.db1.dbconfig","com.aisino.sysconfig","com.aisino.db2.service","com.aisino.db2.domain","com.aisino.db2.dbconfig"})
//@ComponentScan(basePackages={"com.aisino.controller","com.aisino.sysconfig","com.aisino.db1","com.aisino.db2","com.aisino.log","com.aisino.scheduled"})
@ComponentScan(basePackages={"com.aisino"})
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
	 @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

}
