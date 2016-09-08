# spring-boot-mybatis

## spring-boot整合mybatis             

```
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.data</groupId>
		<artifactId>spring-data-commons</artifactId>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-configuration-processor</artifactId>
		<optional>true</optional>
	</dependency>
	<!-- 模板引擎 -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-thymeleaf</artifactId>
	</dependency>
	<!-- Test -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-test</artifactId>
		<scope>test</scope>
	</dependency>
	<!-- Mybatis -->
	<dependency>
		<groupId>org.mybatis.spring.boot</groupId>
		<artifactId>mybatis-spring-boot-starter</artifactId>
		<version>1.1.1</version>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-security</artifactId>
	</dependency>
	<!-- MYSQL -->
	<dependency>
		<groupId>mysql</groupId>
		<artifactId>mysql-connector-java</artifactId>
	</dependency>
	<!-- druid -->
	<dependency>
		<groupId>com.alibaba</groupId>
		<artifactId>druid</artifactId>
		<version>1.0.20</version>
	</dependency>
	<!-- json -->
	<dependency>
		<groupId>com.alibaba</groupId>
		<artifactId>fastjson</artifactId>
		<version>1.2.12</version>
	</dependency>
	<!-- http -->
	<dependency>
		<groupId>org.apache.httpcomponents</groupId>
		<artifactId>httpclient</artifactId>
	</dependency>
```

## Spring Boot属性配置文件详解
```
	application.properties:             主配置文件 项目启动时会自动加载
	application-dev.properties:         开发环境
	application-test.properties:        测试环境
	application-prod.properties:        生产环境
```


## 使用logbak.xml控制日志的输出                   

```
	logging.config=classpath:logbak.xml
```


## Spring Boot构建RESTful API与单元测试

```
	GET 		/users 		查询用户列表
	POST 	    /users 		创建一个用户
	GET 		/users/id 	根据id查询一个用户
	PUT 		/users/id 	根据id更新一个用户
	DELETE 	    /users/id 	根据id删除一个用户
	详见：TestUserController.java	测试类
```

## 使用Thymeleaf模板引擎渲染web视图

	模板详细介绍参照:    http://www.thymeleaf.org/
	使用示例详见:       HomeController.java
```
	Spring Boot提供了默认配置的模板引擎主要有以下几种：
	Thymeleaf
	FreeMarker
	Velocity
	Groovy
	Mustache
	这里使用Thymeleaf模板引擎；
```
```
	<!-- 模板引擎 -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-thymeleaf</artifactId>
	</dependency>
```

### Spring Boot中使用Redis数据库   

```
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-redis</artifactId>
	</dependency>
```
	Redis相关配置，具体说明如下：            
```
	# REDIS (RedisProperties)
	# Redis数据库索引（默认为0）
	spring.redis.database=0  
	# Redis服务器地址
	spring.redis.host=localhost  
	# Redis服务器连接端口
	spring.redis.port=6379  
	# Redis服务器连接密码（默认为空）
	spring.redis.password=  
	# 连接池最大连接数（使用负值表示没有限制）
	spring.redis.pool.max-active=8  
	# 连接池最大阻塞等待时间（使用负值表示没有限制）
	spring.redis.pool.max-wait=-1  
	# 连接池中的最大空闲连接
	spring.redis.pool.max-idle=8  
	# 连接池中的最小空闲连接
	spring.redis.pool.min-idle=0  
	# 连接超时时间（毫秒）
	spring.redis.timeout=0  
```

实战中我们还经常会在Redis中存储对象                    
需要我们自己实现RedisSerializer<T>接口来对传入对象进行序列化和反序列化                  
```
	RedisConfig.java			redis序列化配置
	RedisController.java		redis测试Controller
```


## Spring Boot中使用MongoDB数据库

```
	<!-- mongodb -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-data-mongodb</artifactId>
	</dependency>
```

mongodb相关配置，具体说明如下：  
```
	#mongodb mongo中对test库创建具备读写权限的用户（用户名为name，密码为pass）
	# spring.data.mongodb.uri=mongodb://name:pass@localhost:27017/test
	# 若使用mongodb 2.x，也可以通过如下参数配置，该方式不支持mongodb 3.x。
	spring.data.mongodb.host=localhost 
	spring.data.mongodb.port=27017
```

      
```
	UserInfoRepository.java	    mongodbService配置
	MongodbController.java      mongodb测试Controller
```
      