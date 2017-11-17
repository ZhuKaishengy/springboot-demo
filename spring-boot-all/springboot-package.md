#### 详细讲解spring-boot项目如何打包
##### 详细代码参看spring-boot-jta项目
---
**1. 代码改造**
* 修改pom文件:
	* 加入spring-boot-maven-plugin
	* 加入maven-surefire-plugin（不校验测试文件）
	* 加入<finalName>spring-boot-jta</finalName>指定web项目根路径
```xml
<build>
   <finalName>spring-boot-jta</finalName>
    <plugins>
      <plugin>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-maven-plugin</artifactId>
     </plugin>
      <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
        <configuration>
          <source>1.8</source>
          <target>1.8</target>
        </configuration>
      </plugin>
      <plugin>
        <artifactId>maven-war-plugin</artifactId>
        <configuration>
          <failOnMissingWebXml>false</failOnMissingWebXml>
        </configuration>
      </plugin>
       <plugin>  
        <groupId>org.apache.maven.plugins</groupId>  
        <artifactId>maven-surefire-plugin</artifactId>  
        <configuration>  
          <skipTests>true</skipTests>  
        </configuration>  
      </plugin>  
    </plugins>
  </build>
```
* 修改spring-boot启动类，使tomcat识别spring-boot启动类
```java
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
	 @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

}
```
**2. 使用maven命令打包**
* maven package
**3. 访问http://localhost:8080/spring-boot-jta
