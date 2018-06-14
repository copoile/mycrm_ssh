package com.briup.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.briup.dao.VistDao;
import com.briup.entity.Visit;
@Transactional
public class VisitService {
	private VistDao vistDao;

	public void setVistDao(VistDao vistDao) {
		this.vistDao = vistDao;
	}
	//添加拜访记录
	public void add(Visit visit) {
		vistDao.add(visit);
	}
	//查询所有
	public List<Visit> list() {
		return vistDao.list();
	}
}
