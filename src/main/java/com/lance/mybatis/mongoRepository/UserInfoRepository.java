package com.lance.mybatis.mongoRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lance.mybatis.domain.UserInfo;

public interface UserInfoRepository extends MongoRepository<UserInfo, Long> {

	UserInfo findByName(String name);
	

	UserInfo findByTel(String tel);

}

