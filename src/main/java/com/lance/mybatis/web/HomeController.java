package com.lance.mybatis.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.alibaba.fastjson.JSON;
import com.lance.mybatis.conf.ItemProperties;
import com.lance.mybatis.domain.UserInfo;
import com.lance.mybatis.mongoRepository.UserInfoRepository;
import com.lance.mybatis.service.UserService;

@Controller
public class HomeController {
	

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ItemProperties itemProperties;
	
	@Autowired
	private UserService userService;
	
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	private UserInfoRepository userInfoRepository;



	/**
	 * 进入首页	http://localhost/
	 * 
	 * @param map
	 * @return
	 */
	@GetMapping("/")
	public String home(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host1", "src/main/resources/templates/index.html");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        
        //返回配置文件中的值
        map.addAttribute("host2", JSON.toJSONString(itemProperties));
        LOGGER.info("itemProperties: {}", JSON.toJSONString(itemProperties));
        return "index";  
	}
	
	

	/**
	 * 测试redis
	 * 
	 * @param map
	 * @return
	 */
	@GetMapping("/redis")
	public String redis(ModelMap map) {
		// 保存字符串
        stringRedisTemplate.opsForValue().set("test_Key", "菩提树下的椰子");
        
        //获取保存的字符串，返回到页面
        String test_Key = stringRedisTemplate.opsForValue().get("test_Key");
        map.addAttribute("test_Key", test_Key);
        
        // 保存UserInfo对象
        UserInfo userInfo = userService.getUserById(1);
        redisTemplate.opsForValue().set(userInfo.getId().toString(), userInfo);
        
        //获取保存的UserInfo，返回到页面
        UserInfo user = (UserInfo) redisTemplate.opsForValue().get("1");
        map.addAttribute("user", JSON.toJSONString(user));
        
        return "redis/redis";  
	}
	
	
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


}
