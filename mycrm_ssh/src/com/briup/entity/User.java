package com.briup.entity;

import java.util.HashSet;
import java.util.Set;

public class User {
	private Integer id;
	private String username;
	private String password;
	private String address;
	//用户的等多个拜访记录
	private Set<Visit> userSet=new HashSet<Visit>();
	
	public Set<Visit> getUserSet() {
		return userSet;
	}
	public void setUserSet(Set<Visit> userSet) {
		this.userSet = userSet;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
