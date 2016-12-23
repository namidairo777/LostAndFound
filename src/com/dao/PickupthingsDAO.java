package com.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.Pickupthings;
import com.mycon.MyConn;

public class PickupthingsDAO {
ResultSet rs = null;
	
	//创建
	public String create(Pickupthings pickupthings)
	{
		MyConn conn = new MyConn();
		try{
			HttpServletRequest request=ServletActionContext.getRequest();
			String value= request.getSession().getAttribute("userEmail").toString();
			
			pickupthings.setEmail(value);
			pickupthings.setCategory(1);
			Date d=new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			pickupthings.setUpDate(formatter.format(d));
			pickupthings.setStatus(0);
			pickupthings.setName(pickupthings.getEmail()+pickupthings.getUpDate());
			String sql="insert into pickupthings(name,category,email,qq,mobile,title,detail,updateTime,status) values (?,?,?,?,?,?,?,?,?)";
			conn.ps=conn.con.prepareStatement(sql);
			conn.ps.setString(1, pickupthings.getName());
			conn.ps.setInt(2, pickupthings.getCategory());
			conn.ps.setString(3, pickupthings.getEmail());
			conn.ps.setString(4, pickupthings.getQq());
			conn.ps.setString(5, pickupthings.getMobile());
			conn.ps.setString(6, pickupthings.getTitle());
			conn.ps.setString(7, pickupthings.getDetail());
			conn.ps.setString(8, pickupthings.getUpDate());
			conn.ps.setInt(9, pickupthings.getStatus());			
			conn.executeUpdate();
			conn.ps=null;
			return "success";
		}catch(Exception e)
		{
			e.printStackTrace();
			return "error";
		}finally
		{
			try {
				if (rs != null)
					rs.close();
				conn.close();
				
			} catch (Exception e) {
				return "error";
			}
		}		
		
	}
	//更新记录
	public String  update(Pickupthings pickupthings)
	{
		MyConn conn = new MyConn();
		try{
			System.out.println("pickupthingsDAO-update");
			String sql="update pickupthings set name=?,qq=?,title=?,detail=? where mail=?";
			
			HttpServletRequest request=ServletActionContext.getRequest();
			String value= request.getSession().getAttribute("userEmail").toString();
			pickupthings.setEmail(value);
			Date d=new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			pickupthings.setUpDate(formatter.format(d));
			pickupthings.setName(pickupthings.getEmail()+pickupthings.getUpDate());
			
			conn.ps=conn.con.prepareStatement(sql);
			conn.ps.setString(1, pickupthings.getEmail()+pickupthings.getUpDate());
			conn.ps.setString(2,pickupthings.getQq());
			conn.ps.setString(3, pickupthings.getTitle());
			conn.ps.setString(4, pickupthings.getDetail());
			conn.ps.setString(5, pickupthings.getEmail());
			conn.executeUpdate();
			conn.ps=null;
			return "success";
		}catch(Exception e)
		{
			e.printStackTrace();
			return "error";
		}finally
		{
			try {
				if (rs != null)
					rs.close();
				conn.close();
			} catch (Exception e) {
				return "error";
			}
		}		
	}
	//查询所有
	public ArrayList<Pickupthings> listAll()
	{
		ArrayList<Pickupthings> list=new ArrayList<Pickupthings>();
		MyConn conn = new MyConn();
		try{
			String sql="select * from pickupthings";
			rs=conn.executeQuery(sql);
			while(rs.next())
			{
				Pickupthings temp = new Pickupthings();
				temp.setName(rs.getString("name"));
				temp.setEmail(rs.getString("email"));
				temp.setTitle(rs.getString("title"));
				temp.setQq(rs.getString("qq"));
				temp.setMobile(rs.getString("mobile"));
				temp.setDetail(rs.getString("detail"));
				temp.setUpDate(rs.getString("updateTime"));
				temp.setStatus(rs.getInt("status"));
				list.add(temp);
			}
			return list;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}finally
		{
			try {
				if (rs != null)
					rs.close();
				conn.close();
			} catch (Exception e) {
			}
		}
	}
	
	//查询记录
	/*public pickupthings query(pickupthings pickupthings)
	{
		MyConn conn = new MyConn();
		try{
			//String sql="delete from pickupthings where id= "+id;
			//conn.executeDelete(sql);			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				if (rs != null)
					rs.close();
				conn.close();
			} catch (Exception e) {
			}
		}
	}*/
	
	//删除记录
	public void delete(int id)
	{
		MyConn conn = new MyConn();
		try{
			String sql="delete from pickupthings where id= "+id;
			conn.executeDelete(sql);			
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally
		{
			try {
				if (rs != null)
					rs.close();
				conn.close();
			} catch (Exception e) {
			}
		}	
	}

}
