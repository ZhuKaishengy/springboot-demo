# spring整合所有数据库框架的特点是：
**1. 没有domain、dao、mapper的注解，所以这些不会被扫描到，所以需要通过别的方式注入到spring的ioc容器中**
**2. jdbcTemplate 提供的方式是没有dao，使用jdbcTemplate访问数据库，直接@autowired jdbcTemplate就可以，spring-boot帮我们注入了**
**3. jpa 提供的方式是继承jpaRepository接口访问数据库，使用注解 @EnableJpaRepositories(basePackages={"com.aisino.dao"})扫描dao，
	@EntityScan(basePackages="com.aisino.domain")扫描实体类
**4. mybatis 通过配置application.yml，配置mapper文件的位置mapper-locations和domain的位置：type-aliases-package，dao层的mapper接口通过@mapperScan扫描得到
#### spring-boot 整合jdbc-template
**1. 加入maven的依赖包**
```xml
<!-- oracle 驱动 -->
<dependency>
	<groupId>com.oracle</groupId>
	<artifactId>ojdbc6</artifactId>
	<version>11.1.0.7.0-Production</version>
</dependency>
<!-- spring-boot-starter-jdbc -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>
```
**2. 在全局配置文件（application.yml）中加入数据源**
```
  datasource:
    username: SSO
    password: SSO
    driver-class-name: oracle.jdbc.driver.OracleDriver
    url: jdbc:oracle:thin:@59.197.148.40:1521:orcl
```
**3. 调用jdbc-template**
	* domain层：参见UserTest.java
	* dao层
	```java
	/**
	 * 导入spring-boot-jdbc依赖，spring-boot自动装配
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insertUser(String username,String password){
		int update = jdbcTemplate.update("insert into USER_TEST VALUES (?,?,?)", username,"2",password);
		return update;
	}
	```
	* controller层
	```java
	/**
	 * 一个简易的例子，不写service层了，直接注入dao
	 */
	@Autowired
	private UserTestDao userTestDao;
	
	@RequestMapping("/insertUser")
	public Msg insertUser(){
		userTestDao.insertUser("zks", "zks");
		return Msg.success();
	}
	```
	* spring-boot 启动类
	```java
	/**
	 * @Description: 这个dao需要手动注入到ioc容器中
	 * @author zhukaisheng
	 * @date 2017年11月16日
	 */
	@Bean
	private UserTestDao userTestDao(){
		return new UserTestDao();
	}
	```
#### spring-boot 整合jpa
**1. 导入maven依赖**
```xml
<!-- oracle 驱动 -->
<dependency>
	<groupId>com.oracle</groupId>
	<artifactId>ojdbc6</artifactId>
	<version>11.1.0.7.0-Production</version>
</dependency>
<!-- spring-boot 整合jpa -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```
**2. 在全局配置文件（application.yml）中加入数据源**
```
  datasource:
    username: SSO
    password: SSO
    driver-class-name: oracle.jdbc.driver.OracleDriver
    url: jdbc:oracle:thin:@59.197.148.40:1521:orcl
```
**3. 调用jpa提供的方法访问数据库**
