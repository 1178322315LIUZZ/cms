package com.liuzhenzhen.cms.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuzhenzhen.cms.entity.Article;
import com.liuzhenzhen.cms.entity.Category;
import com.liuzhenzhen.cms.entity.Channel;
import com.liuzhenzhen.cms.entity.Collect;
import com.liuzhenzhen.cms.entity.Comment;
import com.liuzhenzhen.cms.entity.Slide;
import com.liuzhenzhen.cms.entity.User;
import com.liuzhenzhen.cms.service.ArticleService;
import com.liuzhenzhen.cms.service.ChannelService;
import com.liuzhenzhen.cms.service.CollectService;
import com.liuzhenzhen.cms.service.CommentService;
import com.liuzhenzhen.cms.service.SlideService;

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
	@Autowired
	private CollectService collects;
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
	public String show(Article article,Model m,@RequestParam(defaultValue = "1")int page,HttpSession session) {
		List<Comment> list=comment.select(article);
		Article show = art.show(article);
		PageHelper.startPage(page, 5);
		List<Article> lis=art.coCount();
		PageInfo<Article> pages=new PageInfo<Article>(lis);
		User user = (User) session.getAttribute("user");
		Collect collect=null;
		if(user!=null) {
			collect=collects.selectByTitleAndUserId(show.getTitle(), user.getId());
		}
		m.addAttribute("g", show);
		m.addAttribute("li", list);
		m.addAttribute("ss", lis);
		m.addAttribute("co", collect);
		return "index/show";
	}
	@RequestMapping("collect")
	@ResponseBody
	public int collect(Collect collect,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user==null) {
			return 0;
		}
		collect.setUserId(user.getId());
		collect.setCreated(new Date());
		return collects.insert(collect);
	}
	@RequestMapping("deleteCollect")
	@ResponseBody
	public int deleteCollect(Integer id) {
		return collects.delete(id);
	}
}
