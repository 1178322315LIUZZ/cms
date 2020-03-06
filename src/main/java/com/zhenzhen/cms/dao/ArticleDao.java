package com.zhenzhen.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhenzhen.cms.entity.Article;

public interface ArticleDao {

	List<Article> selects(Article article);

	int insert(Article article);

	Article cha(@Param("idd")Integer id);

	List<Article> select(Article article);

}
