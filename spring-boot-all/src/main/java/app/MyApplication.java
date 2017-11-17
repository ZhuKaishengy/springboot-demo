package app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.aisino.dao.UserTestDao;

@EnableAutoConfiguration
@ComponentScan(basePackages="com.aisino")
//@EnableJpaRepositories(basePackages={"com.aisino.dao"})
//@EntityScan(basePackages={"com.aisino.domain"})
@MapperScan(basePackages={"com.aisino.dao.mybatis"})
public class MyApplication {

	/**
	 * @Description: 这个dao需要手动注入到ioc容器中
	 * @author zhukaisheng
	 * @date 2017年11月16日
	 */
//	@Bean
//	private UserTestDao userTestDao(){
//		return new UserTestDao();
//	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(MyApplication.class, args);
	}

}
