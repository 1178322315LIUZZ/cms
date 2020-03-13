package com.zhenzhen.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhenzhen.cms.dao.CommentMapper;
import com.zhenzhen.cms.entity.Article;
import com.zhenzhen.cms.entity.Comment;
import com.zhenzhen.cms.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Resource
	private CommentMapper commentMapper;

	public int insert(Comment comment) {
		return commentMapper.insert(comment);
	}

	public List<Comment> select(Article article) {
		// TODO Auto-generated method stub
		return commentMapper.selects(article);
	}

}
