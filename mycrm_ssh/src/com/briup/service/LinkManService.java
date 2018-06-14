package com.briup.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.briup.dao.LinkManDao;
import com.briup.entity.LinkMan;

@Transactional
public class LinkManService {
	
	private LinkManDao linkManDao;

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	public void add(LinkMan linkman) {
		linkManDao.add(linkman);
	}

	public List<LinkMan> list() {
		
		return linkManDao.list();
	}

}
