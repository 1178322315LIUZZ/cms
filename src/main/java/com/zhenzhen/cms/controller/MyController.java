package com.zhenzhen.cms.controller;

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
import com.zhenzhen.cms.entity.Article;
import com.zhenzhen.cms.entity.Category;
import com.zhenzhen.cms.entity.Channel;
import com.zhenzhen.cms.service.ArticleService;
import com.zhenzhen.cms.service.ChannelService;

@RequestMapping("my")
@Controller
public class MyController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ChannelService channelService;
	
	@RequestMapping(value = {"","/","index"})
	public String index() {
		
		return "my/index";
	}
	
	@RequestMapping("articles")
	public String articles(Article article,Model m,@RequestParam(defaultValue = "1")int page) {
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
//		User user = (User) session.getAttribute("user");
//	    //从session获取当前登录的人信息
//		if(null==user) {
//			return false;//如果session过期则回到首页重新登录
//		}
//		article.setUserId(user.getId());//
		
		article.setStatus(0);//默认待审核
		article.setHits(0);;//默认点击量为 0
		article.setDeleted(0);//默认未删除
		article.setCreated(new Date());//默认发布时间
		article.setUpdated(new Date());//默认发布时间
		article.setContentType(0);//发布的文章类型
		article.setHot(0);//非热点
		
		return articleService.insert(article);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
