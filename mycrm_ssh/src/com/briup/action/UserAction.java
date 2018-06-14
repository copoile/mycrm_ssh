package com.briup.action;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.briup.entity.User;
import com.briup.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private User user=new User();
	@Override 
	public User getModel() {
		return user;
	}
	
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//添加用户
	public String add(){
		userService.add(user);
		return NONE;
	}
	
	public String login(){
		User u=userService.login(user);
		if(u!=null){
			//登录成功
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("user",u);
			return "loginsuccess";
		}
		return "login";
	}


}
