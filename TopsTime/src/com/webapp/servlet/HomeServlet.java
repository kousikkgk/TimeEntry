package com.webapp.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//GetConnection gc = new GetConnection();
		TimePOJO tPojo = new TimePOJO();
		System.out.println(request.getParameter("data").substring(5));
		tPojo.setProjectName(request.getParameter("data").substring(5));
		request.setAttribute("pName",tPojo.getProjectName());
		
		// System.out.println(request.getParameter("data").substring(5));
		// request.getRequestDispatcher("home.jsp").forward(request, response);
		/*
		 * switch(request.getParameter("data").substring(0, 5)) { case "pName": {
		 * request.setAttribute("pName",request.getParameter("data").substring(5));
		 * request.getRequestDispatcher("home.jsp").forward(request, response); break; }
		 * }
		 */
		/*
		 * String stDate=request.getParameter("dateaj"); System.out.println(stDate); try
		 * { SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd"); java.util.Date
		 * date = sdf1.parse(stDate);
		 * 
		 * java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
		 * System.out.println(sqlStartDate); Calendar c = Calendar.getInstance(); try{
		 * c.setTime(sdf1.parse(stDate)); }catch(ParseException e){ e.printStackTrace();
		 * } //Incrementing the date by 1 day c.add(Calendar.DAY_OF_MONTH, 6); //String
		 * newDate = sdf1.format(c.getTime());
		 * //System.out.println("Date Incremented by One: "+newDate); java.sql.Timestamp
		 * sqlStartdate = new java.sql.Timestamp(sqlStartDate.getTime());
		 * System.out.println(sqlStartdate);
		 * 
		 * 
		 * 
		 * Date d = new SimpleDateFormat("YYYY/MM/dd").parse(stDate); java.sql.Date d1 =
		 * new java.sql.Date(d.getTime()); System.out.println(d1);
		 * 
		 * } catch (ParseException e) { e.printStackTrace(); }
		 */
		/*
		 * 
		 * request.setAttribute("pName",request.getParameter("pName"));
		 * request.setAttribute("projpros",request.getParameter("pPros"));
		 * request.getRequestDispatcher("home.jsp").forward(request, response);
		 */
		/*
		 * ServletContext context=getServletContext();
		 * System.out.println(request.getParameter("pName"));
		 * context.setAttribute("pName",request.getParameter("pName"));
		 * System.out.println(request.getParameter("pPros"));
		 * context.setAttribute("projpros",request.getParameter("pPros"));
		 */

		/*
		 * HttpSession session=request.getSession();
		 * response.setContentType("text/text"); try { String projName
		 * =request.getParameter("pName").trim(); if(projName!=null &&
		 * !projName.isEmpty()) { session.setAttribute("proname",projName);
		 * //System.out.println(projName); } }catch(NullPointerException e) {
		 * //System.out.println("Pname null"); }
		 * 
		 * try { String projPros = request.getParameter("pPros").trim();
		 * 
		 * if(projPros!=null && !projPros.isEmpty()) { //System.out.println(projPros);
		 * session.setAttribute("projpros", projPros); } }catch(NullPointerException e)
		 * {//System.out.println("PPros null"); }
		 */
	}

}
