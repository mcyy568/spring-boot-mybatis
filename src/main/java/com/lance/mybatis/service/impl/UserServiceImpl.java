package com.lance.mybatis.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lance.mybatis.domain.UserInfo;
import com.lance.mybatis.mapper.UserMapper;
import com.lance.mybatis.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
	private UserMapper userMapper;

	@Override
	public List<UserInfo> findAll() {
		return userMapper.findAll();
	}

	@Override
	public UserInfo getUserById(Integer id) {
		return userMapper.getUserById(id);
	}

	@Override
	public Integer saveUser(UserInfo userInfo) {
		userInfo.setCreateTime(new Date());
		try {
			return userMapper.saveUser(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Integer deleteUserById(Integer id) {
		try {
			return userMapper.deleteUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Integer updateUserById(UserInfo userInfo) {
		try {
			return userMapper.updateUserById(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
