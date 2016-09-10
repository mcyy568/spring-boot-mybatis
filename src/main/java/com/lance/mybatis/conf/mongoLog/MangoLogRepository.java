package com.lance.mybatis.conf.mongoLog;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MangoLogRepository extends MongoRepository<ItemLog, String> {

}
