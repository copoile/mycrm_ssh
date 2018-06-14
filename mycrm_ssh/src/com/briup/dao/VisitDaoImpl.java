package com.briup.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.briup.entity.Visit;

public class VisitDaoImpl extends HibernateDaoSupport implements VistDao{

	@Override
	public void add(Visit visit) {
		this.getHibernateTemplate().save(visit);
	}

	@SuppressWarnings("all")
	@Override
	public List<Visit> list() {
		List<Visit> list = (List<Visit>) this.getHibernateTemplate().find("from Visit");
		return list;
	}

}
