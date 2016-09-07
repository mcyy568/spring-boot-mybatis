package com.lance.mybatis.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lance.mybatis.service.UserService;

@Controller
public class IndexController {
	

	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserService userService;

	/**
	 * 查询用户
	 * @return
	 */
	@ResponseBody
	@RequestMapping("finduser")
	public String findUser() {
		return JSON.toJSONString(userService.findAll());
	}
	
	/**
	 * findById
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("user/{id}")
	public String findById(@PathVariable int id) {
		System.out.println("1111");
		LOGGER.info("getUserByIdAndUsernameOrPassword success! user:'{}'", "wwwww");
		LOGGER.debug("getUserByIdAndUsernameOrPassword success! user:'{}'", "wwwww");
		LOGGER.error("getUserByIdAndUsernameOrPassword success! user:'{}'", "wwwww");
		return JSON.toJSONString(userService.findOne(id));
	}
	

}
