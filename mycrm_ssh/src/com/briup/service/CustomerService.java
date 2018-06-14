package com.briup.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.briup.dao.CustomerDao;
import com.briup.entity.Customer;
import com.briup.entity.Page;
@Transactional
public class CustomerService {
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	//添加客户
	public void add(Customer customer) {
		customerDao.add(customer);
	}
	//查询所有客户
	
	public List<Customer> list() {
	List<Customer>	list=customerDao.list();
		return list;
	}
	//根据id查询
	public Customer findOnceById(Integer id) {
		Customer customer=customerDao.findOneById(id);
		return customer;
	}
	//删除
	public void delete(Customer c) {
		customerDao.delete(c);
	}
	//更新
	public void update(Customer customer) {
		customerDao.update(customer);
	}
	public Page listPage(Integer currentPage) {
		Page page=new Page();
		//当前页
		page.setCurrentPage(currentPage);
		// 总记录数
		Integer totalCount=customerDao.findCount();
		page.setTotalCount(totalCount);
		//每页显示数
		Integer pageSize=3;
		page.setPageSize(pageSize);
		//总页数
		Integer totalPage=0;
		if(totalCount%pageSize==0){
			totalPage=totalCount/pageSize;
		}else{
			totalPage=totalCount/pageSize+1;
		}
		page.setTotalPage(totalPage);
		//开始位置
		Integer begin=(currentPage-1)*pageSize;
		page.setBegin(begin);
		//每页显示的具体数据
		List<Customer> list=customerDao.listPage(begin,pageSize);
		page.setList(list);
		return page;
	}
	//条件分页查询
	public Page condition(Integer currentPage, Customer customer) {
		Page page=new Page();
		page.setCurrentPage(currentPage);
		// 总记录数
		Integer totalCount=customerDao.findConditionCount(customer);
		page.setTotalCount(totalCount);
		//每页显示数
		Integer pageSize=3;
		page.setPageSize(pageSize);
		//总页数
		Integer totalPage=0;
		if(totalCount%pageSize==0){
			totalPage=totalCount/pageSize;
		}else{
			totalPage=totalCount/pageSize+1;
		}
		page.setTotalPage(totalPage);
		//开始位置
		Integer begin=(currentPage-1)*pageSize;
		page.setBegin(begin);
		//每页显示的具体数据
		List<Customer> list=customerDao.listConditionPage(begin,pageSize,customer);
		page.setList(list);
		return page;
	}
}
