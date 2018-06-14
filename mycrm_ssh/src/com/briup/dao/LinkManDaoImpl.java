package com.briup.dao;


import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.briup.entity.LinkMan;

public class LinkManDaoImpl extends HibernateDaoSupport implements LinkManDao{

	//添加联系人
	@Override
	public void add(LinkMan linkman) {
		this.getHibernateTemplate().save(linkman);
	}
	
	//查询所有联系人
	@SuppressWarnings("all")
	@Override
	public List<LinkMan> list() {
		List<LinkMan> list = (List<LinkMan>) this.getHibernateTemplate().find("from LinkMan");
		return list;
	}

}
