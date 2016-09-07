package com.lance.mybatis.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lance.mybatis.service.UserService;

//@RestController返回JSON不用加@ResponseBody
@Controller
public class IndexController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);
	
	@Autowired
	private UserService userService;

	/**
	 * 查询用户
	 * @return
	 */
	@ResponseBody
	@RequestMapping("finduser")
	public String findUser() {
		return JSON.toJSONString(userService.findAll());
	}
	
	/**
	 * findById
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("user/{id}")
	public String findById(@PathVariable int id) {
		System.out.println("System.out.println('');");
		LOGGER.info("测试日志打印:'{}'", "info");
		LOGGER.debug("测试日志打印:'{}'", "debug");
		LOGGER.error("测试日志打印:'{}'", "error");
		return JSON.toJSONString(userService.findOne(id));
	}
	

	@RequestMapping("/index")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host1", "src/main/resources/templates/index.html");
        map.addAttribute("host2", "src/main/resources/templates/index.html");
        map.addAttribute("host3", "src/main/resources/templates/index.html");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";  
    }
	
}
