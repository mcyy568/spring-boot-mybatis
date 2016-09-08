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
import com.lance.mybatis.domain.UserInfo;
import com.lance.mybatis.service.UserService;

@Controller
public class RedisController {


	private static final Logger LOGGER = LoggerFactory.getLogger(RedisController.class);
	

	@Autowired
	private UserService userService;
	
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
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
	
}
