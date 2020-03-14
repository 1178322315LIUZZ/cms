package com.liuzhenzhen.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.liuzhenzhen.cms.entity.Article;

public interface ArticleDao {

	List<Article> selects(Article article);

	int insert(Article article);

	Article cha(@Param("idd")Integer idd);

	List<Article> select(Article article);

	int upda(@Param("idd")Integer id);

	int upd(@Param("idd")Integer id);

	int pass(@Param("idd")Integer id);

	int pas(@Param("idd")Integer id);

	Article show(Article article);

	List<Article> selectt(Article article);
	@Update("update cms_article set cocount=cocount+1 where id=#{idd}")
	void commentCount(@Param("idd")Integer articleId);

	List<Article> coCount();

}