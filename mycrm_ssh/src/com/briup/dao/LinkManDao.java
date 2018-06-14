package com.briup.dao;

import java.util.List;

import com.briup.entity.LinkMan;

public interface LinkManDao {

	void add(LinkMan linkman);

	List<LinkMan> list();

}
