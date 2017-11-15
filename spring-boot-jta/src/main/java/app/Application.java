package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableAutoConfiguration
//@ComponentScan(value={"com.aisino.controller","com.aisino.db1.service","com.aisino.db1.domain","com.aisino.db1.dbconfig","com.aisino.sysconfig","com.aisino.db2.service","com.aisino.db2.domain","com.aisino.db2.dbconfig"})
@ComponentScan(basePackages={"com.aisino.controller","com.aisino.sysconfig","com.aisino.db1","com.aisino.db2"})
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

}
