package com.zhenzhen.cms.dao;

import java.util.List;

import com.zhenzhen.cms.entity.Article;
import com.zhenzhen.cms.entity.Comment;


public interface CommentMapper {
	
	/**
	 * 
	 * @Title: insert 
	 * @Description: 增加评论
	 * @param comment
	 * @return
	 * @return: int
	 */
	int insert(Comment comment);
	/**
	 * 
	 * @Title: selects 
	 * @Description: 根据文章查询文章评论
	 * @param article
	 * @return
	 * @return: List<Comment>
	 */
	List<Comment> selects(Article article);

}
