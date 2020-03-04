package com.zhenzhen.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhenzhen.cms.dao.ArticleDao;
import com.zhenzhen.cms.entity.Article;
import com.zhenzhen.cms.service.ArticleService;

public class ArticleServiceImpl implements ArticleService{
	@Autowired
	private ArticleDao articleMapper;
	public List<Article> selects(Article article) {
		return articleMapper.selects(article);
	}
	public int insert(Article article) {
		return articleMapper.insert(article);
	}

}
