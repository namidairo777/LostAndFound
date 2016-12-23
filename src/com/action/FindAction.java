package com.action;

import com.dao.PickupthingsDAO;
import com.entity.Pickupthings;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class FindAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pickupthings pickupthings;


	
	public Pickupthings getPickupthings() {
		return pickupthings;
	}

	public void setPickupthings(Pickupthings pickupthings) {
		this.pickupthings = pickupthings;
	}

	//创建
	public String create() throws Exception
	{
		System.out.println("LostAction-create");
		PickupthingsDAO pickupthingsDAO=new PickupthingsDAO();
		String result=pickupthingsDAO.create(pickupthings);
		return result;
	}
	
	//修改
	public String update()
	{
		PickupthingsDAO pickupthingsDAO=new PickupthingsDAO();
		return pickupthingsDAO.update(pickupthings);
	}
	
	//获取列表
	public String listAll()
	{
		System.out.println("LostAction-list");
		PickupthingsDAO pickupthingsDAO=new PickupthingsDAO();
		ActionContext ac = ActionContext.getContext(); 
		ac.getSession().put("list", pickupthingsDAO.listAll());
		return "success";
	}

}
