package com.briup.dao;

import java.util.List;

import com.briup.entity.Visit;

public interface VistDao {

	void add(Visit visit);

	List<Visit> list();

}
