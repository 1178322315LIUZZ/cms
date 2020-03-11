package com.zhenzhen.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenzhen.cms.entity.User;
import com.zhenzhen.cms.service.UserService;
@RequestMapping("passport")
@Controller
public class PassportController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("reg")
	public String reg() {
		return "passport/reg";
	}
	@RequestMapping("login")
	@ResponseBody
	public int login(User user){
		return userService.login(user);
	}
}
