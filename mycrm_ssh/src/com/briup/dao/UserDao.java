package com.briup.dao;

import java.util.List;

import com.briup.entity.User;

public interface UserDao {

	User login(User user);

	void add(User user);

	List<User> list();

	User findOneById(Integer id);


}
