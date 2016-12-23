package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.entity.Comment;
import com.mycon.MyConn;

public class CommentDAO {
	ResultSet rs = null;
	public String create(Comment comment)
	{
		MyConn conn = new MyConn();
		try{
			
			String sql="insert into Comments(name,commenter,context) values (?,?,?)";
			conn.ps=conn.con.prepareStatement(sql);
			conn.ps.setString(1, comment.getName());
			conn.ps.setString(2, comment.getCommenter());
			conn.ps.setString(3, comment.getContext());		
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
	public ArrayList<Comment> listAll(String name)
	{
		ArrayList<Comment> list=new ArrayList<Comment>();
		MyConn conn = new MyConn();
		try{
			String sql="select * from Comments where name='"+name+"'";
			rs=conn.executeQuery(sql);
			while(rs.next())
			{
				Comment temp = new Comment();
				temp.setName(rs.getString("name"));
				temp.setCommenter(rs.getString("commenter"));
				temp.setContext(rs.getString("context"));
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
	

}
