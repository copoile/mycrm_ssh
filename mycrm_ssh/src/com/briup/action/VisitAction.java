package com.briup.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.briup.entity.Customer;
import com.briup.entity.User;
import com.briup.entity.Visit;
import com.briup.service.CustomerService;
import com.briup.service.UserService;
import com.briup.service.VisitService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class VisitAction extends ActionSupport implements ModelDriven<Visit>{
	
	private Visit visit=new Visit();
	@Override
	public Visit getModel() {
		return visit;
	}
	private VisitService visitService;
	private CustomerService customerService;
	private UserService userService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}
	//到拜访添加页面
	public String toAddPage(){
		//需要查询出所有的用户和客户
		List<User> listUser = userService.list();
		List<Customer> listCustomer = customerService.list();
		ServletActionContext.getRequest().setAttribute("listUser", listUser);
		ServletActionContext.getRequest().setAttribute("listCustomer", listCustomer);
		return "toAddPage";
	}
	//添加拜访记录
	private Integer cid;
	private Integer uid;
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}
	//添加客户拜访记录
	public String add(){
		User user = userService.findOneById(uid);
		Customer customer = customerService.findOnceById(cid);
		visit.setUser(user);
		visit.setCustomer(customer);
		visitService.add(visit);
		return SUCCESS;
	}
	 //查询所有拜访记录
	public String list(){
	List<Visit>	list=visitService.list();
	ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}

}
