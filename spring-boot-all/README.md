### springboot 完整例子
---
#### 搭建spring-boot 的helloworld
**1. spring-boot 项目搭建所必须的pom**
```xml
<parent>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-parent</artifactId>
	<version>1.5.8.RELEASE</version>
</parent>
<dependencies>
	<!-- spring-boot-starter-web -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
</dependencies>
```
**2. 写一个controller**
```java
@RestController
public class MyController {

	@RequestMapping("/hello")
	public Msg hello(){
		
		return Msg.success();
	}
}
```
**3. spring-boot 的项目启动方法**
```java
@EnableAutoConfiguration
@ComponentScan(basePackages="com.aisino")
public class MyApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MyApplication.class, args);
	}

}
```
**4. 演示结果**<br><br>
![show01](https://github.com/ZhuKaishengy/StaticRepos/raw/master/img/show01.jpg "演示图片")
