# spring-boot-mybatis
spring-boot整合mybatis

```

<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>1.1.1</version>
</dependency>

```

使用druid数据源
使用logbak.xml控制日志的输出


```

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.lance.mybatis.domain.UserInfo;

@Mapper
public interface UserMapper {
	
	/**
	 * 注解方式写sql
	 * @param id
	 * @return
	 */
	@Select(value="select *from boot_user where id=#{id}")
	UserInfo findOne(int id);

	/**
	 * xml配置写sql
	 * @return
	 */
	List<UserInfo> findAll();
}

```


### application.properties
```

# IDENTITY (ContextIdApplicationContextInitializer)
spring.application.name=MyBatis Boot
spring.application.index=1

#Server
server.port=80

#SECURITY (SecurityProperties)
security.basic.enabled=false

#LOG
logging.config=classpath:logbak.xml

#MYBATIS
mybatis.type-aliases-package=com.lance.mybatis.domain
mybatis.mapper-locations=classpath*:/mapper/*Mapper.xml
mybatis.configuration.map-underscore-to-camel-case=true
mybatis.configuration.use-generated-keys=true
mybatis.configuration.default-fetch-size=100
mybatis.configuration.default-statement-timeout=30

#DATASOURCE
spring.datasource.continueOnError=true
spring.datasource.type=com.alibaba.druid.pool.DruidDataSource
spring.datasource.url=jdbc:mysql://localhost:3306/test
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.jdbc.Driver

spring.datasource.initialSize=5
spring.datasource.minIdle=5
spring.datasource.maxActive=20
spring.datasource.maxWait=60000
spring.datasource.timeBetweenEvictionRunsMillis=60000
spring.datasource.validationQuery=SELECT 1
spring.datasource.testWhileIdle=true
spring.datasource.testOnBorrow=false
spring.datasource.testOnReturn=false
spring.datasource.poolPreparedStatements=true
spring.datasource.maxPoolPreparedStatementPerConnectionSize=20
spring.datasource.filters=stat
spring.datasource.connectionProperties=druid.stat.mergeSql=true;druid.stat.slowSqlMillis=5000

```
