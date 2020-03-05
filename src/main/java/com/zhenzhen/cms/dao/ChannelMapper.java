package com.zhenzhen.cms.dao;

import java.util.List;

import com.zhenzhen.cms.entity.Category;
import com.zhenzhen.cms.entity.Channel;

public interface ChannelMapper {
	/**
	 * 
	 * @Title: select 
	 * @Description: 根据id返回栏目对象
	 * @param id
	 * @return
	 * @return: Channel
	 */
	Channel select(Integer id);
	
	/**
	 * 
	 * @Title: selects 
	 * @Description: 栏目列表
	 * @return
	 * @return: List<Channel>
	 */
	List<Channel> selects();
	
	/**
	 * 
	 * @Title: selectsByCid 
	 * @Description: 根据栏目查询分类
	 * @param channelId
	 * @return
	 * @return: List<Category>
	 */
	List<Category> selectsByCid(Integer channelId);

}
