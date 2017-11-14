package com.aisino.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: App 
 * @Description: 
 * 1、@ComponentScan:自动扫描包
 * 2、basePackages：主包位置
 * 3、includeFilters：包含有RestController注解修饰的包
 * @author zhukaishengy
 * @date 2017年11月3日
 */
@EnableAutoConfiguration
@ComponentScan(basePackages="com.aisino",includeFilters=@Filter(type=FilterType.ANNOTATION,classes=RestController.class))
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
