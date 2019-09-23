package com.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EntryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try { 
			  
            // Initialize the database 
			Class.forName("com.mysql.jdbc.Driver");
	   		// loads driver
			final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
			final String DB_URL = "jdbc:mysql://localhost:3306/tops";
			final String USER = "root";
			final String PASS = "root"; 

			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
  
            // A SQL query to insert data into demo table
            PreparedStatement st = conn.prepareStatement("insert into timeentries (time_id, project_id, emp_id,emp_name, wr_name, lcm_name, process, activity, activity_desc, work_unit, work_unit_type, remarks, start_week, mon, tue, wed, thu, fri, sat, sun, flag1, flag2, flag3, flag4, flag5, flag6, flag7, update_flag) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); 
  
            // For the first parameter, 
            // get the data using request object 
            // sets the data to st pointer 
            
            st.setInt(1, Integer.valueOf(request.getParameter("proj"))); 
            int id = (int)request.getAttribute("id");
            st.setInt(2, id);
            String name = (String)request.getAttribute("name");
            st.setString(2, name);
            st.setString(2, request.getParameter("proc"));
            st.setString(3, request.getParameter("woreq"));
            st.setString(4, request.getParameter("act"));
            st.setString(5, request.getParameter("worunit"));
            st.setString(6, request.getParameter("mon"));
            st.setString(7, request.getParameter("tue"));
            st.setString(8, request.getParameter("wed"));
            st.setString(9, request.getParameter("thu"));
            st.setString(10, request.getParameter("fri"));
            st.setString(11, request.getParameter("sat"));
            st.setString(12, request.getParameter("sun"));
            st.setString(13, request.getParameter("indt"));
            st.setString(13, "2014-09-08 00:00:00.000000");
            //System.out.println(request.getParameter("indt"));
            // Execute the insert command using executeUpdate() 
            // to make changes in database 
            st.executeUpdate(); 
  
            // Close all the connections 
            st.close(); 
            conn.close(); 
  
            // Get a writer pointer  
            // to display the succesful result 
            PrintWriter out = response.getWriter(); 
            out.println("<html><body><b>Successfully Inserted"
                        + "</b></body></html>"); 
            System.out.println("Inserted..");
        } 
        catch (Exception e) { 
        	e.printStackTrace();
        }
				
	}

}
