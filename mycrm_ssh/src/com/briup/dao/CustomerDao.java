package com.briup.dao;

import java.util.List;

import com.briup.entity.Customer;

public interface CustomerDao {

	void add(Customer customer);

	List<Customer> list();

	Customer findOneById(Integer id);

	void delete(Customer c);

	void update(Customer customer);

	Integer findCount();

	List<Customer> listPage(Integer begin, Integer pageSize);

	Integer findConditionCount(Customer customer);

	List<Customer> listConditionPage(Integer begin, Integer pageSize, Customer customer);

}
