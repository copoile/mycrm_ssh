package com.briup.entity;

public class Visit {
	//拜访记录
	private Integer id;
	private String address;
	private String countent;
	
	//记录所属客户
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	//记录所属用户
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountent() {
		return countent;
	}
	public void setCountent(String countent) {
		this.countent = countent;
	}
}
