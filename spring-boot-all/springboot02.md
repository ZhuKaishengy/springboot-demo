#### spring-boot 基础
---
**1. spring-boot 加载静态资源文件**
* spring-boot 加载静态资源文件的位置默认是src/main/resources/static文件夹
	* eg<br>
	![show02](https://github.com/ZhuKaishengy/StaticRepos/raw/master/img/show02.jpg "演示图片")
	* 访问
	![show03](https://github.com/ZhuKaishengy/StaticRepos/raw/master/img/show03.jpg "演示图片")
**2. spring-boot 加载页面**
* spring-boot 推荐使用伪动态页面（模板）的方式展示页面，如：freemark等
	* spring-boot 加载模板的默认路径src/main/resources/templates
	* eg：以freemarker为例<br>
	![show04](https://github.com/ZhuKaishengy/StaticRepos/raw/master/img/show04.jpg "演示图片")
	* 添加spring-boot 整合freemarker的依赖包
	```xml
	 <!-- spring-boot-starter-freemarker -->
    <dependency>
	    <groupId>org.springframework.boot</groupId>
	    <artifactId>spring-boot-starter-freemarker</artifactId>
	</dependency>
	```
	* 写一个controller，不是rest风格的，在请求域中加入user对象，在template.ftl中显示<br>
	![show05](https://github.com/ZhuKaishengy/StaticRepos/raw/master/img/show05.jpg "演示图片")
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
	* 启动项目，查看结果<br>
	![show06](https://github.com/ZhuKaishengy/StaticRepos/raw/master/img/show06.jpg "演示图片")
	
	
	
	