package com.lance.mybatis.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.lance.mybatis.domain.UserInfo;
import com.lance.mybatis.service.UserService;


@RestController	//新注解@RestController返回JSON，方法头不用加@ResponseBody
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;

	/**
	 * 获取用户列表
	 * 
	 * @return
	 */
	@GetMapping("users")
	public String getUserList() {
		return JSON.toJSONString(userService.findAll());
	}
	
	/**
	 * 创建用户
	 * 
	 * @return
	 */
	@PostMapping("users")
	public String saveUser(@RequestBody UserInfo userInfo) {
		return userService.saveUser(userInfo).toString();
	}
	
	/**
	 * 删除用户
	 * 
	 * @return
	 */
	@DeleteMapping("users/{id}")
	public String deleteUserById(@PathVariable int id) {
		return JSON.toJSONString(userService.deleteUserById(id));
	}
	
	/**
	 * 获取用户详细信息
	 * 
	 * @return
	 */
	@GetMapping("users/{id}")
	public String getUserById(@PathVariable int id) {
		return JSON.toJSONString(userService.getUserById(id));
	}
	
	/**
	 * 更新用户详细信息
	 * 
	 * @return
	 */
	@PutMapping("users")
	public String updateUserById(@RequestBody UserInfo userInfo) {
		return JSON.toJSONString(userService.updateUserById(userInfo));
	}

	
	
}
