package com.lance.mybatis.mongoRepository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lance.mybatis.conf.mongoLog.ItemLog;

public interface MangoLogRepository extends MongoRepository<ItemLog, String> {

}
