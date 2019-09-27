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
 * Servlet implementation class ActivityServlet
 */
public class ActivityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
			
			request.setAttribute("pName",request.getParameter("data"));
			String oldDate=request.getParameter("dateaj");
			//System.out.println(oldDate);
			String proName=request.getParameter("data");
			
			
			
			Class.forName("com.mysql.jdbc.Driver");
	        final String DB_URL = "jdbc:mysql://localhost:3306/tops";
	        final String USER = "root";
	        final String PASS = "root";
	      	Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
	  		Statement statement = conn.createStatement() ;
	  		HttpSession session=request.getSession();
	  		ResultSet rs=null;
	  		System.out.println("select distinct wu_name from work_unit_details where Activity_name='"+proName+"' and lcm_name='"+session.getAttribute("lcm")+"' ");
	  		//System.out.println(request.getParameter("data"));
	  	//	rs =statement.executeQuery(select distinct wu_name from work_unit_details where Activity_name='" + comboBox4.Text + "'and lcm_name='" + comboBox2.Text +) ;
	  		rs =statement.executeQuery("select distinct wu_name from work_unit_details where Activity_name='"+proName+"' and lcm_name='"+session.getAttribute("lcm")+"' ");
	  		
	  		JSONObject responseDetailsJson = new JSONObject();
	  	    JSONArray jsonArray = new JSONArray();
	  		List lst=new ArrayList<>();
	  		while(rs.next()) {
	  			//int lcmId = rs.getInt(1);
	  			String lcmName = rs.getString(1);
	  			JSONObject formDetailsJson = new JSONObject();
	  			//formDetailsJson.put("id",lcmId);
	  			formDetailsJson.put("name", lcmName);
	  			jsonArray.add(formDetailsJson);
	  			response.setContentType("application/json");
	  			response.setCharacterEncoding("UTF-8");
	  		}
	  		response.getWriter().write(jsonArray.toString());
	  		System.out.println(jsonArray);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
