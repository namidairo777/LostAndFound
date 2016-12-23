package com.action;




import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.LostthingsDAO;
import com.dao.UserDAO;
import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String confirmPass;
	private User user;
	
	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	//注册
	public String register() throws Exception
	{
		System.out.println("UserAction-register");
		UserDAO userDAO=new UserDAO(); 
		String result=userDAO.register(this.user);
		return result;
	}
	//登录
	public String login() throws Exception
	{
		System.out.println("UserAction-login");
		UserDAO userDAO=new UserDAO(); 
		User loginUser=userDAO.login(this.user);	
		if(loginUser.getPassword().equals(user.getPassword()))
		{
			ActionContext ac = ActionContext.getContext(); 
			ac.getSession().put("userName", loginUser.getName());
			ac.getSession().put("userEmail", loginUser.getMail());
			ac.getSession().put("userQuestion", loginUser.getQuestion());
			ac.getSession().put("userAnswer", loginUser.getAnswer());
			System.out.println(loginUser.getName()+","+loginUser.getMail());
			return "success";
		}
		else
		{
			addFieldError("user.password", "用户名或密码错误！");
			System.out.println("error");
			return "error";
		}
	}
	//登出
	public String logout() throws Exception
	{
		System.out.println("UserAction-logout");
		ActionContext ac = ActionContext.getContext(); 
		ac.getSession().clear();
		return "success";
	}
	//更新用户信息
	public String update()
	{
		UserDAO userDAO=new UserDAO(); 		
		System.out.println("UserAction-update");
		return userDAO.update(user);
	}
	public String listMe()
	{
		LostthingsDAO lostthingsDAO=new LostthingsDAO();
		ActionContext ac = ActionContext.getContext(); 
		HttpServletRequest request=ServletActionContext.getRequest();
		String value= request.getSession().getAttribute("userEmail").toString();
		ac.getSession().put("list", lostthingsDAO.listMe(value));
		return "success";
	}
	

}
