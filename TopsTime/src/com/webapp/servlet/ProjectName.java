package com.webapp.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.google.gson.Gson;

/**
 * Servlet implementation class ProjectName
 */
public class ProjectName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//System.out.println(request.getParameter("data"));
		HttpSession session=request.getSession();
		try {
			
			request.setAttribute("pName",request.getParameter("data"));
			String oldDate=request.getParameter("dateaj");
			
			String proName=request.getParameter("data");

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Calendar c = Calendar.getInstance();

            try{

                  

                   /*convert String into java date format and check the date is monday or not */

                   java.util.Date startDate = sdf.parse(oldDate);

                   Calendar cal = Calendar.getInstance();

                   cal.setTime(startDate);

                   boolean monday = cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY;

                   /*-------------------------------------------------------------------*/

                  

                   if (monday==true) {

                         /*Add 6 days from input date */

                         c.setTime(sdf.parse(oldDate));

                         c.add(Calendar.DAY_OF_MONTH, 6);

                         String newDate = sdf.format(c.getTime());

                         /*-----------------------------*/

                        

                         /*Convert input java date into sql timeStamp */

                         java.sql.Timestamp sqlStartDate = new java.sql.Timestamp(startDate.getTime());

                         System.out.println(sqlStartDate);
                         session.setAttribute("stDate", sqlStartDate);
                         
                         /*-----------------------------*/

                        

                         /*Convert Enddate intojava date and then convert into sql timeStamp */

                         java.util.Date endDate = sdf.parse(newDate);

                         java.sql.Timestamp sqlEndDate = new java.sql.Timestamp(endDate.getTime());
                         session.setAttribute("endDate", sqlEndDate);
                         System.out.println(sqlEndDate);

                   }

                   else

                   {

                         System.out.println("not Monday.....");

                   }



            }catch(Exception e)

            {

                   e.printStackTrace();

            }

          
			
			
			Class.forName("com.mysql.jdbc.Driver");
	        final String DB_URL = "jdbc:mysql://localhost:3306/tops";
	        final String USER = "root";
	        final String PASS = "root";
	      	Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
	  		Statement statement = conn.createStatement() ;
	  		ResultSet rs=null;
	  		String query=("select distinct a.LCM_NAME from LCM a,plan_activity b,process c,project d where b.emp_id="+session.getAttribute("id")+" and b.plan_name=c.pro_name and c.lcm_id=a.lcm_id and b.proj_id=d.project_id and d.project_name='"+proName+"' ");
	  		rs =statement.executeQuery(query) ;
	  		
	  		
	  		
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
	  		//System.out.println(jsonArray);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
