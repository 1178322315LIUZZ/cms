package com.zhenzhen.cms.dao;

import java.util.List;

import com.zhenzhen.cms.entity.Article;

public interface ArticleDao {

	List<Article> selects(Article article);

	int insert(Article article);

}
