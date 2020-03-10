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
import com.zhenzhen.cms.entity.Category;
import com.zhenzhen.cms.entity.Channel;
import com.zhenzhen.cms.service.ArticleService;
import com.zhenzhen.cms.service.ChannelService;

@Controller
public class IndexController {
	@Autowired
	private ChannelService channelService;
	@Autowired
	private ArticleService art;
	@RequestMapping(value = {"","/","index"})
	public String index(Model model,Article article,@RequestParam(defaultValue = "1")int page) {	
		model.addAttribute("article", article);
		//查询左侧栏目
		List<Channel> channels=channelService.selects();
		model.addAttribute("channels", channels);
		if(article.getChannelId()!=null) {
			List<Category> categorys = channelService.sele(article.getChannelId());
			model.addAttribute("categorys", categorys);			
		}
		PageHelper.startPage(page, 2);
		List<Article> select = art.select(article);
		PageInfo<Article> p=new PageInfo<Article>(select);
		model.addAttribute("g", select);
		model.addAttribute("info", p);
		return "index/index";
	}
	@RequestMapping("show")
	public String show(Article article,Model m) {
		Article list=art.show(article);
		m.addAttribute("g", list);
		return "index/show";
	}
	
	
	
}
