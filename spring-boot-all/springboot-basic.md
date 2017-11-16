#### spring-boot 基础
---
##### spring-boot 的默认文件加载路径
* Maven的资源文件目录：/src/java/resources 
* spring-boot项目静态文件目录：/src/java/resources/static 
* spring-boot项目模板文件目录：/src/java/resources/templates 
* spring-boot静态首页的支持，即index.html放在以下目录结构会直接映射到应用的根目录下

**1. spring-boot 项目中加载静态资源文件**
* spring-boot 加载静态资源文件的位置默认是src/main/resources/static文件夹
	* eg<br><br>
	![show02](https://github.com/ZhuKaishengy/StaticRepos/raw/master/img/show02.jpg "演示图片")
	* 访问<br><br>
	![show03](https://github.com/ZhuKaishengy/StaticRepos/raw/master/img/show03.jpg "演示图片")<br><br>
**2. spring-boot 加载动态页面**
* spring-boot 推荐使用伪动态页面（模板）的方式展示页面，如：freemark等
	* spring-boot 加载模板的默认路径src/main/resources/templates
	* eg：以freemarker为例<br><br>
	![show04](https://github.com/ZhuKaishengy/StaticRepos/raw/master/img/show04.jpg "演示图片")<br><br>
	* 添加spring-boot 整合freemarker的依赖包
	```xml
	 <!-- spring-boot-starter-freemarker -->
    <dependency>
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-freemarker</artifactId>
	</dependency>
	```
	* 写一个controller，不是rest风格的，在请求域中加入user对象，在template.ftl中显示<br><br>
	![show05](https://github.com/ZhuKaishengy/StaticRepos/raw/master/img/show05.jpg "演示图片")<br><br>
	* 编写ftl模板文件:遍历、判断
	```xml
	<#list users as user>
	id:${user.id}<br>
	name : ${user.name}<br>
	age:${user.age}<br>
	createTime:${user.createTime ? string('yyyy-MM-dd hh:mm:ss')}<br>
	<#if user.id == "1001">
		欢迎1001号!<br>
	</#if>
	=========================<br>
	</#list>
	```
	* 启动项目，查看结果<br><br>
	![show06](https://github.com/ZhuKaishengy/StaticRepos/raw/master/img/show06.jpg "演示图片")<br><br>
* spring-boot 中使用jsp
	* 在spring-boot 中使用jsp 需加载如下pom文件
	```xml
	<!-- spring-boot-starter-tomcat -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-tomcat</artifactId>
		<scope>provided</scope>
	</dependency>
	<!-- jasper -->
	<dependency>
		<groupId>org.apache.tomcat.embed</groupId>
		<artifactId>tomcat-embed-jasper</artifactId>
		<scope>provided</scope>
	</dependency>
	<!-- jstl -->
	<dependency>
		<groupId>jstl</groupId>
		<artifactId>jstl</artifactId>
		<version>1.1.2</version>
	</dependency>
	<!-- taglib -->
	<dependency>
		<groupId>taglibs</groupId>
		<artifactId>standard</artifactId>
		<version>1.1.2</version>
	</dependency>
	```
	* 编写非restful风格的controller
	```java
		@RequestMapping("/jspPage")
	public String jspPage(Map<String , Object> map){
		User user1 = new User("1001", "zks", 25, new Date());
		User user2 = new User("1002", "sjx", 22, new Date());
		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		map.put("users", users);
		return "jspPage";
	}
	```
	* 新建spring-boot的全局配置文件application.properties或application.yml<br><br>
	![show07](https://github.com/ZhuKaishengy/StaticRepos/raw/master/img/show07.jpg "演示图片")
	<br><br>
	* 在配置文件中加入internalResourceViewResolver<br><br>
		* application.properties
		```
		spring.mvc.view.prefix=/WEB-INF/views/
		spring.mvc.view.suffix=.jsp
		```
		* application.yml
		```
		spring:
			  mvc:
			    view:
			      prefix: /WEB-INF/views/
			      suffix: .jsp
		```
	* 测试访问<br><br>
	![show08](https://github.com/ZhuKaishengy/StaticRepos/raw/master/img/show08.jpg "演示图片")
	<br><br>
	
* spring-boot 还可以使用其他模板工具，如thymleaf（spring 4.0 推荐使用，spring-boot 默认使用）
	* thymeleaf简介
    	* Thymeleaf 在有网络和无网络的环境下皆可运行，即它可以让美工在浏览器查看页面的静态效果，也可以让程序员在服务器查看带数据的动态页面效果。这是由于它支持 html 原型，然后在 html 标签里增加额外的属性来达到模板+数据的展示方式。浏览器解释 html 时会忽略未定义的标签属性，所以 thymeleaf 的模板可以静态地运行；当有数据返回到页面时，Thymeleaf 标签会动态地替换掉静态内容，使页面动态显示。
    	* Thymeleaf 开箱即用的特性。它提供标准和spring标准两种方言，可以直接套用模板实现JSTL、 OGNL表达式效果，避免每天套模板、该jstl、改标签的困扰。同时开发人员也可以扩展和创建自定义的方言。
    	* Thymeleaf 提供spring标准方言和一个与 SpringMVC 完美集成的可选模块，可以快速的实现表单绑定、属性编辑器、国际化等功能。	
	* 加入maven 依赖
	```xml
	<!-- spring-boot-starter-thymeleaf -->
	<dependency>    
        <groupId>org.springframework.boot</groupId>    
        <artifactId>spring-boot-starter-thymeleaf</artifactId>    
	</dependency>
	```
	* thymeleaf默认使用页面缓存，需要手动禁用缓存
		* application.properties
		```
		spring.thymeleaf.cache=false
		```
		* application.yml
		```
		  thymeleaf:
    		cache: false
		```
	* 编写非restful风格的controller
	```java
	@RequestMapping("/thymeleaf")
	public String thymeleaf(Map<String , Object> map){
		User user1 = new User("1001", "zks", 25, new Date());
		User user2 = new User("1002", "sjx", 22, new Date());
		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		map.put("users", users);
		return "thymeleaf";
	}
	```
	* 编写页面
	```html
	<!DOCTYPE html>
	<html xmlns:th="http://www.thymeleaf.org">
	  <head>
	    <title>thymeleaf.html</title>
	  </head>
	  <body>
	    <span th:each="user:${users}">
	    	<span th:text="${user.id}">id</span><br></br>
	    	<span th:text="${user.name}">username</span><br></br>
	    	<span th:text="${user.age}">age</span><br></br>
	    	<span th:text="${user.createTime}">createTime</span><br></br>
	   		<span th:if="${user.id eq '1001'}">欢迎您：1001号</span><br></br>
	    	---------------------------<br></br>
	    </span>
	  </body>
	</html>
	```
	* 访问测试<br><br>
	![show09](https://github.com/ZhuKaishengy/StaticRepos/raw/master/img/show09.jpg "演示图片")<br><br>
	
**3. maven 插件启动spring-boot的方法**
* 加入maven插件
```
<plugin>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-maven-plugin</artifactId>
</plugin>
```
* 启动方法：spring-boot:run
**4. spring-boot 中全局捕获异常**
* 使用controllerAdvice，增强型的controller捕获异常，@ExceptionHandler(RuntimeException.class)定义异常类型
* eg：
```java
@ResponseBody
@ExceptionHandler(RuntimeException.class)
public Msg respose(){
	return Msg.fail();
}
```
* 访问测试<br><br>
![show10](https://github.com/ZhuKaishengy/StaticRepos/raw/master/img/show10.jpg "演示图片")<br><br>

	
	
	