package com.lance.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication 		// Spring Boot的启动注解
@EnableScheduling 			// Spring Boot的主类中加入@EnableScheduling注解，启用定时任务的配置
@EnableAsync 				// Spring Boot的主类中加入@EnableAsync注解，使@Async注解能够生效
@Configuration 				// Spring Boot配置注解
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
