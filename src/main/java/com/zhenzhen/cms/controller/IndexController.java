package com.zhenzhen.cms.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhenzhen.cms.entity.Article;
import com.zhenzhen.cms.entity.Category;
import com.zhenzhen.cms.entity.Channel;
import com.zhenzhen.cms.entity.Comment;
import com.zhenzhen.cms.entity.Slide;
import com.zhenzhen.cms.service.ArticleService;
import com.zhenzhen.cms.service.ChannelService;
import com.zhenzhen.cms.service.CommentService;
import com.zhenzhen.cms.service.SlideService;

@Controller
public class IndexController {
	@Autowired
	private ChannelService channelService;
	@Autowired
	private ArticleService art;
	@Autowired
	private SlideService slide;
	@Autowired
	private CommentService comment;
	@RequestMapping(value = {"","/","index"})
	public String index(Model model,Article article,@RequestParam(defaultValue = "1")int page) {
		List<Channel> selects = channelService.selects();
		if(article.getChannelId()!=null) {
			List<Category> sele = channelService.sele(article.getChannelId());
			model.addAttribute("categorys", sele);
		}
		List<Slide> li=slide.select();
		article.setStatus(1);
		PageHelper.startPage(page, 2);
		List<Article> select = art.select(article);
		PageInfo<Article> pa=new PageInfo<Article>(select);
		Article article2 = new Article();
		article2.setStatus(1);
		List<Article> select2 = art.selectt(article2);
		model.addAttribute("g", select);
		model.addAttribute("channels", selects);
		model.addAttribute("info", pa);
		model.addAttribute("li", li);
		model.addAttribute("ss", select2);
		return "index/index";
	}
	
	@RequestMapping("show")
	public String show(Article article,Model m) {
		List<Comment> list=comment.select(article);
		Article show = art.show(article);
		m.addAttribute("g", show);
		m.addAttribute("li", list);
		return "index/show";
	}
}
