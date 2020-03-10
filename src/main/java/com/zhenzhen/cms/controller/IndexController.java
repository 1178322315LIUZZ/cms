package com.zhenzhen.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhenzhen.cms.entity.Article;
import com.zhenzhen.cms.entity.Category;
import com.zhenzhen.cms.entity.Channel;
import com.zhenzhen.cms.service.ChannelService;

@Controller
public class IndexController {
	@Autowired
	private ChannelService channelService;
	
	@RequestMapping(value = {"","/","index"})
	public String index(Model model,Article article) {	
		model.addAttribute("article", article);
		//查询左侧栏目
		List<Channel> channels=channelService.selects();
		model.addAttribute("channels", channels);
		if(article.getChannelId()!=null) {
			List<Category> categorys = channelService.sele(article.getChannelId());
			model.addAttribute("categorys", categorys);			
		}
		return "index/index";
	}
}
