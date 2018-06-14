package com.briup.dao;



import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.briup.entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	@SuppressWarnings("all")
	@Override
	public User login(User user) {
		HibernateTemplate template = this.getHibernateTemplate();
		List<User> list = (List<User>) template.find("from User where username=? and password=?", user.getUsername(),user.getPassword());
		if(list!=null&&list.size()!=0){
			User u = list.get(0);
			return u;
		}
		
		return null;
	}
	//添加用户
	@Override
	public void add(User user) {
		this.getHibernateTemplate().save(user);
	}
	//查询所有用户
	@SuppressWarnings("all")
	@Override
	public List<User> list() {
		List<User> list = (List<User>) this.getHibernateTemplate().find("from User");
		return list;
	}
	//通过id查询单个用户
	@Override
	public User findOneById(Integer id) {
		User user = this.getHibernateTemplate().get(User.class, id);
		return user;
	}
	
	/*private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}*/


}
