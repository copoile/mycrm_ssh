package com.briup.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.briup.entity.Customer;
import com.briup.entity.Page;
import com.briup.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer>{
	//模型驱动封装
	
	private Customer customer=new Customer();
	@Override
	public Customer getModel() {
		return customer;
	}

	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	//跳转客户添加页面
	public String toAddPage(){
		return "toAddPage";
	}
	//添加客户
	public String add(){
		customerService.add(customer);
		return SUCCESS;
	}
	
	//将list放在值栈中
	private List<Customer> list;
	public List<Customer> getList() {
		return list;
	}
	//显示所有客户
	public String list(){
	list=customerService.list();
		return "list";
	}
	
	//删除客户
	public String delete(){
		//先查询再删除
		Integer id = customer.getId();
		Customer c=customerService.findOnceById(id);
		
		customerService.delete(c);
		
		return SUCCESS;
	}
	//到更新页面
	public String toUpdatePage(){
		//查询出修改用户信息
		Integer id = customer.getId();
		Customer c = customerService.findOnceById(id);
		ServletActionContext.getRequest().setAttribute("customer", c);
		return "toUpdatePage";
	}
	//更新客户
	public String update(){
		customerService.update(customer);
		return "update";
	}
	
	//属性封装page(默认是第一页)
	private Integer currentPage=1;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	//分页客户
	public String listPage(){
		Page page=customerService.listPage(currentPage);
		ServletActionContext.getRequest().setAttribute("page", page);
		return "listPage";
	}
	
	//条件查询（筛选）
	public String condition(){
		if(customer.getCustName()!=null&&!"".equals(customer.getCustName())){
			//没有条件,显示全部
			Page page=customerService.condition(currentPage,customer);
			ServletActionContext.getRequest().setAttribute("page", page);
		}else{
			Page page=customerService.listPage(currentPage);
			ServletActionContext.getRequest().setAttribute("page", page);
		}
		return "listPage";
	}
	
}
