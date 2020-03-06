package com.zhenzhen.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhenzhen.cms.entity.Category;
import com.zhenzhen.cms.entity.Channel;

public interface ChannelDao {

	List<Channel> selects();

	List<Category> sele(@Param("idd")Integer channelId);

}
