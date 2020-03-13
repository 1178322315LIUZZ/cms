package com.zhenzhen.cms.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhenzhen.cms.entity.Comment;
import com.zhenzhen.cms.entity.User;
import com.zhenzhen.cms.service.CommentService;
@RequestMapping("comment")
@Controller
public class CommentController {
	@Autowired
	private CommentService commentService;
	@RequestMapping("insert")
	@ResponseBody
	public int insert(Comment comment,Integer articleId,HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user==null) {
			return 0;
		}else {
			comment.setUserId(user.getId());
			comment.setArticleId(articleId);
			comment.setCreated(new Date());
			return commentService.insert(comment);
		}
	}
	
}
