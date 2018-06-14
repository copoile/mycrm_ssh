package com.briup.entity;

import java.util.HashSet;
import java.util.Set;

public class Customer {
	private Integer id;
	private String	custName;
	private String custLevel;
	private String custSource;
	private String custLinkman;
	private Integer custPhone;
	private Integer custMobile;
	private String custAddress;
	private Integer custZip;
	private String custFax;
	private String custWebsite;
	
	//客户的多个拜访记录
	private Set<Customer> setCustomer=new HashSet<Customer>();
	
	public Set<Customer> getSetCustomer() {
		return setCustomer;
	}
	public void setSetCustomer(Set<Customer> setCustomer) {
		this.setCustomer = setCustomer;
	}
	//表示所有的联系人
	private Set<LinkMan> setLinkMan = new HashSet<LinkMan>();
	public Set<LinkMan> getSetLinkMan() {
		return setLinkMan;
	}
	public void setSetLinkMan(Set<LinkMan> setLinkMan) {
		this.setLinkMan = setLinkMan;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustLevel() {
		return custLevel;
	}
	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}
	public String getCustSource() {
		return custSource;
	}
	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}
	public String getCustLinkman() {
		return custLinkman;
	}
	public void setCustLinkman(String custLinkman) {
		this.custLinkman = custLinkman;
	}
	public Integer getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(Integer custPhone) {
		this.custPhone = custPhone;
	}
	public Integer getCustMobile() {
		return custMobile;
	}
	public void setCustMobile(Integer custMobile) {
		this.custMobile = custMobile;
	}
	public String getCustAddress() {
		return custAddress;
	}
	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}
	public Integer getCustZip() {
		return custZip;
	}
	public void setCustZip(Integer custZip) {
		this.custZip = custZip;
	}
	public String getCustFax() {
		return custFax;
	}
	public void setCustFax(String custFax) {
		this.custFax = custFax;
	}
	public String getCustWebsite() {
		return custWebsite;
	}
	public void setCustWebsite(String custWebsite) {
		this.custWebsite = custWebsite;
	}
}
