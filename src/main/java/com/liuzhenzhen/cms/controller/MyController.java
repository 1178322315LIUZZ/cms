package com.liuzhenzhen.cms.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuzhenzhen.cms.entity.Article;
import com.liuzhenzhen.cms.entity.Category;
import com.liuzhenzhen.cms.entity.Channel;
import com.liuzhenzhen.cms.entity.Collect;
import com.liuzhenzhen.cms.entity.User;
import com.liuzhenzhen.cms.service.ArticleService;
import com.liuzhenzhen.cms.service.ChannelService;
import com.liuzhenzhen.cms.service.CollectService;

@RequestMapping("my")
@Controller
public class MyController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ChannelService channelService;
	@Autowired
	private CollectService collects;
	@RequestMapping(value = {"","/","index"})
	public String index() {
		
		return "my/index";
	}
	
	@RequestMapping("articles")
	public String articles(Article article,Model m,@RequestParam(defaultValue = "1")int page,HttpSession session) {
		User user = (User) session.getAttribute("user");
		article.setUserId(user.getId());
		PageHelper.startPage(page, 2);
		List<Article> list = articleService.selects(article);
		PageInfo<Article> pa=new PageInfo<Article>(list);
		m.addAttribute("g", list);
		m.addAttribute("info", pa);
		return "my/articles";
	}
	
	@RequestMapping("public")
	public String publich() {
		return "my/publish";
	}
	
	@RequestMapping("channel")
	@ResponseBody
	public List<Channel> chann(){
		
		return channelService.selects();
	}
	
	@RequestMapping("categorys")
	@ResponseBody
	public List<Category> cate(Integer channelId){
		return channelService.sele(channelId);
	}
	
	@ResponseBody
	@PostMapping("fabu")
	public int  publish(@RequestParam("file2") MultipartFile file, Article article,HttpSession session) {
		
		if(!file.isEmpty()) {
		   String upload ="d:/pic/";	//文件路径
   			//获取文件名称
		   String filename = file.getOriginalFilename();
		   //防止文件重名。改文件名称
		 String newFilename = UUID.randomUUID()+ filename.substring(filename.lastIndexOf("."));
			File f = new File(upload,newFilename);
			try {
				file.transferTo(f);
			} catch (IllegalStateException e) {
			} catch (IOException e) {
				e.printStackTrace();
			}
			article.setPicture(newFilename);//封装上传的文件名称
		}
		//封装文件的基本属性
		User user = (User) session.getAttribute("user");
		article.setUserId(user.getId());	
		article.setStatus(0);//默认待审核
		article.setHits(0);;//默认点击量为 0
		article.setDeleted(0);//默认未删除
		article.setCreated(new Date());//默认发布时间
		article.setUpdated(new Date());//默认发布时间
		article.setContentType(0);//发布的文章类型
		article.setHot(0);//非热点
		return articleService.insert(article);
		
	}
	@RequestMapping("articlecha")
	@ResponseBody
	public Article cha(Integer idd) {
		return articleService.cha(idd);
	}
	@RequestMapping("collect")
	public String collect(HttpSession session,Model m) {
		User user=(User) session.getAttribute("user");
		List<Collect> list=collects.select(user.getId());
		m.addAttribute("g", list);
		return "my/collect";
	}
}
