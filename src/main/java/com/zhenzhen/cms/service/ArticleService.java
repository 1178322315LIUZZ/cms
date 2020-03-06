package com.zhenzhen.cms.service;

import java.util.List;

import com.zhenzhen.cms.entity.Article;

public interface ArticleService {
	
	List<Article> selects(Article article);
	
	int insert(Article article);

	Article cha(Integer id);

	List<Article> select(Article article);
}
