package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.ClientBean;

import com.util.DBConnection;

public class ClientDao {
	Connection conn;
	PreparedStatement pre;
	ResultSet res;
	public boolean addClient(ClientBean clientBean)
	{
		boolean flag=false;
		conn=DBConnection.getDBConnection();
		if(conn!=null)
		{
			String insertsql="insert into client(cfirstname,clastname,cdob,gender,Department,position,phone,cemail,pid)values(?,?,?,?,?,?,?,?,?)";
			try {
				pre=conn.prepareStatement(insertsql);
				pre.setString(1,clientBean.getcFirstname());
				pre.setString(2,clientBean.getcLastname());
				pre.setString(3,clientBean.getcDob());
				pre.setString(4,clientBean.getGender());
				pre.setString(5,clientBean.getDepartment());
				pre.setString(6,clientBean.getPosition());
				pre.setInt(7,clientBean.getPhone());
				pre.setString(8,clientBean.getcEmail());
				pre.setInt(9,clientBean.getpId());
			
				int res=pre.executeUpdate();
				if(res>0)
				{
				flag=true;	
				}
				else
				{
					System.out.println("Data is not sucessfully Inerted");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
		
	}
	public List<ClientBean> getclientdetail()
	{
		conn=DBConnection.getDBConnection();
		List<ClientBean> listOfClients=new ArrayList<ClientBean>();
		if(conn!=null)
		{
			String selectsql="select cid,cfirstname,clastname,cdob,gender,Department,position,phone,cemail,pname from client join Project8 using(pid)";
			try {
				pre=conn.prepareStatement(selectsql);
				res=pre.executeQuery();
				while(res.next())
				{
					ClientBean clientBean=new ClientBean();
					clientBean.setcId(res.getInt("cid"));
					clientBean.setcFirstname(res.getString("cfirstname"));
					clientBean.setcLastname(res.getString("clastname"));
					clientBean.setcDob(res.getString("cdob"));
					clientBean.setGender(res.getString("gender"));
					clientBean.setDepartment(res.getString("Department"));
					clientBean.setPosition(res.getString("position"));
					clientBean.setPhone(res.getInt("phone"));
					clientBean.setcEmail(res.getString("cemail"));
					clientBean.setpName(res.getString("pname"));
					listOfClients.add(clientBean);
					
					
					
				}	
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return listOfClients;
		
	}
	public List<ClientBean>listofClients()
	{
		conn=DBConnection.getDBConnection();
		List<ClientBean> listofClients=new ArrayList<ClientBean>();
		if(conn!=null)
		{
			String selectsql="select * from client";
			try {
				pre=conn.prepareStatement(selectsql);
				res = pre.executeQuery(selectsql);
				while(res.next())
				{
				ClientBean clientBean=new ClientBean();
				clientBean.setcId(res.getInt("cid"));
				clientBean.setcFirstname(res.getString("cfirstname"));
				clientBean.setcLastname(res.getString("clastname"));
				clientBean.setcDob(res.getString("cdob"));
				clientBean.setGender(res.getString("gender"));
				clientBean.setDepartment(res.getString("Department"));
				clientBean.setPosition(res.getString("position"));
				clientBean.setPhone(res.getInt("phone"));
				clientBean.setcEmail(res.getString("cemail"));
				
				listofClients.add(clientBean);
				
				
				
				
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return listofClients;
	}
	
}
		
