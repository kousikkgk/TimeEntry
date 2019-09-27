package com.webapp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Servlet implementation class WorkRequestServlet
 */
public class WorkRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			
			request.setAttribute("pName",request.getParameter("data"));
			String proName=request.getParameter("data");
			//System.out.println(proName);
			Class.forName("com.mysql.jdbc.Driver");
	        final String DB_URL = "jdbc:mysql://localhost:3306/tops";
	        final String USER = "root";
	        final String PASS = "root";
	      	Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
	  		Statement statement = conn.createStatement() ;
	  		ResultSet rs=null;
	  		HttpSession session=request.getSession();
	  		int id=(int) session.getAttribute("id");
	  		//System.out.println(id);
	  		String query="select distinct activity_name from plan_activity where emp_id="+session.getAttribute("id")+" and Activity_Status='In-Progress'  and Activity_start_date <='"+session.getAttribute("endDate")+"' and Activity_end_date >='"+session.getAttribute("stDate")+"' and Baseline='Y' and work_request_name= '"+proName+"' and proj_id IN (SELECT project_id FROM emp_proj WHERE emp_id= "+session.getAttribute("id")+") order by activity_name";
	  		System.out.println(query);
	  		
	  		rs =statement.executeQuery(query);
	  		//System.out.println(query);
	  		//rs =statement.executeQuery(query) ;
	  		JSONObject responseDetailsJson = new JSONObject();
	  	    JSONArray jsonArray = new JSONArray();
	  		List lst=new ArrayList<>();
	  		while(rs.next()) {
	  			//int lcmId = rs.getInt(1);
	  			String lcmName = rs.getString(1);
	  			//System.out.println(lcmName);
	  			JSONObject formDetailsJson = new JSONObject();
	  			//formDetailsJson.put("id",lcmId);
	  			formDetailsJson.put("name", lcmName);
	  			jsonArray.add(formDetailsJson);
	  			response.setContentType("application/json");
	  			response.setCharacterEncoding("UTF-8");
	  		}
	  		response.getWriter().write(jsonArray.toString());
	  		//System.out.println(jsonArray);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
