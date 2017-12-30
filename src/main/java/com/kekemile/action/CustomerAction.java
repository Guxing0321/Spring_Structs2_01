package com.kekemile.action;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.kekemile.service.CustomerService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * action 的测试类
 * 
 * @author xingu
 *
 */
public class CustomerAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * web端保存客户的action
	 * 
	 * @return
	 */
	public String save() {

		System.out.println("Structs2,保存客户的方法。。。。。。。");
		/*
		 * ApplicationContext ac = new
		 * ClassPathXmlApplicationContext("Spring/applicationContext.xml");
		 * CustomerService cs = (CustomerService) ac.getBean("customerService");
		 * cs.save();
		 */

		// 使用web工厂来获取context对象
		ServletContext servletContext = ServletActionContext.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		CustomerService cs = (CustomerService) context.getBean("customerService");
		cs.save();
		return SUCCESS;

	}

}
