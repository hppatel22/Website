package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.AdminBean;
import com.bean.ProjectBean;
import com.util.DBConnection;

public class ProjectDao {
	Connection conn;
	PreparedStatement pre;
	ResultSet res;
	public List<ProjectBean>listofProjects()
	{
		conn=DBConnection.getDBConnection();
		List<ProjectBean> listofProjects=new ArrayList<ProjectBean>();
		if(conn!=null)
		{
			String selectsql="select * from Project8";
			try {
				pre=conn.prepareStatement(selectsql);
				res = pre.executeQuery(selectsql);
				while(res.next()) 
				{
				ProjectBean projectBean=new ProjectBean();
				projectBean.setpId(res.getInt("pid"));
			    projectBean.setpName(res.getString("pname"));
				projectBean.setcAtigery(res.getString("catigery"));
				projectBean.setdUration(res.getString("duration"));
				projectBean.setdEscription(res.getString("description"));
				projectBean.setpCredate(res.getString("pcredate"));
				
				
				
				
				listofProjects.add(projectBean);
				}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return listofProjects;
	}
	
}
