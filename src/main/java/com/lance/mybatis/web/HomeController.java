package com.lance.mybatis.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	

	/**
	 * 进入首页	http://localhost/
	 * 
	 * @param map
	 * @return
	 */
	@GetMapping("/")
	public String findUser(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host1", "src/main/resources/templates/index.html");
        map.addAttribute("host2", "src/main/resources/templates/index.html");
        map.addAttribute("host3", "src/main/resources/templates/index.html");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";  
	}

}
