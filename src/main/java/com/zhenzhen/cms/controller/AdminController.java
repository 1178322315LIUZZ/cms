package com.zhenzhen.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhenzhen.cms.entity.Article;
import com.zhenzhen.cms.service.ArticleService;
@RequestMapping("admin")
@Controller()
public class AdminController {
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value = {"","/","index"})
	public String index() {
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
}
