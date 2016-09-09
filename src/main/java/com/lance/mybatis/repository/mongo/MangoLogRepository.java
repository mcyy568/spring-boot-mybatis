package com.lance.mybatis.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lance.mybatis.conf.mongoLog.ItemLog;

public interface MangoLogRepository extends MongoRepository<ItemLog, String> {

}
