package com.lance.mybatis.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.lance.mybatis.service.UserService;

@Component
public class ScheduledTasks {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);
	
	@Autowired
	private UserService userService;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	// @Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
	// @Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
	// @Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
	// @Scheduled(cron="*/5 * * * * *") ：通过cron表达式定义规则
	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {

		LOGGER.info("测试UserService: {}", JSON.toJSONString(userService.getUserById(2)));
		
		LOGGER.info("现在时间: {}", dateFormat.format(new Date()));
	}

}