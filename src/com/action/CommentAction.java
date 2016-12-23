package com.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.CommentDAO;
import com.entity.Comment;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CommentAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Comment comment;

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}
	//创建
	public String create() throws Exception
	{
		System.out.println("CommentAction-create");
		CommentDAO commentDAO=new CommentDAO();
		String result=commentDAO.create(comment);
		return result;
	}
	//获取列表
	public String listAll()
	{
		System.out.println("CommentAction-list");
		CommentDAO commentDAO=new CommentDAO();
		ActionContext ac = ActionContext.getContext();
		HttpServletRequest request=ServletActionContext.getRequest();
		String value= request.getSession().getAttribute("name").toString();
		
		ac.getSession().put("commentList", commentDAO.listAll(value));
		return "success";
	}
	
}
