package com.lance.mybatis.mongoRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lance.mybatis.mongoLog.ItemLog;

public interface MangoLogRepository extends MongoRepository<ItemLog, String> {

}
