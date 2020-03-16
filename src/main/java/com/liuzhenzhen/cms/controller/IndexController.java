package com.liuzhenzhen.cms.controller;


import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.liuzhenzhen.cms.entity.Article;
import com.liuzhenzhen.cms.entity.Category;
import com.liuzhenzhen.cms.entity.Channel;
import com.liuzhenzhen.cms.entity.Collect;
import com.liuzhenzhen.cms.entity.Comment;
import com.liuzhenzhen.cms.entity.ContentType;
import com.liuzhenzhen.cms.entity.Slide;
import com.liuzhenzhen.cms.entity.User;
import com.liuzhenzhen.cms.entity.Vote;
import com.liuzhenzhen.cms.service.ArticleService;
import com.liuzhenzhen.cms.service.ChannelService;
import com.liuzhenzhen.cms.service.CollectService;
import com.liuzhenzhen.cms.service.CommentService;
import com.liuzhenzhen.cms.service.SlideService;
import com.liuzhenzhen.cms.service.VoteService;
import com.zhenzhen.common.utils.NumberUtil;

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
	@Autowired
	private VoteService votes;
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
		//问卷调查
		Article article3=new Article();
		article3.setStatus(1);
		article3.setContentType(ContentType.VOTE);
		System.out.println(article3);
		List<Article> ll=art.selectss(article3);
		model.addAttribute("ll", ll);
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
	//查询投票情况
	@RequestMapping("voteDetail")
	public String voteDetail(HttpSession session,Integer id,Model m) {
		Article article=art.sess(id);
		String content = article.getContent();
		Gson gson = new Gson();
		LinkedHashMap<Character, String> mapvote=gson.fromJson(content, LinkedHashMap.class);
		m.addAttribute("vote", mapvote);
		m.addAttribute("article", article);
		
		//查询投票情况
		List<Vote> votess=votes.selects(article.getId());
		for (Vote vote : votess) {
			vote.setOption(mapvote.get(vote.getOption()));
			vote.setPercent(new BigDecimal(NumberUtil.getPercent(vote.getOptionNum(), vote.getTotalNum())));
		}
		m.addAttribute("vo", votess);
		return "index/voteDetail";
	}
	//投票
		@ResponseBody
		@PostMapping("addVote")
		public int addVote(Vote vote ,HttpSession session) {
			User user = (User) session.getAttribute("user");
			if(null ==user) {
			return 0;//没有登录的用户不能投票
			}
			vote.setUserId(user.getId());
			Vote vote2 = votes.select(vote);
			//检查用户是否已经投过票
			if(vote2!=null) {
				return 0;
			}
			return votes.insert(vote);
		}
}
