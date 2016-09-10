package com.lance.mybatis.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.lance.mybatis.domain.UserInfo;
import com.lance.mybatis.repository.mongo.UserInfoRepository;

public class MongodbController {
	

	private static final Logger LOGGER = LoggerFactory.getLogger(MongodbController.class);

	@Autowired
	private UserInfoRepository userInfoRepository;
	
	/**
	 * 测试mongodb
	 * 
	 * @param map
	 * @return
	 */
	@GetMapping("/mongodb")
	public String mongodb(ModelMap map) {
		
		// 创建三个UserInfo，并验证User总数
		userInfoRepository.save(new UserInfo(1, "di", "33"));
		userInfoRepository.save(new UserInfo(2, "yang", "23"));
		userInfoRepository.save(new UserInfo(3, "li", "15"));
        LOGGER.info("mongodb: {}", userInfoRepository.findAll().size());

		// 删除一个UserInfo，再验证User总数
        UserInfo u = userInfoRepository.findOne(1L);
        userInfoRepository.delete(u);
        LOGGER.info("mongodb: {}", userInfoRepository.findAll().size());

		// 删除一个UserInfo，再验证User总数
		u = userInfoRepository.findByName("yang");
		userInfoRepository.delete(u);
        LOGGER.info("mongodb: {}", userInfoRepository.findAll().size());
        
		// 删除一个UserInfo，再验证User总数
		u = userInfoRepository.findByTel("15");
		userInfoRepository.delete(u);
        LOGGER.info("mongodb: {}", userInfoRepository.findAll().size());
        
        return "index";  
	}

	
	//测试日志写入mongodb
	@GetMapping("/test_1")
	public String test_1(ModelMap map) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "index";
	}

	@GetMapping("/test_2")
	public String test_2(ModelMap map) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "index";
	}

}
