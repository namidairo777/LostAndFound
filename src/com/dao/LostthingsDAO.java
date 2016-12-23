package com.dao;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.entity.Lostthings;
import com.mycon.MyConn;

public class LostthingsDAO {
	ResultSet rs = null;
	
	//创建
	public String create(Lostthings lostthings)
	{
		MyConn conn = new MyConn();
		try{
			HttpServletRequest request=ServletActionContext.getRequest();
			String value= request.getSession().getAttribute("userEmail").toString();
			
			lostthings.setEmail(value);
			lostthings.setCategory(0);
			Date d=new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			lostthings.setUpDate(formatter.format(d));
			lostthings.setStatus(0);
			lostthings.setName(lostthings.getEmail()+lostthings.getUpDate());
			String sql="insert into Lostthings(name,category,email,qq,mobile,title,detail,updateTime,status) values (?,?,?,?,?,?,?,?,?)";
			conn.ps=conn.con.prepareStatement(sql);
			conn.ps.setString(1, lostthings.getName());
			conn.ps.setInt(2, lostthings.getCategory());
			conn.ps.setString(3, lostthings.getEmail());
			conn.ps.setString(4, lostthings.getQq());
			conn.ps.setString(5, lostthings.getMobile());
			conn.ps.setString(6, lostthings.getTitle());
			conn.ps.setString(7, lostthings.getDetail());
			conn.ps.setString(8, lostthings.getUpDate());
			conn.ps.setInt(9, lostthings.getStatus());			
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
	public String  update(Lostthings lostthings)
	{
		MyConn conn = new MyConn();
		try{
			System.out.println("LostthingsDAO-update");
			String sql="update lostthings set mobile=?,qq=?,title=?,detail=? where name=?";
			
			conn.ps=conn.con.prepareStatement(sql);
			conn.ps.setString(1, lostthings.getMobile());
			conn.ps.setString(2,lostthings.getQq());
			conn.ps.setString(3, lostthings.getTitle());
			conn.ps.setString(4, lostthings.getDetail());
			conn.ps.setString(5, lostthings.getName());
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
	public ArrayList<Lostthings> listAll()
	{
		ArrayList<Lostthings> list=new ArrayList<Lostthings>();
		MyConn conn = new MyConn();
		try{
			String sql="select * from lostthings";
			rs=conn.executeQuery(sql);
			while(rs.next())
			{
				Lostthings temp = new Lostthings();
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
	//查询用户自己
	public ArrayList<Lostthings> listMe(String email)
	{
		ArrayList<Lostthings> list=new ArrayList<Lostthings>();
		MyConn conn = new MyConn();
		try{
			String sql="select * from lostthings where email='"+email+"' union select * from pickupthings where email='"+email+"'";
			rs=conn.executeQuery(sql);
			while(rs.next())
			{
				Lostthings temp = new Lostthings();
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
	
	//查询一个
	public ArrayList<Lostthings> listOne(String name)
	{
		ArrayList<Lostthings> list=new ArrayList<Lostthings>();
		MyConn conn = new MyConn();
		try{
			String sql="select * from lostthings where name='"+name+"'";
			rs=conn.executeQuery(sql);
			while(rs.next())
			{
				Lostthings temp = new Lostthings();
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
	/*public Lostthings query(Lostthings lostthings)
	{
		MyConn conn = new MyConn();
		try{
			//String sql="delete from lostthings where id= "+id;
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
	//完成
	
	public void finish(String name)
	{
		MyConn conn = new MyConn();
		try{
			String sql="update lostthings set status=1 where name='"+name+"'";
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
	//删除记录
	public void delete(String name)
	{
		MyConn conn = new MyConn();
		try{
			String sql="delete from lostthings where name= '"+name+"'";
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
