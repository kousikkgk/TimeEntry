package com.webapp.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

 
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

		public LoginServlet() {

			super();

}

 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String uName=request.getParameter("uname");
	 String pWord=request.getParameter("pass");
	 
// Connect to mysql and verify username password

   try 
   	{
	   Class.forName("com.mysql.jdbc.Driver");
	   		// loads driver
	   final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   final String DB_URL = "jdbc:mysql://localhost:3306/tops";
	   final String USER = "root";
	   final String PASS = "root"; 

	   Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
	   PreparedStatement ps = conn.prepareStatement("select * from Employee where emp_id=? and password=?");
	   ps.setString(1, uName);
	   ps.setString(2, pWord);
	   ResultSet rs = ps.executeQuery();

	   
 
	   while (rs.next()) {
		// TO PASS THE USER ID TO HOME PAGE.
		   String name = request.getParameter("uname");
		   //System.out.println(name);
		   HttpSession session=request.getSession(); 
		   String nameDB=rs.getString(2);
		   int id=rs.getInt(1);
		   //System.out.println(id);
		   
		   
				/*
				 * String selectedItem; if(request.getParameter("proj")!=null) {
				 * selectedItem=request.getParameter("proj");
				 * session.setAttribute("proj",selectedItem); System.out.println(selectedItem);
				 * }
				 */
		   
		   session.setAttribute("id",id);
		  //request.setAttribute("id",id);
		   session.setAttribute("name", nameDB );
		  // String nameDB=rs.getString(2);
		   ServletContext context= getServletContext();
		   RequestDispatcher rd= context.getRequestDispatcher("/home.jsp");
		   rd.forward(request, response);
        	   return;
           }
        response.sendRedirect("./error.html");
        		return;
   			} 
   		catch (ClassNotFoundException | SQLException se) {
   			se.printStackTrace();
   			}
 			}

}