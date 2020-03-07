package com.zhenzhen.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhenzhen.cms.dao.UserDao;
import com.zhenzhen.cms.entity.User;
import com.zhenzhen.cms.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public List<User> select1(User user) {
		// TODO Auto-generated method stub
		return userDao.select1(user);
	}

	public int up(Integer id) {
		// TODO Auto-generated method stub
		return userDao.up(id);
	}

	public int u(Integer id) {
		// TODO Auto-generated method stub
		return userDao.u(id);
	}
}
