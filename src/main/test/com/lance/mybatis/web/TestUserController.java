package com.lance.mybatis.web;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lance.mybatis.Application;
import com.lance.mybatis.domain.UserInfo;
import com.lance.mybatis.utils.HttpNetClient;


@SuppressWarnings({ "static-access", "deprecation" })
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(Application.class)
public class TestUserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(TestUserController.class);

	@Test
	public void testGetUserList (){
		HttpNetClient httpNetClient = new HttpNetClient();
        String users = httpNetClient.doGet("http://localhost/users");
        LOGGER.info(users);
	}
	
	@Test
	public void testSaveUser (){
        UserInfo userInfo = new UserInfo();
        userInfo.setName("张三");
        userInfo.setTel("123");
        userInfo.setCreateTime(new Date());
        
        HttpNetClient httpNetClient = new HttpNetClient();
        String bre = httpNetClient.doPost("http://localhost/users", userInfo);
        LOGGER.info(bre);
	}
	
	
	@Test
	public void testDeleteUserById (){
		HttpNetClient httpNetClient = new HttpNetClient();
        String bre = httpNetClient.doDelete("http://localhost/users/31");
        LOGGER.info(bre);
	}
	
	
	@Test
	public void testGetUserById (){
		HttpNetClient httpNetClient = new HttpNetClient();
        String user = httpNetClient.doGet("http://localhost/users/1");
        LOGGER.info(user);
	}
	

	@Test
	public void testUpdateUserById (){
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setName("张三");
        userInfo.setTel("123");
        userInfo.setCreateTime(new Date());
        
        HttpNetClient httpNetClient = new HttpNetClient();
        String bre = httpNetClient.doPut("http://localhost/users", userInfo);
        LOGGER.info(bre);
	}
	
}
