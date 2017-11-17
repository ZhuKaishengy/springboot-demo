#### spring-boot 整合mybatis、mybatis-generator、事务
**1. 导入mybatis、mybatis-generator的maven依赖**
```xml
<!-- mybatis-spring-boot-starter -->
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>1.3.1</version>
</dependency>
```
* mybatis-generator插件，加入可使用maven启动
```xml
<!-- mybatis-generator maven插件 -->
   <plugin>  
      <groupId>org.mybatis.generator</groupId>  
      <artifactId>mybatis-generator-maven-plugin</artifactId>  
      <version>1.3.5</version>  
      <dependencies>  
          <dependency>
				<groupId>com.oracle</groupId>
				<artifactId>ojdbc6</artifactId>
				<version>11.1.0.7.0-Production</version>
		  </dependency>
          <dependency>  
              <groupId>org.mybatis.generator</groupId>  
              <artifactId>mybatis-generator-core</artifactId>  
              <version>1.3.5</version>  
          </dependency>  
      </dependencies>  
      <executions>  
          <execution>  
              <id>Generate MyBatis Artifacts</id>  
              <phase>package</phase>  
              <goals>  
                  <goal>generate</goal>  
              </goals>  
          </execution>  
      </executions>  
      <configuration>  
          <!--允许移动生成的文件 -->  
          <verbose>true</verbose>  
          <!-- 是否覆盖 -->  
          <overwrite>true</overwrite>  
          <!-- 自动生成的配置 -->  
          <configurationFile>  
              src/main/resources/generator/MBG.xml</configurationFile>  
  	  </configuration>  
   </plugin>
```
**2. 修改全局配置文件application.yml，配置mybatis**
```
mybatis:
  type-aliases-package: com.aisino.domain
  mapper-locations:
    - classpath:mapper/*.xml
```
**3. 建立mybatis-generator的mbg.xml文件，生成代码**
* 文件在src/main/resources/generator/MBG.xml下，文件的运行方式
	* myeclipse集成插件
	* maven 插件启动 :mybatis-generator-generate


