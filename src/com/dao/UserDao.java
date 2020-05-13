package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.AdminBean;
import com.util.DBConnection;

public class UserDao {
Connection conn;
PreparedStatement pre;
ResultSet res;
public AdminBean Login(String Useremail,String Userpassword)
{
	AdminBean adminBean=new AdminBean();
	conn=DBConnection.getDBConnection();
	if(conn!=null)
	{
		String selectsql="select * from Admin where eemail=? AND epassword=?";
		try {
			pre=conn.prepareStatement(selectsql);
			pre.setString(1,);
			pre.setString(2,adminBean.getePassword());
			res=pre.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	return null;
	
}

}
