### springboot 完整例子
---
#### 搭建spring-boot 的helloworld
**1. spring-boot 项目搭建所必须的pom**
```java
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
