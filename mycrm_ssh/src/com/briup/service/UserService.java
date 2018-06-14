package com.briup.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.briup.dao.UserDao;
import com.briup.entity.User;
@Transactional
public class UserService {
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	//登录
	public User login(User user) {
		
		return userDao.login(user);
	}
	//添加用户
	public void add(User user) {
		userDao.add(user);
	}
	//查询所有用户
	public List<User> list(){
		return userDao.list();
	}
	
	//根据id查询单个用户
	public User findOneById(Integer id){
		return userDao.findOneById(id);
	}
	
}
