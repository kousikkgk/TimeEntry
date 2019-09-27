package com.webapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EntryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EntryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		try { 
			  
            // Initialize the database 
			Class.forName("com.mysql.jdbc.Driver");
	   		// loads driver
			final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
			final String DB_URL = "jdbc:mysql://localhost:3306/tops";
			final String USER = "root";
			final String PASS = "root"; 

			Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
			Statement statement = conn.createStatement() ;
	  		ResultSet rs=null;
	  		rs=statement.executeQuery("SELECT project_id FROM emp_proj WHERE emp_id= "+session.getAttribute("id")+"");
	  		rs.next();
	  		
            int projId=rs.getInt(1);
            int empID=(int)session.getAttribute("id");
            String empName=(String)session.getAttribute("name");
            String wrName=request.getParameter("wrkreq");
            String lcmName=request.getParameter("proj_process");
            String process="Monitor System Operations";
            String activity=request.getParameter("activity");
            String activityDesc="Monitor System Operations - Monitor Application";
            String wrkUnit=request.getParameter("wrkunit");
            String WrkUntType="Usecase";
            String remarks="remarks";
            //java.sql.Timestamp=(java.sql.Timestamp)session.getAttribute("stDate");
         //   System.out.println(Double.parseDouble(request.getParameter("mon")));
           // double mon=Double.valueOf(request.getParameter("mon"));
            //DecimalFormat df = new DecimalFormat("0.00");
            //float mon=Float.parseFloat(request.getParameter("mon"));
           // Double mon1=new Double(request.getParameter("mon"));
            	        //double mon=Double.parseDouble(request.getParameter("mon"));
	       // System.out.println("Moday"+request.getParameter("mon"));
	        double mon=Double.parseDouble(request.getParameter("mon"));
	        double tue=Double.parseDouble(request.getParameter("tue"));
            double wed=Double.parseDouble(request.getParameter("wed"));
            double thu=Double.parseDouble(request.getParameter("thu"));
            double fri=Double.parseDouble(request.getParameter("fri"));
            double sat=Double.parseDouble(request.getParameter("sat"));
            double sun=Double.parseDouble(request.getParameter("sun"));
            // A SQL query to insert data into demo table
            PreparedStatement st = conn.prepareStatement("insert into timeentries (project_id, emp_id,emp_name, wr_name, lcm_name, process, activity, activity_desc, work_unit, work_unit_type, remarks, start_week, mon, tue, wed, thu, fri, sat, sun, flag1, flag2, flag3, flag4, flag5, flag6, flag7, update_flag) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); 
  
            st.setInt(1, projId);
            st.setInt(2, empID);
            st.setString(3, empName);
            st.setString(4, wrName);
            st.setString(5, lcmName);
            st.setString(6, process);
            st.setString(7, activity);
            st.setString(8, activityDesc);
            st.setString(9, wrkUnit);
            st.setString(10, WrkUntType);
            st.setString(11, remarks);
            st.setTimestamp(12, (java.sql.Timestamp)session.getAttribute("stDate"));
            //st.setDate(12, (java.sql.Date)session.getAttribute("stDate"));
            st.setDouble(13, mon);
            st.setDouble(14,tue);
            st.setDouble(15,wed);
            st.setDouble(16,thu);
            st.setDouble(17,fri);
            st.setDouble(18,sat);
            st.setDouble(19,sun);
            
            	if (mon==0.0)
					st.setString(20, "N");
				else
					st.setString(20, "Y");
            	if (tue==0.0)
					st.setString(21, "N");
				else
					st.setString(21, "Y");
            	if (wed==0.0)
					st.setString(22, "N");
				else
					st.setString(22, "Y");
            	if (thu==0.0)
					st.setString(23, "N");
				else
					st.setString(23, "Y");
            	if (fri==0.0)
					st.setString(24, "N");
				else
					st.setString(24, "Y");
            	if (sat==0.0)
					st.setString(25, "N");
				else
					st.setString(25, "Y");
            	if (sun==0.0)
					st.setString(26, "N");
				else
					st.setString(26, "Y");
            	st.setString(27, "Y");
            	st.executeUpdate();
            //}
            
            // Close all the connections
            statement.close();
           // st.close(); 
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
