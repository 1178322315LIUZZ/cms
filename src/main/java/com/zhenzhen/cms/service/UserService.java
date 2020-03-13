package com.zhenzhen.cms.service;

import java.util.List;

import com.zhenzhen.cms.entity.User;

public interface UserService {

	List<User> select1(User user);

	int up(Integer id);

	int u(Integer id);

	int login(User user);
	User yan(String user);

	User denglu(User user);

	User admindenglu(User user);
}
