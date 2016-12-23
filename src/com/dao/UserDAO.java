package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import com.entity.User;
import com.mycon.MyConn;

public class UserDAO{
	ResultSet rs = null;
	
	//注册用户
	public String register(User user)
	{
		MyConn conn = new MyConn();
		try{
			String sql="insert into users(name,mail,password,question,answer) values (?,?,?,?,?)";
			conn.ps=conn.con.prepareStatement(sql);
			conn.ps.setString(1, user.getName());
			conn.ps.setString(2, user.getMail());
			conn.ps.setString(3, user.getPassword());
			conn.ps.setString(4, user.getQuestion());
			conn.ps.setString(5, user.getAnswer());
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
	//更新用户信息
	public String  update(User user)
	{
		MyConn conn = new MyConn();
		try{
			System.out.println("userDAO-update");
			String sql="update users set name=?,password=?,question=?,answer=? where mail=?";
			conn.ps=conn.con.prepareStatement(sql);
			conn.ps.setString(1, user.getName());
			conn.ps.setString(2, user.getPassword());
			conn.ps.setString(3, user.getQuestion());
			conn.ps.setString(4, user.getAnswer());
			conn.ps.setString(5, user.getMail());
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
	//删除用户
	public void delete(int id)
	{
		MyConn conn = new MyConn();
		try{
			String sql="delete from users where id= "+id;
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
	//登录
	public User login(User user)
	{
		MyConn conn = new MyConn();
		try{
			String sql="select name,mail,password,question,answer from users where mail='"+user.getMail()+"'";
			rs=conn.executeQuery(sql);
			if(rs.next())
			{
				User user1=new User();
				user1.setName(rs.getString("name"));
				user1.setPassword(rs.getString("password"));
				user1.setMail(user.getMail());
				user1.setQuestion(rs.getString("question"));
				user1.setAnswer(rs.getString("answer"));
				System.out.println("Getting data from DB");
				return user1;
			}
			else{return null;}
			
			
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
				return null;
			}
		}
		
	}
	//登出
	public void logout()
	{
		
	}
	//显示所有用户 
	public ArrayList<User> showAllUser()
	{
		return null;
	}
	public User showInfo()
	{
		return null;
	}
	
}
