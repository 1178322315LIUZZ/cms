package com.zhenzhen.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenzhen.cms.dao.ChannelDao;
import com.zhenzhen.cms.entity.Category;
import com.zhenzhen.cms.entity.Channel;
import com.zhenzhen.cms.service.ChannelService;
@Service
public class ChannelServiceImpl implements ChannelService {
	@Autowired
	private ChannelDao channelDao;

	public List<Channel> selects() {
		// TODO Auto-generated method stub
		return channelDao.selects();
	}

	public List<Category> sele(Integer channelId) {
		// TODO Auto-generated method stub
		return channelDao.sele(channelId);
	}
}
