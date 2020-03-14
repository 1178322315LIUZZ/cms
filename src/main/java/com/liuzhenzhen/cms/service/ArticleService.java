package com.liuzhenzhen.cms.service;

import java.util.List;

import com.liuzhenzhen.cms.entity.Article;

public interface ArticleService {
	
	List<Article> selects(Article article);
	
	int insert(Article article);

	Article cha(Integer idd);

	List<Article> select(Article article);

	int upda(Integer id);

	int upd(Integer id);

	int pass(Integer id);

	int pas(Integer id);

	Article show(Article article);

	List<Article> selectt(Article article);

	void commentCount(Integer articleId);

	List<Article> coCount();

}
