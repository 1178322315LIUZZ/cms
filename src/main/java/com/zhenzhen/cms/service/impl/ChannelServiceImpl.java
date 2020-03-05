package com.zhenzhen.cms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zhenzhen.cms.dao.ChannelMapper;
import com.zhenzhen.cms.entity.Category;
import com.zhenzhen.cms.entity.Channel;
import com.zhenzhen.cms.service.ChannelService;

@Service
public class ChannelServiceImpl implements ChannelService {
	@Resource
	private ChannelMapper channelMapper;

	public List<Channel> selects() {

		return channelMapper.selects();
	}

	public List<Category> selectsByCid(Integer channelId) {
		return channelMapper.selectsByCid(channelId);
	}

}
