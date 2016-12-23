package com.mycon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MyConn {
	private InitialContext ct=null;
	public Connection con=null;
	private DataSource ds=null;
	private ResultSet rs=null;
	private Statement st=null;
	public PreparedStatement ps=null;
	//构造函数，连接池
	public MyConn()
	{
		try{
			ct=new InitialContext();
			ds=(DataSource)ct.lookup("java:comp/env/jdbc/wanted");
			con=ds.getConnection();	
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	//执行查询
	public ResultSet executeQuery(String sql)
	{
		try{
			st=con.createStatement();
			rs=st.executeQuery(sql);				
		}catch(Exception e){
			e.printStackTrace();
		}
		return rs;		
	}
	
	//执行修改，插入，删除
	public int executeUpdate(){		
		int count=0;
		try{
			ps.executeUpdate();
			if(count!=0){
				con.commit();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;		
	}
	//删除
	public int executeDelete(String sql){		
		int count=0;
		try{
			ps=null;
			ps=con.prepareStatement(sql);
			ps.executeUpdate();
			if(count!=0){
				con.commit();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;		
	}
	
	
	//关闭连接
	public void close(){
		try{
			if(rs!=null){
				rs.close();
			}
			if(st!=null){
				st.close();
			}
			if(con!=null){
				con.close();
				con=null;
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("error occured to DB connection");
		}
	}
	//返回连接
	public Connection returnConn(){
		return con;
	}
	

}
