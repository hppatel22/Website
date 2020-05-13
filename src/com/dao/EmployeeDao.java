package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.AdminBean;
import com.bean.EmployeeBean;
import com.util.DBConnection;

public class EmployeeDao {
	Connection conn;
	PreparedStatement pre;
	ResultSet res;

	public List<EmployeeBean>listofEmployeess()
	{
		conn=DBConnection.getDBConnection();
		List<EmployeeBean> listofEmployeess=new ArrayList<EmployeeBean>();
		if(conn!=null)
		{
			String selectsql="select * from Em22 where eid=1";
			try {
				pre=conn.prepareStatement(selectsql);
				res = pre.executeQuery(selectsql);
				while(res.next())
				{
				EmployeeBean employeeBean=new EmployeeBean();
				employeeBean.seteId(res.getInt("eid"));
				employeeBean.seteName(res.getString("ename"));
				employeeBean.seteEmail(res.getString("eemail"));
				employeeBean.setePassword(res.getString("epassword"));
				employeeBean.setsAl(res.getInt("sal"));
				
				
				listofEmployeess.add(employeeBean);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return listofEmployeess;
	}
}
