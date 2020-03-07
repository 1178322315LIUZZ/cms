package com.zhenzhen.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenzhen.cms.dao.ArticleDao;
import com.zhenzhen.cms.entity.Article;
import com.zhenzhen.cms.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao articleDao;

	public List<Article> selects(Article article) {
		// TODO Auto-generated method stub
		return articleDao.selects(article);
	}

	public int insert(Article article) {
		// TODO Auto-generated method stub
		return articleDao.insert(article);
	}

	public Article cha(Integer id) {
		// TODO Auto-generated method stub
		return articleDao.cha(id);
	}

	public List<Article> select(Article article) {
		// TODO Auto-generated method stub
		return articleDao.select(article);
	}

	public int upda(Integer id) {
		// TODO Auto-generated method stub
		return articleDao.upda(id);
	}

	public int upd(Integer id) {
		// TODO Auto-generated method stub
		return articleDao.upd(id);
	}

	public int pass(Integer id) {
		// TODO Auto-generated method stub
		return articleDao.pass(id);
	}

	public int pas(Integer id) {
		// TODO Auto-generated method stub
		return articleDao.pas(id);
	}

	
	
}
