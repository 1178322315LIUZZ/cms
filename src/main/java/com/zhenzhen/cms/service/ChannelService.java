package com.zhenzhen.cms.service;

import java.util.List;

import com.zhenzhen.cms.entity.Category;
import com.zhenzhen.cms.entity.Channel;

public interface ChannelService {

	List<Channel> selects();

	List<Category> sele(Integer channelId);

}
