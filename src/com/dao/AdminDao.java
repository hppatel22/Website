package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;

import com.bean.AdminBean;

import com.util.DBConnection;

public class AdminDao {
	Connection conn;
	PreparedStatement pre;
	ResultSet res;
	
	public boolean addData(AdminBean adminBean)
	{
		boolean flag=false;
		conn=DBConnection.getDBConnection();
		if(conn!=null)
		{
			int count=0;
			String insertsql="insert into Admin(ename,email,epassword)values(?,?,?)";
			try {
				pre=conn.prepareStatement(insertsql);
				pre.setString(1,adminBean.geteName());
				pre.setString(2,adminBean.geteEmail());
				pre.setString(3,adminBean.getePassword());
				int res=pre.executeUpdate();
				if(res>0)
				{
					System.out.println("Data is sucessfully updated");
				}
				else
				{
					System.out.println("Data is not sucessfully updated");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return flag;
		
	}
	public List<AdminBean>listofAdmins()
	{
		conn=DBConnection.getDBConnection();
		List<AdminBean> listofAdmins=new ArrayList<AdminBean>();
		if(conn!=null)
		{
			String selectsql="select * from Admin where eid =2";
			try {
				pre=conn.prepareStatement(selectsql);
				res = pre.executeQuery(selectsql);
				while(res.next())
				{
				AdminBean adminBean=new AdminBean();
				adminBean.seteId(res.getInt("eid"));
				adminBean.seteName(res.getString("ename"));
				System.out.println(res.getString("ename"));
				adminBean.seteEmail(res.getString("eemail"));
				adminBean.setePassword(res.getString("epassword"));
				
				
				listofAdmins.add(adminBean);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return listofAdmins;
	}
	public int getCount()
	{
		int count=0;
		conn=DBConnection.getDBConnection();
		if(conn!=null)
		{
			System.out.println(conn);
			String selectsql="select * from Admin";
			try {
				pre=conn.prepareStatement(selectsql);
				res=pre.executeQuery();
				while(res.next())
				{
					res.getInt("eid");
					count++;
				}
				System.out.println(count);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return count;
		
	}
	public AdminBean Login(String userEmail,String userPassword)
	{
		AdminBean adminBean=null;
		conn=DBConnection.getDBConnection();
		if(conn!=null)
		{
			String selectsql="select * from Admin where eemail=? AND epassword=?";
			try {
				pre=conn.prepareStatement(selectsql);
				pre.setString(1,userEmail);
				pre.setString(2,userPassword);
				res=pre.executeQuery();
				while(res.next())
				{
					adminBean=new AdminBean();
					adminBean.seteId(res.getInt("eid"));
					adminBean.seteName(res.getString("ename"));
					adminBean.seteEmail(res.getString("eemail"));
					System.out.println(res.getString("eemail"));
					adminBean.setePassword(res.getString("epassword"));
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return adminBean;
		
	}

	public static void main(String[] args) {
		AdminDao adminDao=new AdminDao();
		adminDao.getCount();
		
	}

}
