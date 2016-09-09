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

## Spring Boot创建定时任务
在Spring Boot的主类中加入@EnableScheduling注解，启用定时任务的配置                                        
创建定时任务实现类                      
```
	ScheduledTasks.java
```

在上面的入门例子中，使用了@Scheduled(fixedRate = 5000) 注解来定义每过5秒执行的任务，对于@Scheduled的使用可以总结如下几种方式:                 
```
	@Scheduled(fixedRate = 5000):上一次开始执行时间点之后5秒再执行
	@Scheduled(fixedDelay = 5000):上一次执行完毕时间点之后5秒再执行
	@Scheduled(initialDelay=1000, fixedRate=5000):第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
	@Scheduled(cron="*/5 * * * * *"):通过cron表达式定义规则
```

## Spring Boot使用@Async实现异步调用
在Spring Boot的主程序中配置@EnableAsync让@Async注解能够生效            
   
定义AsyncTasks1.java类，创建三个处理函数分别模拟三个执行任务的操作，操作消耗时间随机取（10秒内）          
写测试类TestAsyncTasks.java           
此时可以反复执行单元测试，您可能会遇到各种不同的结果，比如：          
- 没有任何任务相关的输出
- 有部分任务相关的输出
- 乱序的任务相关的输出
                 
为了让doTaskOne、doTaskTwo、doTaskThree能正常结束，假设我们需要统计一下三个任务并发执行共耗时多少，这就需要等到上述三个函数都完成调动之后记录时间，并计算结果。                 
                 
那么我们如何判断上述三个异步调用是否已经执行完成呢？我们需要使用Future<T>来返回异步调用的结果             
定义AsyncTasks2.java类                  
在测试用例一开始记录开始时间                 
在调用三个异步函数的时候，返回Future<String>类型的结果对象                 
在调用完三个异步函数之后，开启一个循环，根据返回的Future<String>对象来判断三个异步函数是否都结束了。若都结束，就结束循环；若没有都结束，就等1秒后再判断。                 
跳出循环之后，根据结束时间 - 开始时间，计算出三个任务并发执行的总耗时。                 
执行一下上述的单元测试，可以看到如下结果：                          
```
开始做任务一
开始做任务二
开始做任务三
完成任务三，耗时：37毫秒
完成任务二，耗时：3661毫秒
完成任务一，耗时：7149毫秒
任务全部完成，总耗时：8025毫秒
```






      