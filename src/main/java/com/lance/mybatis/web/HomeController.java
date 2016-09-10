package com.lance.mybatis.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.alibaba.fastjson.JSON;
import com.lance.mybatis.conf.ItemProperties;
import com.lance.mybatis.exception.MyException;

@Controller
public class HomeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private ItemProperties itemProperties;

	/**
	 * 进入首页 http://localhost/
	 * 
	 * @param map
	 * @return
	 */
	@GetMapping("/")
	public String home(ModelMap map) {
		// 加入一个属性，用来在模板中读取
		map.addAttribute("host1", "src/main/resources/templates/index.html");
		// return模板文件的名称，对应src/main/resources/templates/index.html

		// 返回配置文件中的值
		map.addAttribute("host2", JSON.toJSONString(itemProperties));
		LOGGER.info("itemProperties: {}", JSON.toJSONString(itemProperties));
		LOGGER.error("itemProperties: {}", JSON.toJSONString(itemProperties));
		LOGGER.debug("itemProperties: {}", JSON.toJSONString(itemProperties));
		
		return "index";
	}

	
	/**
	 * 异常测试HTML
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/test_err_html")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

	/**
	 * 异常测试JSON
	 * 
	 * @return
	 * @throws MyException
	 */
	@GetMapping("/test_err_json")
    public String test_err_json() throws Exception {
        throw new MyException("发生错误2");
    }

}
