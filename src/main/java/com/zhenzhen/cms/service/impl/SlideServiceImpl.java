package com.zhenzhen.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenzhen.cms.dao.SlideDao;
import com.zhenzhen.cms.entity.Slide;
import com.zhenzhen.cms.service.SlideService;
@Service
public class SlideServiceImpl implements SlideService {
	@Autowired
	private SlideDao slideDao;

	public List<Slide> select() {
		// TODO Auto-generated method stub
		return slideDao.select();
	}
}
