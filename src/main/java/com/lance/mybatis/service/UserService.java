package com.lance.mybatis.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.lance.mybatis.domain.UserInfo;

@Transactional
public interface UserService {

	List<UserInfo> findAll();
	
	UserInfo getUserById(Integer id);
	
	Integer saveUser(UserInfo userInfo);

	Integer deleteUserById(Integer id);

	Integer updateUserById(UserInfo userInfo);
}
