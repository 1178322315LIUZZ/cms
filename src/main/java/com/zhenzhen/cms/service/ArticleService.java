package com.zhenzhen.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhenzhen.cms.entity.Article;

public interface ArticleService {

	List<Article> selects(Article article);
	int insert(Article article);
}
