package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.LostthingsDAO;
import com.entity.Lostthings;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LostAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Lostthings lostthings;

	public Lostthings getLostthings() {
		return lostthings;
	}

	public void setLostthings(Lostthings lostthings) {
		this.lostthings = lostthings;
	}
	
	//����
	public String create() throws Exception
	{
		System.out.println("LostAction-create");
		LostthingsDAO lostthingsDAO=new LostthingsDAO();
		String result=lostthingsDAO.create(lostthings);
		return result;
	}
	
	//�޸�
	public String update()
	{
		LostthingsDAO lostthingsDAO=new LostthingsDAO();
		return lostthingsDAO.update(lostthings);
	}
	//���
	public String finish()
	{
		LostthingsDAO lostthingsDAO=new LostthingsDAO();
		HttpServletRequest request=ServletActionContext.getRequest();
		String value= request.getParameter("name").toString();
		lostthingsDAO.finish(value);
		return "success";
		
	}
	//ɾ��
	public String delete()
	{
		LostthingsDAO lostthingsDAO=new LostthingsDAO();
		HttpServletRequest request=ServletActionContext.getRequest();
		String value= request.getParameter("name").toString();
		lostthingsDAO.delete(value);
		return "success";
	}
	//��ѯһ����¼
	/*public String queryOne()
	{
		LostthingsDAO lostthingsDAO=new LostthingsDAO();
		Lostthings temp=lostthingsDAO.update(lostthings);
		return "success";
	}*/
	
	//
	public String listOne()
	{
		LostthingsDAO lostthingsDAO=new LostthingsDAO();
		ActionContext ac = ActionContext.getContext(); 
		HttpServletRequest request=ServletActionContext.getRequest();
		String value= request.getParameter("name").toString();
		ac.getSession().put("list", lostthingsDAO.listOne(value));
		ac.getSession().put("name", value);
		return "success";
	}
	
	//��ȡ�б�
	public String listAll()
	{
		LostthingsDAO lostthingsDAO=new LostthingsDAO();
		ActionContext ac = ActionContext.getContext(); 
		ac.getSession().put("list", lostthingsDAO.listAll());
		return "success";
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
