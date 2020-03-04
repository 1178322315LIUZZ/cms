package com.zhenzhen.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("my")
@Controller
public class MyController {

	@RequestMapping(value = {"","/","index"})
	public String index() {
		
		return "my/index";
	}
}
