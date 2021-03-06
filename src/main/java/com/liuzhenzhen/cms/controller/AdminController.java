package com.liuzhenzhen.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuzhenzhen.cms.entity.Article;
import com.liuzhenzhen.cms.entity.User;
import com.liuzhenzhen.cms.service.ArticleService;
import com.liuzhenzhen.cms.service.UserService;
@RequestMapping("admin")
@Controller
public class AdminController {
	
	@Autowired
	private ArticleService articleService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"","/","admin"})
	public String admin() {
		return "admin/index";
	}
	
	@RequestMapping("articles")
	public String articles(Article article,Model m,@RequestParam(defaultValue = "1")int page) {
		PageHelper.startPage(page, 2);
		List<Article> list = articleService.select(article);
		PageInfo<Article> pa=new PageInfo<Article>(list);
		m.addAttribute("g", list);
		m.addAttribute("info", pa);
		return "admin/articles";
	}
	@RequestMapping("upda")
	@ResponseBody
	public int upda(Integer id) {
		return articleService.upda(id);
	}
	@RequestMapping("upd")
	@ResponseBody
	public int upd(Integer id) {
		return articleService.upd(id);
	}
	@RequestMapping("pass")
	@ResponseBody
	public int pass(Integer id) {
		return articleService.pass(id);
	}
	@RequestMapping("pas")
	@ResponseBody
	public int pas(Integer id) {
		return articleService.pas(id);
	}
	@RequestMapping("user")
	public String users(User user, Model m,@RequestParam(defaultValue = "1")int page) {
		PageHelper.startPage(page, 2);
		List<User> list = userService.select1(user);
		PageInfo<User> pa=new PageInfo<User>(list);
		m.addAttribute("g", list);
		m.addAttribute("info", pa);
		m.addAttribute("us", user);
		return "admin/user";
	}
	@RequestMapping("up")
	@ResponseBody
	public int up(Integer id) {
		return userService.up(id);
	}
	@RequestMapping("u")
	@ResponseBody
	public int u(Integer id) {
		return userService.u(id);
	}
	@RequestMapping("articlecha")
	@ResponseBody
	public Article cha(Integer idd) {
		return articleService.cha(idd);
	}
}
