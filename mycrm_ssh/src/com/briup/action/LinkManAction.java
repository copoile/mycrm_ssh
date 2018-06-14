package com.briup.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.briup.entity.Customer;
import com.briup.entity.LinkMan;
import com.briup.service.CustomerService;
import com.briup.service.LinkManService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	
	private LinkMan linkman=new LinkMan();
	@Override
	public LinkMan getModel() {
		return linkman;
	}
	private LinkManService linkManService;
	private CustomerService customerService;
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	//跳转添加联系人
	public String toAddPage(){
		//需要查找出所有的用户，以添加联系人时使用
		List<Customer> list = customerService.list();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toAddPage";
	}
	
	
	
	/*
	 * 上传文件（命名有规则）
	 * */
	//对象web中的name
	private File upload;
	//文件名，表单的name加FileName
	private String uploadFileName;
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	
	private Integer cid;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	//添加联系人
	public String add() throws IOException{
		//如果选择了文件再文件上传操作
		/*文件上传有默认大小，其默认大小为2m
		 * 可以在Struts2默认常量文件查看，可以再Struts.xml配置文件配置大小
		 * */
		if(upload!=null&&!"".equals(upload)){
			//在服务器生成文件/mycrm_ssh/WebContent/files
			String path = ServletActionContext.getRequest().getSession().getServletContext().getRealPath("/");
			System.out.println("文件上传---"+path);
			System.out.println("上传文件名："+uploadFileName);
			File servcefile=new File(path+"files/"+uploadFileName);
			//将上传的文件复制到服务器文件
			FileUtils.copyFile(upload, servcefile);
		}
		
		Customer customer = customerService.findOnceById(cid);
		linkman.setCustomer(customer);
		linkManService.add(linkman);
		return SUCCESS;
	}
	//查询所有联系人
	public String list(){
	List<LinkMan>	list=linkManService.list();
	ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}
}
